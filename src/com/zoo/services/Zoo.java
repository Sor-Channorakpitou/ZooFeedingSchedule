package com.zoo.services;

import com.zoo.dao.*;
import com.zoo.exceptions.*;
import com.zoo.models.Animal;
import com.zoo.models.Food;
import com.zoo.models.Schedule;
import com.zoo.models.habitat_types.Habitat;
import com.zoo.models.staff_roles.Staff;
import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public static final String ANIMAL_MANAGE   = "ANIMAL_MANAGE";
    public static final String VIEW_REPORT     = "VIEW_REPORT";
    public static final String STAFF_MANAGE    = "STAFF_MANAGE";
    public static final String HABITAT_MANAGE  = "HABITAT_MANAGE";
    public static final String SCHEDULE_MANAGE = "SCHEDULE_MANAGE";
    public static final String FOOD_MANAGE     = "FOOD_MANAGE";

    // States                                                           
    private final String zooName;
    private final String address;
    private String lastMessage;

    private final List<Staff>    users         = new ArrayList<>();
    private final List<Habitat>  habitats      = new ArrayList<>();
    private final List<Food>     foodInventory = new ArrayList<>();
    private final List<Schedule> schedules     = new ArrayList<>();
    private final List<Animal>   animals       = new ArrayList<>();

    // DAOs
    private final AnimalDAO   animalDAO   = new AnimalDAO();
    private final HabitatDAO  habitatDAO  = new HabitatDAO();
    private final FoodDAO     foodDAO     = new FoodDAO();
    private final StaffDAO    staffDAO    = new StaffDAO();
    private final ScheduleDAO scheduleDAO = new ScheduleDAO();

    // Delegated services
    private final StaffService    staffService;
    private final AnimalService   animalService;
    private final HabitatService  habitatService;
    private final FoodService     foodService;
    private final ScheduleService scheduleService;

    private Staff loggedInUser;

    // ------------------------------------------------------------------ //
    //  Constructor                                                         //
    // ------------------------------------------------------------------ //

    public Zoo(String zooName, String address) {
        this.zooName = zooName.trim();
        this.address = address.trim();

        // Wire services (share the same in-memory lists)
        this.staffService    = new StaffService(users, staffDAO);
        this.animalService   = new AnimalService(animals, animalDAO);
        this.habitatService  = new HabitatService(habitats, habitatDAO);
        this.foodService     = new FoodService(foodInventory, foodDAO);
        this.scheduleService = new ScheduleService(schedules, habitats, scheduleDAO);

        initializeData();

        System.out.println("System: Loaded " + animals.size() + " animals from database.");
        loggedInUser = null;
        lastMessage  = "Zoo Created. Default: manager@zoo.com / 12345678";
    }

    public void initializeData() {
        try {
            users.addAll(staffDAO.getAllStaff());
            foodInventory.addAll(foodDAO.getInventory());
            habitats.addAll(habitatDAO.getAllHabitats());
            animals.addAll(animalDAO.getAllAnimals());
            schedules.addAll(scheduleDAO.getAllSchedules());

            // Link animals → habitats in memory
            for (Animal a : animals) {
                for (Habitat h : habitats) {
                    if (a.getHabitatName() != null
                            && a.getHabitatName().equalsIgnoreCase(h.getName())) {
                        h.getAnimals().add(a);
                    }
                }
            }

            System.out.println("Success: Loaded " + animals.size() + " animals.");
        } catch (ZooException e) {
            System.err.println("Sync Error: " + e.getMessage());
        }
    }

    // Auth guards                                                         
    private void requireStaffLogin() throws ZooException {
        if (loggedInUser == null) {
            throw new ZooException("Action denied: staff must login first.");
        }
        if (!loggedInUser.isActive()) {
            loggedInUser = null;
            throw new ZooException("Action denied: staff is inactive (auto logout).");
        }
    }

    private void requirePermission(String action) throws ZooException {
        requireStaffLogin();
        if (!loggedInUser.can(action)) {
            throw new ZooException("Permission denied for action: " + action);
        }
    }

    // Auth                                                         
    public void login(String username, String password) throws ZooException {
        loggedInUser = staffService.login(username, password);
        setLastMessage("Login success. Welcome " + loggedInUser.getName() + "!");
    }

    public void logout() throws ZooException {
        if (loggedInUser != null) {
            String name = loggedInUser.getUsername();
            loggedInUser = null;
            setLastMessage(name + " logged out.");
        }
    }

    // Staff                                                         
    public void createStaff(String fullName, String position, String username, String password,
                            float salary) throws ZooException {
        requirePermission(STAFF_MANAGE);
        staffService.createStaff(fullName, position, username, password, salary);
        setLastMessage(position + " created successfully.");
    }

    public void removeStaff(int staffId) throws ZooException {
        requirePermission(STAFF_MANAGE);
        staffService.removeStaff(staffId);
        setLastMessage("Staff removed successfully.");
    }

    // Animal                                                        
    public void addAnimalToHabitat(Animal animal, Habitat habitat) throws ZooException {
        requirePermission(ANIMAL_MANAGE);
        animalService.addAnimalToHabitat(animal, habitat, loggedInUser);
    }

    public void removeAnimalFromHabitat(Animal animal, Habitat habitat) throws ZooException {
        requirePermission(ANIMAL_MANAGE);
        animalService.removeAnimalFromHabitat(animal, habitat, loggedInUser);
    }

    // Habitat                                                      
    public void createHabitat(String name, String type, int capacity, Food food) throws ZooException {
        requirePermission(HABITAT_MANAGE);
        habitatService.createHabitat(name, type, capacity, food);
        setLastMessage("Habitat created successfully.");
    }

    public void removeHabitat(String name) throws ZooException {
        requirePermission(HABITAT_MANAGE);
        habitatService.removeHabitat(name);
        setLastMessage("Habitat " + name + " removed.");
    }

    // Food                                                         
    public void addFoodToInventory(Food food) throws ZooException {
        foodService.addFoodToInventory(food);
    }

    public void removeFoodFromInventory(int id) throws ZooException {
        foodService.removeFoodFromInventory(id);
    }

    // Schedule                                               
    public void addScheduleToHabitat(Schedule schedule, Habitat habitat) throws ZooException {
        requirePermission(SCHEDULE_MANAGE);
        scheduleService.addScheduleToHabitat(schedule, habitat);
        setLastMessage("Schedule added.");
    }

    public void removeSchedule(int scheduleId) throws ZooException {
        requirePermission(SCHEDULE_MANAGE);
        scheduleService.removeSchedule(scheduleId);
        setLastMessage("Schedule removed successfully.");
    }

    // Validation              
    public static void validateName(String fieldName, String value) throws InvalidNameException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidNameException(fieldName, "(empty)");
        }
        try {
            Double.parseDouble(value.trim());
            throw new InvalidNameException(fieldName, value);
        } catch (NumberFormatException e) {
            // valid name – do nothing
        }
    }

    // Getters                                                             
    public String       getZooName()       { return zooName; }
    public String       getAddress()       { return address; }
    public List<Habitat> getHabitats()     { return habitats; }
    public List<Animal>  getAnimals()      { return animals; }
    public List<Food>    getFoodInventory(){ return foodInventory; }
    public List<Schedule> getSchedules()   { return schedules; }
    public List<Staff>   getUsers()        { return users; }
    public Staff         getLoggedInStaff(){ return loggedInUser; }
    public ScheduleDAO   getScheduleDAO()  { return scheduleDAO; }

    // Internals                                                          
    private void setLastMessage(String msg) { lastMessage = msg; }

    @Override
    public String toString() {
        return "Zoo{"
                + "zooName=" + zooName
                + ", address=" + address
                + ", lastMessage=" + lastMessage
                + ", users=" + users
                + ", habitats=" + habitats
                + ", foodInventory=" + foodInventory
                + ", loggedInUser=" + loggedInUser
                + '}';
    }
}
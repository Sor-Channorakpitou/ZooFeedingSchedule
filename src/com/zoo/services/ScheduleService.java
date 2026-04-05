package com.zoo.services;

import com.zoo.dao.ScheduleDAO;
import com.zoo.exceptions.ZooException;
import com.zoo.models.Schedule;
import com.zoo.models.habitat_types.Habitat;
import java.util.List;

public class ScheduleService {

    private final List<Schedule> schedules;
    private final List<Habitat> habitats;
    private final ScheduleDAO scheduleDAO;

    public ScheduleService(List<Schedule> schedules, List<Habitat> habitats, ScheduleDAO scheduleDAO) {
        this.schedules = schedules;
        this.habitats = habitats;
        this.scheduleDAO = scheduleDAO;
    }

    // CRUD                                                                
    public void addScheduleToHabitat(Schedule schedule, Habitat habitat) throws ZooException {
        habitat.addSchedule(schedule);
        schedules.add(schedule);
    }

    public void removeSchedule(int scheduleId) throws ZooException {
        scheduleDAO.deleteSchedule(scheduleId);

        // Remove from master list
        schedules.removeIf(s -> s.getId() == scheduleId);

        // Remove from each habitat's feeding-time list
        for (Habitat h : habitats) {
            h.getFeedingTimes().removeIf(s -> s.getId() == scheduleId);
        }
    }
}
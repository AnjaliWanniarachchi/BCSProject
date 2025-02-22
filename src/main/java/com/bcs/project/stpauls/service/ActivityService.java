package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Activity;
import com.bcs.project.stpauls.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    // Create or Update activity
    public Activity saveOrUpdateActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    // Get all activities
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    // Get activity by ID
    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    public Activity addActivity(Activity activity) {
        if (activity.getActivity_id() != null && activityRepository.existsById(activity.getActivity_id())) {
            throw new IllegalArgumentException("Activity with ID already exists");
        }
        return activityRepository.save(activity);
    }

    // Delete activity by ID
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}

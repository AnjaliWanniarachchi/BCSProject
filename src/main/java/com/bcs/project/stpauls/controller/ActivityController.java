package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Activity;
import com.bcs.project.stpauls.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com")
@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityservice;

    @PostMapping("/save-activity")
    public ResponseEntity<Activity> saveActivity(@RequestBody Activity activity) {
        return ResponseEntity.ok(activityservice.saveOrUpdateActivity(activity));
    }

    // Get all Activities
    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityservice.getAllActivities();
    }

    // Get Activity by ID
    @GetMapping("/get-activity/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Optional<Activity> activity = activityservice.getActivityById(id);
        return activity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Activity (exclusive)
    @PostMapping("/add-activity")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        try {
            return ResponseEntity.ok(activityservice.addActivity(activity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Activity by ID
    @DeleteMapping("/delete-activity/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        activityservice.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit-activity")
    public ResponseEntity<Activity> editActivity(@RequestBody Activity activity) {
        try {
            // Check if the activity exists by ID
            Optional<Activity> existingActivity = activityservice.getActivityById(activity.getActivity_id());

            if (!existingActivity.isPresent()) {
                // Return a 404 if the activity doesn't exist
                return ResponseEntity.notFound().build();
            }

            // Update the activity information
            Activity updatedActivity = activityservice.saveOrUpdateActivity(activity);

            // Return the updated activity
            return ResponseEntity.ok(updatedActivity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

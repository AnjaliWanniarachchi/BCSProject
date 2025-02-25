package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Activity;
import com.bcs.project.stpauls.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.bcs.project.stpauls.constants.Constants.FRONT_END_URL;

@CrossOrigin(origins = FRONT_END_URL)
@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityservice;

    @PostMapping("/save-activity")
    public ResponseEntity<Activity> saveActivity(@RequestBody Activity activity) {
        return ResponseEntity.ok(activityservice.saveOrUpdateActivity(activity));
    }

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityservice.getAllActivities();
    }

    @GetMapping("/get-activity/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Optional<Activity> activity = activityservice.getActivityById(id);
        return activity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add-activity")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        try {
            return ResponseEntity.ok(activityservice.addActivity(activity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete-activity/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        activityservice.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit-activity")
    public ResponseEntity<Activity> editActivity(@RequestBody Activity activity) {
        try {
            Optional<Activity> existingActivity = activityservice.getActivityById(activity.getActivity_id());
            if (!existingActivity.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Activity updatedActivity = activityservice.saveOrUpdateActivity(activity);
            return ResponseEntity.ok(updatedActivity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

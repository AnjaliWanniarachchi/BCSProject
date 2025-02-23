package com.bcs.project.stpauls.controller;

import com.bcs.project.stpauls.model.Report;
import com.bcs.project.stpauls.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://stpaulspreschool.s3-website.eu-north-1.amazonaws.com")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Create or Update Report
    @PostMapping("/save-report")
    public ResponseEntity<Report> saveReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.saveOrUpdateReport(report));
    }

    // Get all Reports
    @GetMapping("/reports")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    // Get Report by ID
    @GetMapping("/get-report/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        System.out.println("Fetching report with ID: " + id);
        if (id == 0) {
            return ResponseEntity.badRequest().body(null);  // Prevent fetching with an invalid ID
        }

        Optional<Report> report = reportService.getReportById(id);
        return report.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add Report (exclusive)
    @PostMapping("/add-report")
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        try {
            return ResponseEntity.ok(reportService.addReport(report));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete Report by ID
    @DeleteMapping("/delete-report/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit-report")
    public ResponseEntity<Report> editReport(@RequestBody Report report) {
        try {
            // Check if the report exists by ID
            Optional<Report> existingReport = reportService.getReportById(report.getReport_id());

            if (!existingReport.isPresent()) {
                // Return a 404 if the report doesn't exist
                return ResponseEntity.notFound().build();
            }

            // Update the report information
            Report updatedReport = reportService.saveOrUpdateReport(report);

            // Return the updated report
            return ResponseEntity.ok(updatedReport);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

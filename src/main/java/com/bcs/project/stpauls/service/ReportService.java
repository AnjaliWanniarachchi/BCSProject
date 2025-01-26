package com.bcs.project.stpauls.service;

import com.bcs.project.stpauls.model.Report;
import com.bcs.project.stpauls.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // Create or Update report
    public Report saveOrUpdateReport(Report report) {
        return reportRepository.save(report);
    }

    // Get all reports
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // Get report by ID
    public Optional<Report> getReportById(Long id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Invalid ID provided.");
        }
        System.out.println("trying to get report with ID: " + id);
        Optional<Report> report = reportRepository.findById(id);
        System.out.println("Report object" + report);
        if (!report.isPresent()) {
            return Optional.empty();  // Or throw a custom exception
        }
        return report;
    }

    public Report addReport(Report report) {
        if (report.getReport_id() != null && reportRepository.existsById(report.getReport_id())) {
            throw new IllegalArgumentException("Report with ID already exists");
        }
        return reportRepository.save(report);
    }

    // Delete report by ID
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}

package com.intelligent.logistics.controllers;

import com.intelligent.logistics.models.Report;
import com.intelligent.logistics.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<Report> generateReport() {
        logger.info("Generating report");
        Report report = reportService.generateSummaryReport();
        logger.info("Report generated: {}", report);
        return ResponseEntity.ok(report);
    }
}

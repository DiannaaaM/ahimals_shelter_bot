package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.Report;
import pets.shalter.com.ahimals_shelter.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private ReportService reportService = new ReportService();

    public void handleReport(Report report) {
        reportService.createReport(report);
    }

    @PostMapping
    public Report createUser(@RequestBody Report report) {
        return reportService.createReport(report);
    }
}

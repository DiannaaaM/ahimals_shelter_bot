package pets.shalter.com.ahimals_shelter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pets.shalter.com.ahimals_shelter.model.Report;
import pets.shalter.com.ahimals_shelter.service.ReportService;

/**
 * Контроллер для управления отчетами о животных в системе.
 *
 * Этот контроллер обрабатывает HTTP-запросы для создания новых отчетов о состоянии животных.
 */
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private ReportService reportService = new ReportService();

    /**
     * Обрабатывает добавление нового отчета о животном в систему.
     *
     * @param report объект отчета, который необходимо создать.
     */
    public void handleReport(Report report) {
        reportService.createReport(report);
    }

    /**
     * Создает новый отчет о животном на основе переданных данных.
     *
     * @param report объект отчета, который необходимо создать.
     * @return созданный объект отчета.
     */
    @PostMapping
    public Report createUser(@RequestBody Report report) {
        return reportService.createReport(report);
    }
}

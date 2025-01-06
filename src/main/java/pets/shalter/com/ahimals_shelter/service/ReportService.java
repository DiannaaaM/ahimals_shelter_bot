package pets.shalter.com.ahimals_shelter.service;

import org.springframework.stereotype.Service;
import pets.shalter.com.ahimals_shelter.model.Report;
import pets.shalter.com.ahimals_shelter.repository.ReportRepository;

/**
 * Сервис для работы с отсчетами.
 *
 * @property ReportRepository репозиторий для работы с отсчетами.
 */
@Service
public class ReportService {
    private ReportRepository reportRepository;

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }
}

package pets.shalter.com.ahimals_shelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pets.shalter.com.ahimals_shelter.model.Report;
import pets.shalter.com.ahimals_shelter.repository.ReportRepository;
import pets.shalter.com.ahimals_shelter.service.ReportService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportServiceTest {

    @InjectMocks
    private ReportService reportService;

    @Mock
    private ReportRepository reportRepository;

    private Report report;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        report = new Report();
        report.setUserId("1L");
    }

    @Test
    void testCreateReport() {
        when(reportRepository.save(any(Report.class))).thenReturn(report);

        Report createdReport = reportService.createReport(report);

        assertNotNull(createdReport);
        assertEquals("1L", createdReport.getUserId());
        verify(reportRepository).save(report);
    }
}

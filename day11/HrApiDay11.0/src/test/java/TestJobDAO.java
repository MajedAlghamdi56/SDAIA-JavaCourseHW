import org.example.dao.JobDAO;
import org.example.modle.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestJobDAO {

    @InjectMocks
    JobDAO dao;

    @Mock
    Job job;

    @Test
    public void testUpdateDAO() throws SQLException , ClassNotFoundException{
        when(job.getJob_id()).thenReturn(1);
        when(job.getJob_title()).thenReturn("Software Engineer");
        when(job.getMin_salary()).thenReturn(50000.0);
        when(job.getMax_salary()).thenReturn(120000.0);

        Assertions.assertDoesNotThrow(() -> dao.updateJob(job));

        Job newJ = dao.selectJob(job.getJob_id());

        Assertions.assertEquals(newJ.getJob_id(), job.getJob_id());
        Assertions.assertEquals(newJ.getJob_title(), job.getJob_title());
        Assertions.assertEquals(newJ.getMin_salary(), job.getMin_salary());
        Assertions.assertEquals(newJ.getMax_salary(), job.getMax_salary());
    }
}

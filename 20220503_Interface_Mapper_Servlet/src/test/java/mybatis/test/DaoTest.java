package mybatis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.min.edu.dao.IJobsDao;
import com.min.edu.dao.JobsDaoImpl;
import com.min.edu.dto.JobsDto;

public class DaoTest {

	@Test
	public void test() {
		IJobsDao dao = new JobsDaoImpl();
		List<JobsDto> lists = dao.selectAll();
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	

}

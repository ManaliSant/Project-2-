package com.coll.testcase;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDao;
import com.coll.models.Job;

public class JobTestCase {

	static JobDao jobDao;

	@BeforeClass
	public static void setUp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		jobDao = (JobDao) context.getBean("jobDao");
	}

	@Ignore
	@Test
	public void postJob() {

		Job job = new Job();

		//job.setJobid(10);
		
		job.setDesignation("SE");
		job.setExperience(2);
		job.setExpiryDate(new java.util.Date());
		job.setJobdesc("DESC");
		job.setCompanyname("Cognizant");
		job.setSalary(20000);
		job.setSkills("Multi-tasking");

		assertTrue("Problem in Adding job",jobDao.postJob(job));
		}

	
}

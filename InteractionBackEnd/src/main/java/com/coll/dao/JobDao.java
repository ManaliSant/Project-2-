package com.coll.dao;

import java.util.List;

import com.coll.models.Job;

public interface JobDao {
	
	public boolean postJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> listJobDetails();
	public Job getJob(int jobId);

}

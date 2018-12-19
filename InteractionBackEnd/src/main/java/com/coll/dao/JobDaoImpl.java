package com.coll.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.models.Job;

@Transactional
@Repository("jobDao")
public class JobDaoImpl implements JobDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean postJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Job> listJobDetails() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> listJobs=query.list();
		return listJobs;
	}

	@Override
	public Job getJob(int jobId) 
	{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class,jobId);
		return job;
	}
	
	
	

}

package com.coll.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.models.BlogComment;
@Repository("blogCommentDao")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addComment(BlogComment comment)
	{
		try
		{
			sessionFactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteComment(BlogComment comment) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(comment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public BlogComment getBlogComment(int blogCommentId)
	{
		Session session=sessionFactory.openSession();
		BlogComment blogComment=(BlogComment)session.get(BlogComment.class,blogCommentId);
		session.close();
		return blogComment;
	}

	@Override
	public List<BlogComment> listBlogComments(int blogId) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:myBlogId");
		query.setParameter("myBlogId", blogId);
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}
}


package com.coll.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.models.Blog;

@Transactional
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Blog> listBlogs() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Blog");
		List<Blog> listBlogs = query.list();
		return listBlogs;
	}

	@Override
	public Blog getBlog(int blogId) {
		Session session = sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	@Override
	public boolean incrementLikes(int blogId) {
		try {
			Blog blog = this.getBlog(blogId);
			blog.setLikes(blog.getLikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean incrementDisLikes(int blogId) {
		try {
			Blog blog = this.getBlog(blogId);
			blog.setDislike(blog.getDislike() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

package com.coll.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.models.Forum;

@Transactional
@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Forum> listForums() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Forum");
		List<Forum> listForums = query.list();
		return listForums;
	}

	@Override
	public Forum getForum(int forumId) {
		Session session = sessionFactory.openSession();
		Forum forum = (Forum) session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	@Override
	public boolean approveForum(Forum forum) {
		try {
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean rejectForum(Forum forum) {
		try {
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

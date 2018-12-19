package com.coll.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumDao;
import com.coll.models.Forum;

public class ForumTestCase {

	static ForumDao forumDao;

	@BeforeClass
	public static void setUp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		forumDao = (ForumDao) context.getBean("forumDao");
	}

	@Ignore
	@Test
	public void addForumTest() {
		Forum forum = new Forum();
		// forum.setForumId(100);
		forum.setForumname("First forum");
		forum.setForumdesc("This is the first forum");
		forum.setCreatedate(new java.util.Date());
		forum.setUsername("Manasi");
		forum.setStatus("NA");

		assertEquals("Problem in adding Forum", true, forumDao.addForum(forum));
	}

	@Ignore
	@Test
	public void deleteForum() {
		Forum forum = forumDao.getForum(952);

		assertTrue("Problem in Deleting Forum", forumDao.deleteForum(forum));
	}

	@Ignore
	@Test
	public void updateForum() {
		Forum forum = forumDao.getForum(21);
		forum.setForumname("Vanilla Java Forum");

		assertTrue("Problem in Updating the Forum", forumDao.updateForum(forum));
	}

	@Ignore
	@Test
	public void listForumTest() {
		List<Forum> listForums = forumDao.listForums();

		assertTrue("Problem in Listing Forums:", listForums.size() > 0);

		for (Forum forum : listForums) {
			System.out.print(forum.getForumid() + "::");
			System.out.print(forum.getForumname() + "::");
			System.out.println(forum.getForumdesc() + "::");
		}
	}

	@Ignore
	@Test
	public void approveForumTest() {
		Forum forum = forumDao.getForum(52);
		forum.setStatus("A");
		assertTrue("Problem in Approving the Forum:", forumDao.approveForum(forum));
	}

	@Ignore
	@Test
	public void rejectForumTest() {
		Forum forum = forumDao.getForum(152);
		forum.setStatus("NA");
		assertTrue("Problem in Rejecting the Forum:", forumDao.rejectForum(forum));
	}

}

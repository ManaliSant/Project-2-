package com.coll.testcase;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDao;
import com.coll.models.Blog;

public class BlogTestCase {

	static BlogDao blogDao;

	@BeforeClass
	public static void setUp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		blogDao = (BlogDao) context.getBean("blogDao");
	}

	@Ignore
	@Test
	public void addBlogTest() {
		Blog blog = new Blog();
		// blog.setBlogId(100);
		blog.setBlogname("First blog");
		blog.setBlogdesc("This is the first blog");
		blog.setCreatedate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislike(0);
		blog.setUsername("Manali");
		blog.setStatus("NA");

		assertTrue("Problem in Adding Blog",blogDao.addBlog(blog));
	}
	
	@Ignore
	@Test
	public void deleteBlog()
	{
		Blog blog=blogDao.getBlog(2);
		
		assertTrue("Problem in Deleting Blog",blogDao.deleteBlog(blog));
	}
	
	@Ignore
	@Test
	public void updateBlog()
	{
		Blog blog=blogDao.getBlog(21);
		blog.setBlogname("Vanilla Java Blog");
		
		assertTrue("Problem in Updating the Blog",blogDao.updateBlog(blog));
	}
	
	@Ignore
	@Test
	public void listBlogTest()
	{
		List<Blog> listBlogs=blogDao.listBlogs();
		
		assertTrue("Problem in Listing Blogs:",listBlogs.size()>0);
		
		for(Blog blog:listBlogs)
		{
			System.out.print(blog.getBlogid()+"::");
			System.out.print(blog.getBlogname()+"::");
			System.out.println(blog.getBlogdesc()+"::");
		}
	}
	
	@Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDao.getBlog(21);
		blog.setStatus("A");
		assertTrue("Problem in Approving the Blog:",blogDao.approveBlog(blog));
	}
	
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDao.getBlog(22);
		blog.setStatus("NA");
		assertTrue("Problem in Rejecting the Blog:",blogDao.rejectBlog(blog));
	}
	
	
	@Ignore
	@Test
	public void incrementLikes()
	{
		assertTrue("Problem in Incrmenting Likes",blogDao.incrementLikes(21));
	}
	
	@Ignore
	@Test
	public void incrementDisLikes()
	{
		assertTrue("Problem in Decrementing Likes",blogDao.incrementDisLikes(22));
	}

}




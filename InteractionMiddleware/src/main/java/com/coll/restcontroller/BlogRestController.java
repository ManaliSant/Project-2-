package com.coll.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogDao;
import com.coll.models.Blog;

@RestController
public class BlogRestController {

	@Autowired
	BlogDao blogDao;

	@GetMapping("/showAllBlogs")
	public ResponseEntity<List<Blog>> showAllBlogs() {
		List<Blog> listBlogs = blogDao.listBlogs();

		if (listBlogs.size() > 0)
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
		else
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PostMapping("/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog) {
		blog.setCreatedate(new Date());
		blog.setLikes(0);
		blog.setDislike(0);
		blog.setUsername("Manali");
		blog.setStatus("NA");

		if (blogDao.addBlog(blog))
			return new ResponseEntity<String>("Blog Added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/approveBlog/{blogid}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogid") int blogid) {
		Blog blog = (Blog) blogDao.getBlog(blogid);

		if (blogDao.approveBlog(blog)) {
			return new ResponseEntity<String>("Approved", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/rejectBlog/{blogid}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogid") int blogid) {
		Blog blog = (Blog) blogDao.getBlog(blogid);

		if (blogDao.rejectBlog(blog)) {
			return new ResponseEntity<String>("Reject", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/incrementLikes/{blogid}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogid") int blogid) {

		if (blogDao.incrementLikes(blogid)) {
			return new ResponseEntity<String>("Incremented", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/incrementDisLikes/{blogid}")
	public ResponseEntity<String> decrementLikes(@PathVariable("blogid") int blogid) {

		if (blogDao.incrementDisLikes(blogid)) {
			return new ResponseEntity<String>("Increment DisLike", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

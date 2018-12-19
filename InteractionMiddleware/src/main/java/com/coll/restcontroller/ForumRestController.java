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

import com.coll.dao.ForumDao;
import com.coll.models.Forum;

@RestController
public class ForumRestController {

	@Autowired
	ForumDao forumDao;

	@GetMapping("/showAllForums")
	public ResponseEntity<List<Forum>> showAllForums() {
		List<Forum> listForums = forumDao.listForums();

		if (listForums.size() > 0)
			return new ResponseEntity<List<Forum>>(listForums, HttpStatus.OK);
		else
			return new ResponseEntity<List<Forum>>(listForums, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PostMapping("/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum) {
		forum.setCreatedate(new Date());
		forum.setUsername("Mana");
		forum.setStatus("NA");

		if (forumDao.addForum(forum))
			return new ResponseEntity<String>("Forum Added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/approveForum/{forumid}")
	public ResponseEntity<String> approveForum(@PathVariable("forumid") int forumid) {
		Forum forum = (Forum) forumDao.getForum(forumid);

		if (forumDao.approveForum(forum)) {
			return new ResponseEntity<String>("Approved", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/rejectForum/{forumid}")
	public ResponseEntity<String> rejectForum(@PathVariable("forumid") int forumid) {
		Forum forum = (Forum) forumDao.getForum(forumid);

		if (forumDao.rejectForum(forum)) {
			return new ResponseEntity<String>("Reject", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

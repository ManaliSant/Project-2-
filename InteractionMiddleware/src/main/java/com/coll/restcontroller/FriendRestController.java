package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.FriendDao;
import com.coll.models.Friend;
import com.coll.models.UserDetail;

@RestController
public class FriendRestController {

	@Autowired
	FriendDao friendDao;

	@PostMapping(value = "/sendFriendRequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend) {
		if (friendDao.sendFriendRequest(friend))
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/showFriendList/{username}")
	public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username") String username) {
		List<Friend> listFriends = friendDao.showFriendList(username);

		if (listFriends.size() > 0) {
			return new ResponseEntity<List<Friend>>(listFriends, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Friend>>(listFriends, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/showPendingFriendRequest/{username}")
	public ResponseEntity<List<Friend>> showPendingFriendRequestList(@PathVariable("username") String username) {
		List<Friend> listPendingFriendRequests = friendDao.showPendingFriendRequest(username);

		if (listPendingFriendRequests.size() > 0) {
			return new ResponseEntity<List<Friend>>(listPendingFriendRequests, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Friend>>(listPendingFriendRequests, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/showSuggestedFriendList/{username}")
	public ResponseEntity<List<UserDetail>> showSuggestedFriendList(@PathVariable("username") String username) {
		List<UserDetail> listSuggestedFriendList = friendDao.showSuggestedFriend(username);

		if (listSuggestedFriendList.size() > 0) {
			return new ResponseEntity<List<UserDetail>>(listSuggestedFriendList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<UserDetail>>(listSuggestedFriendList, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/acceptFriendRequest/{friendId}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId") int friendId) {
		if (friendDao.acceptFriendRequest(friendId)) {
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId") int friendId) {
		if (friendDao.deleteFriendRequest(friendId)) {
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}

}

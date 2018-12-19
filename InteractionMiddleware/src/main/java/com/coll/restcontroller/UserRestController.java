package com.coll.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.UserDao;
import com.coll.models.UserDetail;

@RestController
public class UserRestController 
{

	@Autowired
	UserDao userDao;
	
	@PostMapping("/registerUser")
	public ResponseEntity<String> register(@RequestBody UserDetail user)
	{
		
		if(userDao.registerUser(user))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/checkUser")
	public ResponseEntity<UserDetail> checkLogin(@RequestBody UserDetail userDetail,HttpSession session)
	{
		UserDetail userDetail1=userDao.checkUserValidation(userDetail.getLoginname(), userDetail.getPassword());
		if(userDetail1!=null)
		{
			session.setAttribute("userDetail", userDetail1);
			return new ResponseEntity<UserDetail>(userDetail1,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(userDetail1,HttpStatus.OK);
		}
		
	}
	
}
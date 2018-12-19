package com.coll.dao;

import java.util.List;

import com.coll.models.Forum;

public interface ForumDao {

	public boolean addForum(Forum forum);

	public boolean deleteForum(Forum forum);

	public boolean updateForum(Forum forum);

	public List<Forum> listForums();

	public Forum getForum(int forumId);

	public boolean approveForum(Forum forum);

	public boolean rejectForum(Forum forum);

}

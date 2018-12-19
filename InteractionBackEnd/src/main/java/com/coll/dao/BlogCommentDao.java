package com.coll.dao;

import java.util.List;

import com.coll.models.BlogComment;

public interface BlogCommentDao {
	
	public boolean addComment(BlogComment comment);
	public boolean deleteComment(BlogComment comment);
	public BlogComment getBlogComment(int blogCommentid);
	public List<BlogComment> listBlogComments(int blogid);


}

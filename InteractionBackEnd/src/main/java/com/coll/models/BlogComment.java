package com.coll.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table
@Entity
@SequenceGenerator(name="blogcommentidseq",sequenceName="blogcommentseq")
public class BlogComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogcommentidseq")
	int commentid;
	
	String commentText;
	String username;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date commentDate;
	int blogid;
	
	public int getCommentId() {
		return commentid;
	}
	public void setCommentId(int commentid) {
		this.commentid = commentid;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	
	
	
	
}
package com.coll.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
@Entity
@Table(name="forum_table")
@SequenceGenerator(name = "forumidseq", sequenceName = "forumidseq")
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumidseq")
	int Forumid;
	String Forumname;
	String Forumdesc;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	Date createdate;
	String username;
	String status;

	

	public int getForumid() {
		return Forumid;
	}

	public void setForumid(int forumid) {
		Forumid = forumid;
	}

	public String getForumname() {
		return Forumname;
	}

	public void setForumname(String Forumname) {
		this.Forumname = Forumname;
	}

	public String getForumdesc() {
		return Forumdesc;
	}

	public void setForumdesc(String Forumdesc) {
		this.Forumdesc = Forumdesc;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

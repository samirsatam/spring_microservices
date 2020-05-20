package com.in28minutes.rest.webservices.restfulwebservices.posts;

public class Post {
	private Integer id;
	private Integer userid;	
	private String desc;
	
	
	public Post(Integer id, Integer userid, String desc) {
		super();
		this.id = id;
		this.userid = userid;
		this.desc = desc;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUserid() {
		return userid;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", userid=" + userid + ", desc=" + desc + "]";
	}
}

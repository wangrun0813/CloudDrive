package com.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String password;
	private String usermane;
	private String contant;
	private String userphoto;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String password, String usermane, String contant,
			String userphoto) {
		this.password = password;
		this.usermane = usermane;
		this.contant = contant;
		this.userphoto = userphoto;
	}
	
	public User(String password, String usermane) {
		this.password = password;
		this.usermane = usermane;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsermane() {
		return this.usermane;
	}

	public void setUsermane(String usermane) {
		this.usermane = usermane;
	}

	public String getContant() {
		return this.contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

	public String getUserphoto() {
		return this.userphoto;
	}

	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}

}
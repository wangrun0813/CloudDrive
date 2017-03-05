package com.entity;

/**
 * Sharefiletable entity. @author MyEclipse Persistence Tools
 */

public class Sharefiletable implements java.io.Serializable {

	// Fields

	private Integer shareid;
	private String hashnumber;
	private String filepswd;

	// Constructors

	/** default constructor */
	public Sharefiletable() {
	}

	/** full constructor */
	public Sharefiletable(String hashnumber, String filepswd) {
		this.hashnumber = hashnumber;
		this.filepswd = filepswd;
	}

	// Property accessors

	public Integer getShareid() {
		return this.shareid;
	}

	public void setShareid(Integer shareid) {
		this.shareid = shareid;
	}

	public String getHashnumber() {
		return this.hashnumber;
	}

	public void setHashnumber(String hashnumber) {
		this.hashnumber = hashnumber;
	}

	public String getFilepswd() {
		return this.filepswd;
	}

	public void setFilepswd(String filepswd) {
		this.filepswd = filepswd;
	}

}
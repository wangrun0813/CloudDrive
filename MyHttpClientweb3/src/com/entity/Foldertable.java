package com.entity;

/**
 * Foldertable entity. @author MyEclipse Persistence Tools
 */

public class Foldertable implements java.io.Serializable {

	// Fields

	private Integer folderid;
	private Integer userid;
	private String fileid;
	private String foldername;
	private String fatherfolderid;

	// Constructors

	/** default constructor */
	public Foldertable() {
	}

	/** full constructor */
	public Foldertable(Integer userid, String fileid, String foldername,
			String fatherfolderid) {
		this.userid = userid;
		this.fileid = fileid;
		this.foldername = foldername;
		this.fatherfolderid = fatherfolderid;
	}
	
	
	public Foldertable(int folderid, String fileid) {
		// TODO Auto-generated constructor stub
		this.folderid=folderid;
		this.fileid = fileid;
	}
	public Foldertable(Integer folderid) {
		this.folderid=folderid;
	}


	public Foldertable(Integer folderid,Integer userid, String fileid, String foldername,
			String fatherfolderid) {
		this.folderid=folderid;
		this.userid = userid;
		this.fileid = fileid;
		this.foldername = foldername;
		this.fatherfolderid = fatherfolderid;
	}

	
	public Foldertable(Integer folderid,Integer userid, String foldername,
			String fatherfolderid) {
		this.folderid=folderid;
		this.userid = userid;
		this.foldername = foldername;
		this.fatherfolderid = fatherfolderid;
	}


	public Foldertable(int userid, String fileid, String foldername,
			String fatherfolderid) {
		this.userid = userid;
		this.fileid = fileid;
		this.foldername = foldername;
		this.fatherfolderid = fatherfolderid;
	}
	
	
	public Foldertable(String fileid) {
		this.fileid = fileid;
	}

	public Foldertable(Integer userid,String foldername,
			String fatherfolderid) {
		this.userid = userid;
		this.foldername = foldername;
		this.fatherfolderid = fatherfolderid;
	}

	
	

	public Integer getFolderid() {
		return this.folderid;
	}

	public void setFolderid(Integer folderid) {
		this.folderid = folderid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFileid() {
		return this.fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getFoldername() {
		return this.foldername;
	}

	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}

	public String getFatherfolderid() {
		return this.fatherfolderid;
	}

	public void setFatherfolderid(String fatherfolderid) {
		this.fatherfolderid = fatherfolderid;
	}

}
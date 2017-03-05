package com.entity;

/**
 * Foldertable entity. @author MyEclipse Persistence Tools
 */

public class Foldertable implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Foldertable [folderid=" + folderid + ", id=" + id + "]";
	}

	private Integer folderid;
	private Integer id;
	private String fileid;
	private String foldername;
	private String fatherfolderid;

	// Constructors

	/** default constructor */
	public Foldertable() {
	}

	/** full constructor */
	public Foldertable(Integer id, String fileid, String foldername,
			String fatherfolderid) {
		this.id = id;
		this.fileid = fileid;
		this.foldername = foldername;
		this.fatherfolderid = fatherfolderid;
	}

	// Property accessors

	public Integer getFolderid() {
		return this.folderid;
	}

	public void setFolderid(Integer folderid) {
		this.folderid = folderid;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
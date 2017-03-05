package com.entity;

/**
 * Filetable entity. @author MyEclipse Persistence Tools
 */

public class Filetable implements java.io.Serializable {

	// Fields

	private Integer fileid;
	private String filename;
	private String hashumber;
	private String filesize;
	private String filetype;
	private String uploadtime;

	// Constructors

	/** default constructor */
	public Filetable() {
	}

	/** full constructor */
	public Filetable(String filename, String hashumber, String filesize,
			String filetype, String uploadtime) {
		this.filename = filename;
		this.hashumber = hashumber;
		this.filesize = filesize;
		this.filetype = filetype;
		this.uploadtime = uploadtime;
	}

	// Property accessors

	public Filetable(int fileid, String filename) {
		// TODO Auto-generated constructor stub
		this.fileid=fileid;
		this.filename = filename;
	}
	public Filetable(Integer fileid, String filename, String hashumber, String filesize,
			String filetype, String uploadtime) {
		this.fileid=fileid;
		this.filename = filename;
		this.hashumber = hashumber;
		this.filesize = filesize;
		this.filetype = filetype;
		this.uploadtime = uploadtime;
	}
	public Integer getFileid() {
		return this.fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getHashumber() {
		return this.hashumber;
	}

	public void setHashumber(String hashumber) {
		this.hashumber = hashumber;
	}

	public String getFilesize() {
		return this.filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

}
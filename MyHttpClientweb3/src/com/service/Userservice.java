package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.entity.Filetable;
import com.entity.Foldertable;
import com.entity.Sharefiletable;
import com.entity.User;

public interface Userservice {

	boolean login(int id, String password);

	User finduser(int id);
//
//	String upload(User user, CommonsMultipartResolver multipartResolver,
//			HttpServletRequest request) throws IllegalStateException,
//			IOException;

	void insertfile(Filetable filetable);

	List<Foldertable> showfloder(String id);

	List<Foldertable> showchildFloder(String fatherid);
//
//	List<Foldertable> showfatherFloder(String fatherid);

	List<Foldertable> showfatherFloder(String fatherid);

	List<Foldertable> showfatherFol2(String fatherString);

	Filetable showfilename(String fileid);

	void insertFolder(Foldertable foldertable);

	void updatefolder(Foldertable foldertable);

	Filetable getfield(String uploadtime);

	Foldertable getbefore(String foiderid);

	Foldertable getFoldertable(String folderid);

	void deletefolder(Foldertable foldertable);

	List<Filetable> showallnumber();

	void sharefile(Sharefiletable sharefiletable);

	void insert(User user);

	Filetable searchfile(int fileid);

	String getsharefile(String hashnumber, String password);

	Filetable getfileidbyhash(String hashnumber);

	String getfileidid(int folderid);

	List<User> findalluser();

	void updatefiletable(Filetable filetable);

	void updatefolder2(Foldertable foldertable);

	Filetable searchbyname(String name);

	Foldertable searchbyfilemyid(String fileid);



}

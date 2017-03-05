package com.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.dao.FiletableDao;
import com.entity.Filetable;
import com.entity.Foldertable;
import com.entity.Sharefiletable;
import com.entity.User;
import com.service.Userservice;
@Service
@Transactional
public class Userserviceimpl extends BasicService implements Userservice{
	@Override
	public boolean login(int id, String password) {
		// TODO Auto-generated method stub
		User user= userDao.findById(id);
		if(user.getPassword().equals(password)){
			return true;
		}
		return false;		
	}
	
	@Override
	public List<User> findalluser(){
		List<User> users=userDao.findAll();
		return users;
	}
	
	
	@Override
	public String getsharefile(String hashnumber, String password) {
		String falseString="";
		// TODO Auto-generated method stub
		List<Sharefiletable> sharefiletablelist=sharefiletableDao.findByHashnumber(hashnumber);
		List passlist=new ArrayList();
		for (int i = 0; i < sharefiletablelist.size(); i++) {
			if (password.equals(sharefiletablelist.get(i).getFilepswd())) {
				falseString="success";
				break;
			}
			else {
				falseString="fail";
			}
		}
		System.out.println("service"+falseString);
		return falseString;
	}
	
	
	@Override
	public Filetable getfileidbyhash(String hashnumber){
	//	String id= sharefiletableDao.findByHashnumber(hashnumber).get(0);
		Filetable filetable =(Filetable) filetableDao.findByHashumber(hashnumber).get(0);
		
		return filetable;
	}
	
	
	@Override
	public String getfileidid(int folderid){

		String fileid=foldertableDao.findById(folderid).getFileid();
		return fileid;
	}
	
	
		
		
	@Override
	public User finduser(int id){
		User user=userDao.findById(id);
		return user;
	}
	@Override
	public void insertFolder(Foldertable foldertable){
		foldertableDao.save(foldertable);
	}
	
	@Override
	public void insertfile(Filetable filetable){
		filetableDao.save(filetable);
	}
	@Override
	public List<Foldertable> showfloder(String id){
		List<Foldertable> foldertables=(List<Foldertable>)foldertableDao.showfloder(id);
		return foldertables;
	
	}
	@Override
	public List<Foldertable> showchildFloder(String fatherid){
		List<Foldertable> foldertables=(List<Foldertable>)foldertableDao.showchildfloder(fatherid);
		return foldertables;
	}
	

	
	@Override
	public List<Foldertable> showfatherFloder(String fatherid){
		System.out.println("service"+fatherid);
		List<Foldertable> foldertables=(List<Foldertable>)foldertableDao.showfatherfloder(fatherid);
		return foldertables;
	}
	

	@Override
	public List<Foldertable> showfatherFol2(String fatherString){
		List<Foldertable> foldertables2=(List<Foldertable>)foldertableDao.findByFatherfolderid(fatherString);
		return foldertables2;
	}
	
	@Override
	public Filetable showfilename(String fileid){
			int id=Integer.parseInt(fileid);
			Filetable filetables=(Filetable)filetableDao.findById(id);
			return filetables;
		
			
	}
	//上传文件在界面显示
	@Override
	public void updatefolder(Foldertable foldertable){
		foldertableDao.updatefol(foldertable);
	}
	
	@Override
	public void updatefiletable(Filetable filetable){
		filetableDao.updatefile(filetable);
	}
	@Override
	public Filetable getfield(String uploadtime){
		Filetable filetables=(Filetable)filetableDao.findByUploadtime(uploadtime).get(0);
		return filetables;	
	}
	@Override
	public Foldertable getbefore(String foiderid){
		int folid=1;
		Foldertable foldertable=(Foldertable) foldertableDao.findById(folid);
		return foldertable;
	}
	@Override
	public Foldertable getFoldertable(String folderid){
		int myid=Integer.parseInt(folderid);
		Foldertable foldertable=(Foldertable) foldertableDao.findById(myid);
		return foldertable;
	}
	@Override
	public void   deletefolder(Foldertable foldertable){
		foldertableDao.delete(foldertable);
		
	}
	

	@Override
	public List<Filetable> showallnumber(){
		List<Filetable> filetables=(List<Filetable>)filetableDao.findAll();
		return filetables;
	}
	
	@Override
	public void sharefile(Sharefiletable sharefiletable){
		sharefiletableDao.save(sharefiletable);

	}
	
	@Transactional
	@Override
	public void insert(User user){
		   userDao.save(user);
		System.out.println(user.getUsermane());
	}
	@Override
	public  Filetable searchfile(int fileid){
		return  filetableDao.findById(fileid);
	}
	
	@Override
	public void updatefolder2(Foldertable foldertable){
		foldertableDao.merge(foldertable);
	}
	
	@Override
	public Filetable searchbyname(String name){
		return  (Filetable) filetableDao.findByFilename(name).get(0);
	}

	@Override
	public Foldertable searchbyfilemyid(String fileid) {
		return  (Foldertable) foldertableDao.findByFileid(fileid).get(0);
	}

}

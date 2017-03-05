package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.dao.UserDao;
import com.entity.Filetable;
import com.entity.Foldertable;
import com.entity.Sharefiletable;
import com.entity.User;

@Controller
@RequestMapping(value = "/user", produces = { "application/json;charset=UTF-8" })
public class UserController extends Basiccontroller {
	String fileName;
	String id;
	String fileid;
	String fileidString = "";
	int userid;
	String filedid;
	String foldername;
	String fileids;
	String fname;

	// 登陆
	@RequestMapping(value = "/login")
	public @ResponseBody
	String login(HttpServletRequest request) {
		id = request.getParameter("uid");
		String password = request.getParameter("upwd");
		int uid = Integer.parseInt(id);
		List<User> users= userserviceimpl.findalluser();
		if (userserviceimpl.login(uid, password)) {
			System.out.println("登陆成功");
			JSONObject user = JSONObject.fromObject(userserviceimpl
					.finduser(uid));
			return user.toString();
		} else {
			System.out.println("登陆失败");
			return "false";
		}
	}
	
	 //注册
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public @ResponseBody
		void register(HttpServletRequest request) {
			String uname=request.getParameter("uname");
			String password=request.getParameter("upwd");	
				User user=new User(password, uname);
				userserviceimpl.insert(user);
				System.out.println("注册成功");
			
	}
		
		
	// 上传文件
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) {
		/*
		 * System.out.println("*************controller****************"); //
		 * 创建一个通用的多部分解析器 CommonsMultipartResolver multipartResolver = new
		 * CommonsMultipartResolver(request.getSession().getServletContext());
		 * // 将文件上传的流交给server层 String result = userserviceimpl.upload(null,
		 * multipartResolver, request); return null;
		 */
		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/"
				+ fileName);
		return null;
	}
	// 插入文件夹
	// 上传文件内容到数据库
	@RequestMapping(value = "/insertfolder", method = RequestMethod.POST)
	public void insertfolder(HttpServletRequest request) {
		String id2 = request.getParameter("id");
		String fatherid = request.getParameter("fatherid");
		// 得到fatherid相同的所有文件夹
		if (fatherid == null) {
			String foldername = "新建文件夹";
			int id12 = Integer.parseInt(id);
			Foldertable foldertable = new Foldertable(id12, foldername,
					fatherid);
			userserviceimpl.insertFolder(foldertable);
		} else {
//			String file = userserviceimpl.showchildFloder(fatherid).get(0)
//					.getFileid();
			String file = "";
			String foldername = "新建文件夹";
			int id = Integer.parseInt(id2);

			Foldertable foldertable = new Foldertable(id, file, foldername,
					fatherid);
			userserviceimpl.insertFolder(foldertable);

		}

	}
	
	
	//搜索searchbyname
	
	@RequestMapping(value = "/searchbyname", method = RequestMethod.POST)
	public @ResponseBody String searchbyname(HttpServletRequest request) {
		String filename = request.getParameter("filename");
	
		String fileid= 	userserviceimpl.searchbyname(filename).getFileid()+"";
		return  fileid;

	}
	//搜索searchfolderbyfileid
	
		@RequestMapping(value = "/searchbyfileid", method = RequestMethod.POST)
		public @ResponseBody String searchbyfileid(HttpServletRequest request) {
			String filemyid = request.getParameter("filemyid");
		
			String fatherfolderid= 	userserviceimpl.searchbyfilemyid(filemyid).getFatherfolderid()+"";
			return  fatherfolderid;

		}

	// 上传文件内容到数据库
	@RequestMapping(value = "/uploadhash", method = RequestMethod.POST)
	public void insertfile(HttpServletRequest request) {
		String hashnumber = request.getParameter("number");
		String filesize = request.getParameter("size");
		// 文件类型
		System.out.println(fileName);
		String[] type = fileName.split("\\.");
		String filetype = type[1];
		// 当前时间
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		Filetable filetable = new Filetable(fileName, hashnumber, filesize,
				filetype, time);
		userserviceimpl.insertfile(filetable);
		// 得到field
		String field = userserviceimpl.getfield(time).getFileid() + "";
		// 得到原来field
		String beforeString = userserviceimpl.getbefore(time).getFileid();
		// 上传到foldertable
		String myfield = beforeString + "," + field;
		System.out.println("myfield" + myfield);
		int folderid = 1;
		int userid = 1;
		String foldername = "Root";
		String fatherfolderid = "0";
		Foldertable foldertable = new Foldertable(folderid, userid, myfield,
				foldername, fatherfolderid);
		userserviceimpl.updatefolder(foldertable);
	}
	
	
	
	//分享的密码验证sharefilepassword
	@RequestMapping(value = "/sharefilepassword", method = RequestMethod.POST)
	public @ResponseBody String sharefilepassword(HttpServletRequest request) {
		String hashnumber = request.getParameter("hashnumber");
		String password = request.getParameter("password");
		String flag=userserviceimpl.getsharefile(hashnumber, password);
		System.out.println("flag"+flag);
		String filid=userserviceimpl.getfileidbyhash(hashnumber).getFileid()+"";
		int folderid = 1;
		int userid = 1;
		String foldername = "Root";
		String fatherfolderid = "0";
		String beforeString = userserviceimpl.getfileidid(folderid);
	
		String myfield = beforeString + "," + filid;
		Foldertable foldertable = new Foldertable(folderid, userid, myfield,
				foldername, fatherfolderid);
		userserviceimpl.updatefolder(foldertable);
		return flag;
	}


	// 展示文件夹
	@RequestMapping(value = "/showfloder", method = RequestMethod.POST)
	public @ResponseBody
	String showfloder(HttpServletRequest request) {
		JSONArray floder = JSONArray.fromObject(userserviceimpl.showfloder(id));
		System.out.println(userserviceimpl.showfloder(id).size());

		for (int i = 0; i < userserviceimpl.showfloder(id).size(); i++) {
			fileid = userserviceimpl.showfloder(id).get(i).getFileid();
			fileidString = fileid + "," + fileidString;
		}
		return floder.toString();
	}

	// 展示文件名字
	@RequestMapping(value = "/showfilename", method = RequestMethod.POST)
	public @ResponseBody
	String showfilename(HttpServletRequest request) {
		String[] fileidarray = fileidString.split(",");
		List myfileidarraylist = new ArrayList();
		for (int i = 0; i < fileidarray.length; i++) {
			if (!myfileidarraylist.contains(fileidarray[i])) {
				myfileidarraylist.add(fileidarray[i]);
			}
		}
		System.out.println("arr" + myfileidarraylist.size());
		List filenameList = new ArrayList();
		for (int j = 0; j < myfileidarraylist.size(); j++) {
			filenameList.add(userserviceimpl.showfilename(fileidarray[j]));
	
		}
		JSONArray filenamelist = JSONArray.fromObject(filenameList);
		System.out.println(userserviceimpl.showfloder(id).size());
		return filenamelist.toString();
	}

	// 展示文件名字(内部)
	@RequestMapping(value = "/getfilename", method = RequestMethod.POST)
	public @ResponseBody
	String getfilename(HttpServletRequest request) {
		String id12 = request.getParameter("myid");
		System.out.println(id12 + "id12");
		// String
		List<Foldertable> list = userserviceimpl.showchildFloder(id12);
		System.out.println("list   length" + list.size());
		if (list.size() == 0) {
			List idList = new ArrayList();
			String idString = "11";
			idList.add(userserviceimpl.showfilename(idString));
			JSONArray filenamelist = JSONArray.fromObject(idList);
			return filenamelist.toString();
		} else {
			List idList = new ArrayList();
			String fi = "";
			for (int i = 0; i < list.size(); i++) {
				String fileidString = list.get(i).getFileid();
				System.out.println(fileidString);
				fi += fileidString + ",";
			}

			String[] fileidqarry = fi.split(",");
			for (int i = 0; i < fileidqarry.length; i++) {
				idList.add(userserviceimpl.showfilename(fileidqarry[i]));
				System.out.println(userserviceimpl.showfilename(fileidqarry[i])
						.getFilename());
			}
			JSONArray filenamelist = JSONArray.fromObject(idList);
			return filenamelist.toString();
		}

	}

	// 展示子文件夹
	@RequestMapping(value = "/showchildfloder", method = RequestMethod.POST)
	public @ResponseBody
	String showchildfloder(HttpServletRequest request) {
		String fatherid = request.getParameter("id");
		JSONArray cildfloder = JSONArray.fromObject(userserviceimpl
				.showchildFloder(fatherid));
		System.out.println(userserviceimpl.showfloder(id).size());
		return cildfloder.toString();
	}

	// 展示父文件夹
	@RequestMapping(value = "/showfatherfloder", method = RequestMethod.POST)
	public @ResponseBody
	String showfatherfloder(HttpServletRequest request) {
		String fatherid = request.getParameter("fatherid");
		System.out.println("controller   fatherid" + fatherid);
		// 得到fatherid相同的所有文件夹
		String fatheridString = userserviceimpl.showfatherFloder(fatherid).get(0).getFatherfolderid();
		System.out.println("controller   fatheridString" + fatheridString);
		if (fatheridString == null) {
			JSONArray cildfloder = JSONArray.fromObject(userserviceimpl
					.showfatherFloder(fatherid));
			return cildfloder.toString();
		} else {
			JSONArray cildfloder = JSONArray.fromObject(userserviceimpl
					.showfatherFol2(fatheridString));
			return cildfloder.toString();
		}

	}

	// 展示所有哈希值
	@RequestMapping(value = "/showallnumber", method = RequestMethod.POST)
	public @ResponseBody
	String showallnumber(HttpServletRequest request) {
		String fatherid = request.getParameter("fatherid");
		JSONArray allnumberlist = JSONArray.fromObject(userserviceimpl.showallnumber());
		return allnumberlist.toString();
	}
	
	

	// 分享
		@RequestMapping(value = "/sharefile", method = RequestMethod.POST)
		public @ResponseBody String sharefile(HttpServletRequest request) {
			String fileid = request.getParameter("adfileid");
			String pswd = request.getParameter("pswd");
			Filetable filetable= userserviceimpl.showfilename(fileid);
		    String hashnum=	 userserviceimpl.showfilename(fileid).getHashumber();
		   Sharefiletable sharefiletable=new Sharefiletable(hashnum,pswd);
		   userserviceimpl.sharefile(sharefiletable);
//			JSONObject filtable = JSONObject.fromObject(filetable);
			System.out.println("后台哈希值"+filetable.getHashumber());
			return hashnum;
		}
		
	
	// showfatherfile父文件
	@RequestMapping(value = "/showfatherfile", method = RequestMethod.POST)
	public @ResponseBody
	String showfatherfile(HttpServletRequest request) {
		String fatherid = request.getParameter("fatherid");
		System.out.println(fatherid + "          fatherid");
		// 得到fatherid相同的所有文件夹
		String fatheridString = userserviceimpl.showfatherFloder(fatherid)
				.get(0).getFatherfolderid();
		if (fatheridString == null) {
			JSONArray cildfloder = JSONArray.fromObject(userserviceimpl.showfatherFloder(fatherid));
			return cildfloder.toString();
		} else {
			// JSONArray cildfloder = JSONArray.fromObject(userserviceimpl
			// .showfatherFol2(fatheridString));
			List<Foldertable> foldertables = userserviceimpl
					.showfatherFol2(fatheridString);
			List idList = new ArrayList();
			String fi = "";
			for (int i = 0; i < foldertables.size(); i++) {
				String fileidString = foldertables.get(i).getFileid();
				System.out.println(fileidString);
				fi += fileidString + ",";
			}

			String[] fileidqarry = fi.split(",");
			for (int i = 0; i < fileidqarry.length; i++) {
				idList.add(userserviceimpl.showfilename(fileidqarry[i]));
				System.out.println(userserviceimpl.showfilename(fileidqarry[i])
						.getFilename());
			}
			JSONArray filenamelist = JSONArray.fromObject(idList);
			return filenamelist.toString();
		}
	}

	// 修改文件夹名字
	@RequestMapping(value = "/updatefoldername", method = RequestMethod.POST)
	public void updatefoldername(HttpServletRequest request) {
		String floderid = request.getParameter("floderid");
		String foldername = request.getParameter("foldername");
		Foldertable foldertable = userserviceimpl.getFoldertable(floderid);
		int userid = foldertable.getUserid();
		String fileid = foldertable.getFileid();
		String fatherfolderid = foldertable.getFatherfolderid();
		int floderid2 = Integer.parseInt(floderid);
		Foldertable foldertable2 = new Foldertable(floderid2, userid, fileid,
				foldername, fatherfolderid);
		// 更新
		userserviceimpl.updatefolder(foldertable2);
	}
	
	//修改文件名字updatefilename
	@RequestMapping(value = "/updatefilename", method = RequestMethod.POST)
	public void updatefilename(HttpServletRequest request) {
		String fileid = request.getParameter("fileid");
		String filename = request.getParameter("filename");
		int myfileid=Integer.parseInt(fileid);
		Filetable filetable = userserviceimpl.searchfile(myfileid);
		String hashnumber=filetable.getHashumber();
		String filesize=filetable.getFilesize();
		String filetype=filetable.getFiletype();
		String uploadtime=filetable.getUploadtime();
		Filetable newFiletable=new Filetable(myfileid,filename,hashnumber,filesize,filetype,uploadtime);
		
		// 更新
		userserviceimpl.updatefiletable(newFiletable);
	}

	// 删除文件夹
	@RequestMapping(value = "/deletefolder", method = RequestMethod.POST)
	public void deletefolder(HttpServletRequest request) {
		String floderid = request.getParameter("floderid");
	//	System.out.println(floderid + "floderid");
		Foldertable foldertable = userserviceimpl.getFoldertable(floderid);

		int floderid2 = Integer.parseInt(floderid);
		Foldertable foldertable2 = new Foldertable(floderid2);
		// 更新
		userserviceimpl.deletefolder(foldertable2);
	}
	// 复制
	@RequestMapping(value = "/copyfolder", method = RequestMethod.POST)
	public void copyfolder(HttpServletRequest request) {
		String floderid = request.getParameter("floderid");
		System.out.println(floderid + "floderid");
		Foldertable foldertable = userserviceimpl.getFoldertable(floderid);
		userid = foldertable.getUserid();
		filedid = foldertable.getFileid();
		foldername = foldertable.getFoldername();
		System.out.println(" userid     " + userid);
	}

	// 粘贴
	@RequestMapping(value = "/pastefolderid", method = RequestMethod.POST)
	public void pastefolderid(HttpServletRequest request) {
		String fatherfloderid = request.getParameter("floderid");
		System.out.println(fatherfloderid + "floderid");
		int myuserid = userid;
		String myfiledid = filedid;
		String myfoldername = foldername;
		Foldertable foldertable = new Foldertable(myuserid, myfiledid,
				myfoldername, fatherfloderid);
		userserviceimpl.insertFolder(foldertable);
	}

	//下载
			@RequestMapping(value="download" , method = RequestMethod.GET)
			@ResponseBody
		    public String download(HttpServletRequest request,HttpServletResponse response) throws IOException{
				int BUFFER_SIZE = 4096;
				InputStream in = null;
				OutputStream out = null;

				try {
					request.setCharacterEncoding("utf-8");
					response.setCharacterEncoding("utf-8");
					response.setContentType("application/octet-stream");
					fileids=request.getHeader("fileid");
			
					int fid=Integer.parseInt(fileids);
					Filetable filetable=(Filetable)userserviceimpl.searchfile(fid);
					String filenameString=filetable.getFilename();
					System.out.println(filenameString);
					File file = new File(request.getSession().getServletContext().getRealPath("upload"),filenameString);
					String path=request.getSession().getServletContext().getRealPath("upload");
					System.out.println(path);
					response.setContentLength((int) file.length());
					response.setHeader("Accept-Ranges", "bytes");

					int readLength = 0;

					in = new BufferedInputStream(new FileInputStream(file), BUFFER_SIZE);
					out = new BufferedOutputStream(response.getOutputStream());

					byte[] buffer = new byte[BUFFER_SIZE];
					while ((readLength = in.read(buffer)) > 0) {
						byte[] bytes = new byte[readLength];
						System.arraycopy(buffer, 0, bytes, 0, readLength);
						out.write(bytes);
					}
					
					out.flush();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
						}
					}
				}
				return "下载成功";
			}
			
			//删除文件
			@RequestMapping(value = "/deletefileinfolder", method = RequestMethod.POST)
			public void deletefileinfolder(HttpServletRequest request) {
			//	System.out.println("执行删除执行删除执行删除执行删除执行删除");
				String myadfileid = request.getParameter("myadfileid");
				String myfatherfolderid = request.getParameter("myfatherfolderid");
				List<Foldertable> folList=userserviceimpl.showfatherFol2(myfatherfolderid);
				String filsString="";
				for (int i = 0; i < folList.size(); i++) {
					String myfileid=folList.get(i).getFileid();
					
					int myfolder=folList.get(i).getFolderid();
					int userid=folList.get(i).getUserid();
					String foldername=folList.get(i).getFoldername();
					String fatherid=folList.get(i).getFatherfolderid();
					if (myfileid.length()==1) {
						if (myadfileid.equals(myfileid)) {
							Foldertable foldertable=new Foldertable(myfolder,userid,filsString,foldername,fatherid);
							userserviceimpl.updatefolder(foldertable);
						}
					}
					else {
						System.out.println("else        "+myfileid);
						String [] myarray=myfileid.split(",");
						List arrayList=new ArrayList();
						for (int j = 0; j < myarray.length; j++) {
							System.out.println("分割后字符串       "+myarray[j]);
						}
						for (int j = 0; j < myarray.length; j++) {
							arrayList.add(myarray[j]);
						}
						for (int p = 0; p < arrayList.size(); p++) {
							System.out.println("转化为链表后"+arrayList.get(p));
							if (arrayList.get(p).equals(myadfileid)) {
								arrayList.remove(p);
							}
						}
						//链表转化为字符串存入数据库
						
						for (int k= 0; k < arrayList.size(); k++) {
							 filsString+=arrayList.get(k)+",";
						}
						int endIndex=filsString.length()-1;
						System.out.println("filsStringfilsStri     "+filsString);
						String fileidstr=filsString.substring(0, endIndex);
						System.out.println("fileidstrfileidstr"+fileidstr);
						//更新数据库
						Foldertable foldertable=new Foldertable(myfolder,userid,fileidstr,foldername,fatherid);
						userserviceimpl.updatefolder(foldertable);
						
					}
				}
									
			}

			
			
			//缓存
			@RequestMapping(value="cache" , method = RequestMethod.GET)
			@ResponseBody
		    public String cache(HttpServletRequest request,HttpServletResponse response) throws IOException{
				int BUFFER_SIZE = 4096;
				InputStream in = null;
				OutputStream out = null;

				try {
					request.setCharacterEncoding("utf-8");
					response.setCharacterEncoding("utf-8");
					response.setContentType("application/octet-stream");
					fname=request.getHeader("filename");
					File file = new File(request.getSession().getServletContext().getRealPath("upload"),fname);
					String path=request.getSession().getServletContext().getRealPath("upload");
					System.out.println("下载"+fname);
					response.setContentLength((int) file.length());
					response.setHeader("Accept-Ranges", "bytes");

					int readLength = 0;

					in = new BufferedInputStream(new FileInputStream(file), BUFFER_SIZE);
					out = new BufferedOutputStream(response.getOutputStream());

					byte[] buffer = new byte[BUFFER_SIZE];
					while ((readLength = in.read(buffer)) > 0) {
						byte[] bytes = new byte[readLength];
						System.arraycopy(buffer, 0, bytes, 0, readLength);
						out.write(bytes);
					}
					
					out.flush();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
						}
					}
				}
				return "下载成功";
			}
			
			
			
	
	public UserController() {
		System.out.println("Controller");
	}
}
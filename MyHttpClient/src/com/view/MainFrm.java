package com.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.entity.Filetable;
import com.entity.Foldertable;
import com.entity.Sharefiletable;
import com.entity.User;
import com.tools.FileTools;
import com.tools.FileTools2;
import com.tools.FileTools3;
import com.tools.JImagedPopupMenu;
import com.tools.JImagedPopupMenu2;

public class MainFrm extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton myonlinedisk, share, hide, box, upload, download, delete, shared,
			news, search2, folder, filebutton, returnbutton, newbutton;
	private JLabel photo, account, volumen, newLabel;
	private JPanel jp1, jp2, jp3, jp4, jp5, jpmysource, jp2top;
	private JPanel jp;
	JPanel folderJPanel;
	JFileChooser jfc;
	User user;
	int[] idarry;
	int[] myfileidarray;
	private JTextField search = new JTextField();
	JButton[] btn_folder;
	JButton[] btn_folder2;
	JButton[] btn_file;
	JButton[] btn_file2;
	int mylength;
	int fillen;
	int adfileid;
	String adfilename;
	String fatherfolderid;
	String fileidString;
	ArrayList<Foldertable> folderlist;
	ArrayList<Filetable> myfilenameList;
	String fatherfolderid11;
	String text = "操作";
	int folderid;
	JButton jbutton;
	String menid;
	String mymenid;
	String myfileeid;
	List myfileidarraylist2;
	String fname = "";
	final JImagedPopupMenu filemenu = new JImagedPopupMenu(text);
	final JImagedPopupMenu2 filemenu2 = new JImagedPopupMenu2(text);
	public MainFrm(User user, ArrayList<Foldertable> folderlist,
			final ArrayList<Filetable> myfilenameList, String fatherfolderid11) {
		this.user = user;
		this.folderlist = folderlist;
		this.myfilenameList = myfilenameList;
		this.fatherfolderid11 = fatherfolderid11;
		myonlinedisk = new JButton("我的网盘");
		myonlinedisk.setBorderPainted(false);
		myonlinedisk.setIcon(new ImageIcon("skin/my.PNG"));
		share = new JButton("分享");
		share.setBorderPainted(false);
		share.setIcon(new ImageIcon("skin/share.PNG"));
		hide = new JButton("隐藏空间");
		hide.setBorderPainted(false);
		hide.setIcon(new ImageIcon("skin/hide.PNG"));
		box = new JButton("功能宝箱");
		box.setBorderPainted(false);
		box.setIcon(new ImageIcon("G:skin/box.PNG"));
		photo = new JLabel("photo");
		photo.setIcon(new ImageIcon("G:skin/photo.PNG"));
		returnbutton = new JButton("返回");
		returnbutton.setBorderPainted(false);
		returnbutton.setIcon(new ImageIcon("skin/back.PNG"));

		account = new JLabel("20133028");
		volumen = new JLabel("网盘容量");
		jp = (JPanel) this.getContentPane();
		jp.setLayout(new BorderLayout());
		account.setText(user.getUsermane());
		volumen.setText("网盘容量" + user.getContant() + "G");
		jp1 = new JPanel();
		Color c = new Color(7, 149, 243);
		jp1.setBackground(c);
		jp1.setPreferredSize(new Dimension(0, 120));
		jp1.setLayout(null);
		myonlinedisk.setBounds(260, 10, 90, 90);
		jp1.add(myonlinedisk);
		share.setBounds(420, 10, 90, 90);
		jp1.add(share);
		hide.setBounds(580, 10, 90, 90);
		jp1.add(hide);
		box.setBounds(740, 10, 90, 90);
		jp1.add(box);
		photo.setBounds(20, 10, 100, 100);
		jp1.add(photo);
		account.setBounds(150, 25, 100, 20);
		jp1.add(account);
		volumen.setBounds(150, 70, 100, 20);
		jp1.add(volumen);

		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2top = new JPanel();
		Color d = new Color(236, 242, 247);
		jp2top.setBackground(d);
		jp2top.setPreferredSize(new Dimension(0, 40));
		jp2top.setLayout(null);
		upload = new JButton("上传");
		upload.setBorderPainted(false);
		upload.setIcon(new ImageIcon("skin/upload.PNG"));
		download = new JButton("下载");
		download.setBorderPainted(false);
		download.setIcon(new ImageIcon("skin/download.PNG"));
		shared = new JButton("分享");
		shared.setBorderPainted(false);
		shared.setIcon(new ImageIcon("skin/shared.PNG"));
		delete = new JButton("删除");
		delete.setBorderPainted(false);
		delete.setIcon(new ImageIcon("skin/delete.PNG"));
		news = new JButton("新建文件夹11");
		news.setBorderPainted(false);
		news.setIcon(new ImageIcon("skin/news.PNG"));
		search2 = new JButton("新建文件夹12");
		search2.setBorderPainted(false);
		search2.setIcon(new ImageIcon("skin/search2.PNG"));

		jp2top.add(search);
		jp2top.add(upload);
		jp2top.add(download);
		jp2top.add(shared);
		jp2top.add(delete);
		jp2top.add(news);
		jp2top.add(search2);
		jp2top.add(returnbutton);
		returnbutton.setBounds(540, 5, 35, 30);
		search.setBounds(600, 5, 200, 30);
		upload.setBounds(5, 0, 80, 40);
		download.setBounds(105, 0, 80, 40);
		shared.setBounds(205, 0, 80, 40);
		delete.setBounds(305, 0, 80, 40);
		news.setBounds(405, 0, 120, 40);
		search2.setBounds(805, 5, 30, 30);
		folderJPanel = new JPanel();
		folderJPanel.setLayout(null);
		Color f = new Color(226, 235, 244);
		folderJPanel.setBackground(f);
		btn_folder = new JButton[20];
		btn_folder2 = new JButton[20];
		btn_file = new JButton[20];
		btn_file2 = new JButton[20];
		idarry = new int[20];
		myfileidarray = new int[20];
		myfileidarraylist2 = new ArrayList();
		String myliststring = "";

		for (int i = 0; i < folderlist.size(); i++) {
			mylength = folderlist.size();
			fatherfolderid = folderlist.get(i).getFatherfolderid();

			btn_folder[i] = new JButton("文件夹");
			btn_folder[i].setBorderPainted(false);
			btn_folder2[i] = new JButton();
			btn_folder2[i].setText(folderlist.get(i).getFoldername());
			btn_folder[i].setBounds(30 * (i + 1) + i * 128, 20, 128, 128);
			ImageIcon ico = new ImageIcon("skin/folder.png");
			Image temp = ico.getImage().getScaledInstance(
					btn_folder[i].getWidth(), btn_folder[i].getHeight(),
					ico.getImage().SCALE_DEFAULT);
			ico = new ImageIcon(temp);
			btn_folder[i].setIcon(ico);
			btn_folder2[i].setBounds(50 + 30 * (i + 1) + i * 128, 155, 80, 20);
			folderJPanel.add(btn_folder[i]);
			folderJPanel.add(btn_folder2[i]);

			folderid = folderlist.get(i).getFolderid();
			System.out.println("folderid" + folderid);

			btn_folder[i].addActionListener(this);
			btn_folder2[i].addActionListener(this);

			idarry[i] = folderlist.get(i).getFolderid();
			// 得到fileid
			String fileid = folderlist.get(i).getFileid();
			myliststring += fileid + ",";
			String[] fileidArray = myliststring.split(",");

			for (int a = 0; a < fileidArray.length; a++) {
				if (!myfileidarraylist2.contains(fileidArray[a])) {
					myfileidarraylist2.add(fileidArray[a]);
				}
			}
			fillen = myfileidarraylist2.size();
			for (int j = 0; j < myfileidarraylist2.size(); j++) {
				int a = folderlist.size();
				btn_file[j] = new JButton("文件");
				btn_file2[j] = new JButton();
				btn_file2[j].setText(myfilenameList.get(j).getFilename());
				
				myfileidarray[j] = myfilenameList.get(j).getFileid();
				final int id = myfilenameList.get(j).getFileid();
				final String name=myfilenameList.get(j).getFilename();
				if (30 * (a) + a * 128 + 30 * (j + 1) + j* 128>800) {
					btn_file[j].setBounds(30 * (a) + a * 128 + 30 * (j + 1) + j* 128-800, 200, 128, 128);
				}
				else {
					btn_file[j].setBounds(30 * (a) + a * 128 + 30 * (j + 1) + j* 128, 20, 128, 128);
				}
				
				fname = btn_file2[j].getText();
				String sub = fname.substring(fname.indexOf(".") + 1,fname.length());
				if(sub.equals("png")||sub.equals("jpg")||sub.equals("PNG")||sub.equals("JPG")){
					System.out.println("进入if");
					CloseableHttpClient httpclient = HttpClients.createDefault();
					FileTools3.cache(fname,httpclient);	
					if(sub.equals("png")||sub.equals("PNG")){
						ImageIcon ico1=new ImageIcon("F:\\"+fname); 
						Image temp1=ico1.getImage().getScaledInstance(btn_file[j].getWidth(),btn_file[j].getHeight(),ico1.getImage().SCALE_DEFAULT);  
						  ico1=new ImageIcon(temp1);  
						  btn_file[j].setIcon(ico1);
							if (35+30*(a) + a * 128+30*(j+1) + j * 128>800) {
								btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128-800,350,80,20);
							}
							else {
								btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128,155,80,20);
							}
							
						//  btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128,155,80,20);
						folderJPanel.add(btn_file[j]);
						folderJPanel.add(btn_file2[j]);
						btn_file[j].addActionListener(this);
					}
					if(sub.equals("jpg")||sub.equals("JPG")){
						ImageIcon ico1=new ImageIcon("F:\\"+fname); 
						Image temp1=ico1.getImage().getScaledInstance(btn_file[j].getWidth(),btn_file[j].getHeight(),ico1.getImage().SCALE_DEFAULT);  
						  ico1=new ImageIcon(temp1);  
						  btn_file[j].setIcon(ico1);
						  if (35+30*(a) + a * 128+30*(j+1) + j * 128>800) {
								btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128-800,350,80,20);
							}
							else {
								btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128,155,80,20);
							}
						 // btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128,155,80,20);
						folderJPanel.add(btn_file[j]);
						folderJPanel.add(btn_file2[j]);
						btn_file[j].addActionListener(this);
					}
				}
				else{
				ImageIcon ico1=new ImageIcon("skin/"+sub+".png"); 
				Image temp1=ico1.getImage().getScaledInstance(btn_file[j].getWidth(),btn_file[j].getHeight(),ico1.getImage().SCALE_DEFAULT);  
				  ico1=new ImageIcon(temp1);  
				  btn_file[j].setIcon(ico1);
				  if (35+30*(a) + a * 128+30*(j+1) + j * 128>800) {
						btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128-800,350,80,20);
					}
					else {
						btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128,155,80,20);
					}
				//  btn_file2[j].setBounds(35+30*(a) + a * 128+30*(j+1) + j * 128,155,80,20);
				folderJPanel.add(btn_file[j]);
				folderJPanel.add(btn_file2[j]);
				btn_file[j].addActionListener(this);
				}
			

				btn_file2[j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// String
						// fileiddString=myfilenameList.get(j).getFileid()+"";
						filemenu2.show(folderJPanel, 100, 100);
						adfileid = id;
						adfilename=name;
					}
				});
			}
			}

	
		if (folderlist.size() == 0) {
			fatherfolderid = fatherfolderid11;
			System.out.println("size=====0" + fatherfolderid11);

		}

		// 粘贴
		folderJPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (e.isMetaDown()) {// 检测鼠标右键单击
					filemenu.show(folderJPanel, e.getPoint().x, e.getPoint().y);
				}
			}
		});

		filemenu.rename.addActionListener(this);
		filemenu.delete.addActionListener(this);
		filemenu.copy.addActionListener(this);
		filemenu.paste.addActionListener(this);
		filemenu2.share.addActionListener(this);
		filemenu2.rename.addActionListener(this);
		filemenu2.download.addActionListener(this);
		filemenu2.delete.addActionListener(this);
		returnbutton.addActionListener(this);
		jp2.add(jp2top, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.CENTER);
		jp2.add(folderJPanel, BorderLayout.CENTER);

		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp3.add(new JLabel("I’m is p3"));
		jp4.add(new JLabel("I’m is p4"));
		jp5.add(new JLabel("I’m is p5"));
		myonlinedisk.addActionListener(this);
		share.addActionListener(this);
		hide.addActionListener(this);
		box.addActionListener(this);
		upload.addActionListener(this);
		download.addActionListener(this);
		delete.addActionListener(this);
		shared.addActionListener(this);
		news.addActionListener(this);
		search2.addActionListener(this);

		jp.add(jp1, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setTitle("云盘");
		this.setLocation(50, 50);
		setVisible(true);
	}

	FileTools fileTools = new FileTools();

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for (int j = 0; j < mylength; j++) {
			if (e.getSource() == btn_folder[j]) {
				String id1 = idarry[j] + "";
				String id2 = id1 + "";
				// 解析json： cildfloder
				// 文件夹
				String jsonString = fileTools.showchild(id2);
				JSONArray cildfloder = JSONArray.fromObject(jsonString);
				ArrayList<Foldertable> folderlist2 = (ArrayList) JSONArray
						.toList(cildfloder, Foldertable.class);
				// 文件名fileidString
				// 直接返回所有的数
				// 把fatherid传过去
				String jsonString2 = fileTools.getfilename(id2);
				JSONArray cildfloder2 = JSONArray.fromObject(jsonString2);
				ArrayList<Filetable> filename2 = (ArrayList) JSONArray.toList(cildfloder2, Filetable.class);
				
				if (filename2.get(0).getFileid() == 11) {
					Frame currentFrame = JOptionPane.getFrameForComponent(jp);
					currentFrame.dispose();
					// fatherfolderid=;
					MainFrm myfrm = new MainFrm(user, folderlist2, filename2,
							fatherfolderid);
					myfrm.setVisible(true);
				} else {
					Frame currentFrame = JOptionPane.getFrameForComponent(jp);
					currentFrame.dispose();
					MainFrm myfrm = new MainFrm(user, folderlist2, filename2,
							fatherfolderid);
					myfrm.setVisible(true);
				}
			}

			if (e.getSource() == btn_folder2[j]) {
				mymenid = idarry[j] + "";
				filemenu.show(btn_folder2[j], 20, 20);
			}
		}

		if (e.getSource() == filemenu2.share) {
			String pswd = JOptionPane.showInputDialog("请输入密码:");

			System.out.println("adfileid" + adfileid);
			fileTools.sharefile(adfileid + "", pswd);

			String hashnumberString=fileTools.sharefile(adfileid + "", pswd);
			System.out.println("sharefiletable.getHashnumber()"+ hashnumberString);
			JOptionPane.showMessageDialog(null,"分享码为：" + hashnumberString);

		}

		if (e.getSource() == filemenu.rename) {
			String s = JOptionPane.showInputDialog("请输入:");
			if (s.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入文件夹名字");
			}
			else {
				fileTools.updatefoldername(mymenid, s);
			}
			
		}
		
		
		//查询
				if (e.getSource()==search2) {
		           	String searchfilename=search.getText();
					String filemyid=fileTools.searchbyname(searchfilename);
					String fatherfolderid=fileTools.searchbyfileid(filemyid);
					String id2 = fatherfolderid + "";
					System.out.println("fatherfolderid"+fatherfolderid);
					// 解析json： cildfloder
					// 文件夹
					String jsonString = fileTools.showchild(id2);
					JSONArray cildfloder = JSONArray.fromObject(jsonString);
					ArrayList<Foldertable> folderlist2 = (ArrayList) JSONArray
							.toList(cildfloder, Foldertable.class);
					// 文件名fileidString
					// 直接返回所有的数
					// 把fatherid传过去
					String jsonString2 = fileTools.getfilename(id2);
					//
					JSONArray cildfloder2 = JSONArray.fromObject(jsonString2);
					ArrayList<Filetable> filename2 = (ArrayList) JSONArray.toList(
							cildfloder2, Filetable.class);	if (filename2.get(0).getFileid() == 11) {
								Frame currentFrame = JOptionPane.getFrameForComponent(jp);
								currentFrame.dispose();
								// fatherfolderid=;
								MainFrm myfrm = new MainFrm(user, folderlist2, filename2,fatherfolderid);
								Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
								myfrm.setLocation((scrSize.getSize().width - myfrm.getSize().width) / 2,
										(scrSize.getSize().height - myfrm.getSize().height) / 2);
								myfrm.setSize(900,600);
								myfrm.setVisible(true);
							} else {
								Frame currentFrame = JOptionPane.getFrameForComponent(jp);
								currentFrame.dispose();
								MainFrm myfrm = new MainFrm(user, folderlist2, filename2,fatherfolderid);
								Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
								myfrm.setLocation((scrSize.getSize().width - myfrm.getSize().width) / 2,
										(scrSize.getSize().height - myfrm.getSize().height) / 2);
								myfrm.setSize(900,600);
								myfrm.setVisible(true);
							}
						}
		
		if (e.getSource() == filemenu2.rename) {
			String s1 = JOptionPane.showInputDialog("请输入:");
			if (s1.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入文件名字");
			}
			else {
				System.out.println("adfileid" + adfileid);
				String myadfileid=adfileid+"";
				fileTools.updatefilename(myadfileid, s1);
			}
			
		}
		//文件删除
		if (e.getSource() == filemenu2.delete) {
			//文件id
			String myadfileid=adfileid+"";
			String myfatherfolderid=fatherfolderid;
			
			fileTools.deletefileinfolder(myadfileid,myfatherfolderid);
		}


		if (e.getSource() == filemenu.paste) {
			// 得到fatherid
			String id12 = fatherfolderid;
			fileTools.pastefolderid(id12);
		}

		if (e.getSource() == filemenu.delete) {
			fileTools.deletefolder(mymenid);
		}

		if (e.getSource() == filemenu.copy) {
			fileTools.copyfolder(mymenid);
		}

		if (e.getSource() == shared) {
			 new TestPanel();
		}

		// 返回
		if (e.getSource() == returnbutton) {
			// fatherfolderid = "1";
			String jsonString = fileTools.showfather(fatherfolderid);

			JSONArray cildfloder2 = JSONArray.fromObject(jsonString);
			ArrayList<Foldertable> folderlist2 = (ArrayList) JSONArray.toList(
					cildfloder2, Foldertable.class);

			String jsonString2 = fileTools.showfatherfile(fatherfolderid);
			JSONArray cildfloder3 = JSONArray.fromObject(jsonString2);
			ArrayList<Filetable> filename2 = (ArrayList) JSONArray.toList(
					cildfloder3, Filetable.class);

			Frame currentFrame = JOptionPane.getFrameForComponent(jp);
			currentFrame.dispose();

			MainFrm myfrm = new MainFrm(user, folderlist2, filename2,
					fatherfolderid);
			myfrm.setVisible(true);
		}

		if (e.getSource() == upload) {
			jfc = new JFileChooser();
			jfc.showDialog(new JPanel(), "上传");
			File file = jfc.getSelectedFile();
			System.out.println(file.getPath());
			String fileString = file + "";
			FileTools2 filestring = new FileTools2();
			String number = filestring.createChecksum(file);
			System.out.println("number" + number);
			String filesize = file.length() + "";
			System.out.println(filesize);
			try {
				
				//文件秒传
				String jsonStr = fileTools.showallnumber(fatherfolderid);
				JSONArray allnumberlist = JSONArray.fromObject(jsonStr);
				ArrayList<Filetable> filename2 = (ArrayList) JSONArray.toList(
						allnumberlist, Filetable.class);
				for (int i = 0; i < filename2.size(); i++) {
					if (filename2.get(i).getHashumber().equals(number)) {
						fileTools.upload12(number, filesize);
					} else {
						fileTools.postFile(fileString);
						
					}
				}
				fileTools.upload12(number, filesize);

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == news) {
			String id1 = "";
			for (int j = 0; j < idarry.length; j++) {
				id1 = idarry[j] + "";
			}

			String jsonString2 = fileTools.insertfolder(id1, fatherfolderid);

			newbutton = new JButton("文件夹");
			newbutton.setIcon(new ImageIcon("F://图片3//20160630175007.png"));
			newbutton.setBorderPainted(false);
			newLabel = new JLabel();
			newLabel.setText("新建文件夹");
			newbutton.setBounds(20, 240, 70, 60);
			newLabel.setBounds(40, 300, 80, 20);
			folderJPanel.add(newbutton);
			folderJPanel.add(newLabel);

		}
		

		if (e.getSource() == filemenu2.download) {
			jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			jfc.showDialog(new JPanel(), "下载");
			File downfile = jfc.getSelectedFile();
			String path = downfile.getPath();
			System.out.println("PATH" + path);
			CloseableHttpClient httpclient = HttpClients.createDefault();
			String fileid = adfileid + "";
			String filename = adfilename;
			FileTools3.download(path, fileid, filename, httpclient);
			JOptionPane.showMessageDialog(this, "下载成功");
		}
		
		if (e.getSource() == myonlinedisk) {
			jp.add(jp2, BorderLayout.CENTER);
			setVisible(true);

		} else if (e.getSource() == share) {
			jp.add(jp3, BorderLayout.CENTER);
			setVisible(true);

		} else if (e.getSource() == hide) {

			jp.add(jp4, BorderLayout.CENTER);
			setVisible(true);

		} else if (e.getSource() == box) {
			jp.add(jp5, BorderLayout.CENTER);
			setVisible(true);
		}
	}
}

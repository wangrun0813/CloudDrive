package com.view;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.entity.Filetable;
import com.entity.Foldertable;
import com.entity.User;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginFrm extends JFrame implements ActionListener{
	private JTextField txtID = new JTextField();
	private JPasswordField txtPwd = new JPasswordField();
	private JButton btnOK = new JButton("登录");
	private JButton register=new JButton("立即注册");
	int id;
	User user;
	ArrayList<Foldertable> folderlist;
    ArrayList<Filetable> myfilenameList;
	public LoginFrm() {
		JPanel p1 = (JPanel) this.getContentPane();
		p1.setLayout(new BorderLayout());
		Background img = new Background("skin/login.PNG");
		img.setLayout(null);
		p1.add(img, BorderLayout.CENTER);
		img.add(txtID);
		txtID.setBounds(530, 131, 252, 37);
		img.add(txtPwd);
		txtPwd.setBounds(530, 187, 252, 37);
		img.add(btnOK);
		btnOK.setBackground(new Color(30, 144, 255));
		btnOK.setFont(new Font("alias", Font.PLAIN, 20));
		btnOK.setBounds(485, 295, 300, 43);
		img.add(register);
		register.setBackground(new Color(30,144,255));
		register.setFont(new Font("alias", Font.PLAIN, 15));
		register.setBounds(670, 397, 100, 28);
		register.addActionListener(this);

		this.setSize(835,460);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOK_Clicked();
			}
		});
	}

	public String Login(String uid, String upwd) {
		String rvalue = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(
				"http://localhost:8080/MyHttpClientweb3/user/login");
		// 创建参数队列
		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
		formparams.add(new BasicNameValuePair("uid", uid));
		formparams.add(new BasicNameValuePair("upwd", upwd));
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					rvalue = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rvalue;
	}
	
	public String showfilename(String uid, String upwd) {
		String rvalue = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(
				"http://localhost:8080/MyHttpClientweb3/user/showfilename");
		// 创建参数队列
		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
		formparams.add(new BasicNameValuePair("uid", uid));
		formparams.add(new BasicNameValuePair("upwd", upwd));
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					rvalue = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rvalue;
	}
	
	public String showfloder() {
		String rvalue = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(
				"http://localhost:8080/MyHttpClientweb3/user/showfloder");

		try {
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					rvalue = EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rvalue;
	}
	private void btnOK_Clicked() {
		String uid = txtID.getText().trim();
		String upwd = txtPwd.getText().trim();
	//	JOptionPane.showMessageDialog(this, Login(uid, upwd));
		
		if (uid.equals("")||upwd.equals("")) {
			JOptionPane.showMessageDialog(null," 请输入用户名或密码");
		}
		else {
			String jsonString = Login(uid, upwd);

			if (Login(uid, upwd).equals("false")) {
				JOptionPane.showMessageDialog(null," 用户名或密码错误");
				new LoginFrm();
				System.out.println("失败****");
			
				setVisible(false);
			} else {
				setVisible(false);
				JSONObject jsonObject = JSONObject.fromObject(jsonString);
				user = (User) JSONObject.toBean(jsonObject, User.class);
				
				String folder = showfloder();
				JSONArray folderjson=JSONArray.fromObject(folder);
			    folderlist=(ArrayList) JSONArray.toList(folderjson, Foldertable.class);
			    String fatherfolderid="";
			    String filename= showfilename(uid, upwd);
				JSONArray filenamelist=JSONArray.fromObject(filename);
				myfilenameList=(ArrayList) JSONArray.toList(filenamelist, Filetable.class);
			    System.out.println("*************myfilenameList****************"+myfilenameList.get(0).getFilename());
				MainFrm main=new MainFrm(user,folderlist,myfilenameList,fatherfolderid);
				Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
				main.setLocation((scrSize.getSize().width - main.getSize().width) / 2,
						(scrSize.getSize().height - main.getSize().height) / 2);
				main.setSize(900,600);
			}
		}	
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		LoginFrm frm = new LoginFrm();
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		frm.setSize(835, 460);
		frm.setLocation((scrSize.getSize().width - frm.getSize().width) / 2,
				(scrSize.getSize().height - frm.getSize().height) / 2);
		frm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==register){
			 System.out.println("注册");
			 RegisterFrm register=new RegisterFrm();
				Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
				register.setLocation((scrSize.getSize().width - register.getSize().width) / 2,
						(scrSize.getSize().height - register.getSize().height) / 2);
				register.setSize(841,460);
				setVisible(false);

		 }
	}
}

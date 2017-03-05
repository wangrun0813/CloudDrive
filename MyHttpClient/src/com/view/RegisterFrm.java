package com.view;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class RegisterFrm extends JFrame implements ActionListener{
    private JTextField id=new JTextField();
    private JPasswordField txtPwd1=new JPasswordField();
    private JButton register=new JButton("立即注册");
    private JButton login=new JButton("立即登录");
    private JLabel account=new JLabel("输入账号");
   
    
    public RegisterFrm(){
    	JPanel p1 = (JPanel) this.getContentPane();
		p1.setLayout(new BorderLayout());
		Background img=new Background("skin/register.PNG");
		img.setLayout(null);
		p1.add(img,BorderLayout.CENTER);
		img.add(id);
		id.setBounds(560, 129, 230, 37);
		img.add(txtPwd1);
		txtPwd1.setBounds(560, 181, 230, 37);
		img.add(register);
		register.setBackground(new Color(30,144,255));
		register.setFont(new Font("alias", Font.PLAIN, 20));
		register.setBounds(490, 297, 300, 43);
		img.add(login);
		login.setBackground(new Color(30,144,255));
		login.setFont(new Font("alias", Font.PLAIN, 15));
		login.setBounds(670, 397, 100, 28);
		img.add(account);
		account.setBackground(new Color(0,0,0));
		account.setFont(new Font("alias", Font.PLAIN, 16));
		account.setBounds(490, 132, 100, 28);
		
		this.setSize(835,460);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		register.addActionListener(this);
		login.addActionListener(this);
		
    	
    }

    public String Register(String uname, String upwd) {
 		String rvalue = "";
 		// ����Ĭ�ϵ�httpClientʵ��.
 		CloseableHttpClient httpclient = HttpClients.createDefault();
 		// ����httppost
 		HttpPost httppost = new HttpPost(
 				"http://localhost:8080/MyHttpClientweb2/user/register");
 		// �����������
 		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
 		formparams.add(new BasicNameValuePair("uname", uname));
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
 			// �ر�����,�ͷ���Դ
 			try {
 				httpclient.close();
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 		}
 		return rvalue;
 	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		RegisterFrm frm=new RegisterFrm();
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		frm.setSize(841,460);
		frm.setLocation((scrSize.getSize().width - frm.getSize().width) / 2,
				(scrSize.getSize().height - frm.getSize().height) / 2);
		frm.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==register){
				String uname = id.getText().trim();
				String upwd = txtPwd1.getText().trim();
				Register(uname,upwd);
	
			 JOptionPane.showMessageDialog(null, "注册成功","提示",     JOptionPane.PLAIN_MESSAGE);
						}
		 
		 if(e.getSource()==login){
			 System.out.println("��¼");
			 LoginFrm login=new LoginFrm();
				Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
				login.setLocation((scrSize.getSize().width - login.getSize().width) / 2,
						(scrSize.getSize().height - login.getSize().height) / 2);
				login.setSize(835,460);
				setVisible(false);

		 }
	}
	
	
	
}

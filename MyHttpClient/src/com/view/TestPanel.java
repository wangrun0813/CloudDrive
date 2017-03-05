package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tools.FileTools;
 
 
public class TestPanel extends JFrame implements ActionListener{
 
    private JLabel lblID=new JLabel("分享码");
    private JLabel lblPwd=new JLabel("密码");
    private JTextField txtID=new JTextField();
    private JPasswordField txtPwd=new JPasswordField();
    private JButton btnOK=new JButton("获取");
    private JButton btnCancel=new JButton("取消");
    FileTools fileTools=new FileTools();
    public TestPanel(){
    	JPanel jp=(JPanel)this.getContentPane();
    	jp.setLayout(new GridLayout(3,2));
    	jp.add(lblID);jp.add(txtID);
    	jp.add(lblPwd);jp.add(txtPwd);
    	jp.add(btnOK);jp.add(btnCancel);
		JFrame.setDefaultLookAndFeelDecorated(true);

		this.setSize(600,200);
		this.setVisible(true);
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnOK) {
			String hashnumber=txtID.getText().trim();
			String password=txtPwd.getText().trim();
			System.out.println("hashnumber"+hashnumber);
			System.out.println("password"+password);
			String  myflag=fileTools.sharefilepassword(hashnumber, password);
			if (myflag.equals("success")) {
				JOptionPane.showMessageDialog(null, "获取成功");
			}
			else {
				JOptionPane.showMessageDialog(null, "密码或分享码错误");
			}
			
		}
		
	}
    


}
package com.view;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Background extends JPanel{
	String imagepath;
    public Background(String imagepath){
         this.imagepath=imagepath;
    }
    public void paintComponent(Graphics g){
        int x=0,y=0;
        //java.net.URL imgURL=getClass().getResource("test.jpg");//test.jpg�ǲ���ͼƬ����Demo.java����ͬһĿ¼��
        ImageIcon icon=new ImageIcon(imagepath);
        g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);
        while(true){
        g.drawImage(icon.getImage(),x,y,this);
        if(x>getSize().width && y>getSize().height)
     	   break;//��δ�����Ϊ�˱�֤�ڴ��ڴ���ͼƬʱ��ͼƬ���ܸ�����������
        if(x>getSize().width){
           x=0;
           y+=icon.getIconHeight();
        }
        else
           x+=icon.getIconWidth();
     }
   }
 }
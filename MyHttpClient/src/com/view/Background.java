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
        //java.net.URL imgURL=getClass().getResource("test.jpg");//test.jpg是测试图片，与Demo.java放在同一目录下
        ImageIcon icon=new ImageIcon(imagepath);
        g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);
        while(true){
        g.drawImage(icon.getImage(),x,y,this);
        if(x>getSize().width && y>getSize().height)
     	   break;//这段代码是为了保证在窗口大于图片时，图片仍能覆盖整个窗口
        if(x>getSize().width){
           x=0;
           y+=icon.getIconHeight();
        }
        else
           x+=icon.getIconWidth();
     }
   }
 }
package com.tools;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class JImagedPopupMenu2 extends JPopupMenu {
	public JMenuItem download;
	public JMenuItem share;
	public JMenuItem copy;
	public JMenuItem shear;
	public JMenuItem paste;
	public JMenuItem rename;
	public JMenuItem delete;
	public JMenuItem newfolder;
	public JMenuItem upload;
	public JMenuItem refresh;
	private static final long serialVersionUID = 1L;
	private Font font = new Font("Dialog", Font.BOLD, 13);
	private ImageIcon imageIcon = null;

	public JImagedPopupMenu2(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	public JImagedPopupMenu2(String text) {
		this.imageIcon = createImage(text);
	
	    	this.download = new JMenuItem("下载");
            this.share = new JMenuItem("分享");
//            this.copy = new JMenuItem("复制");  
//            this.shear = new JMenuItem("剪切");
            this.rename = new JMenuItem("重命名");
           this.delete = new JMenuItem("删除");
           //           this.paste = new JMenuItem("粘贴");
			this.add(download);
			this.add(share);
//			this.add(copy);
//			this.add(shear);
			this.add(rename);
			this.add(delete);
//			this.add(paste);
	}

	private ImageIcon createImage(String text) {
		BufferedImage bi = new BufferedImage(30, 200,
				BufferedImage.TYPE_INT_ARGB);
		ImageIcon image = new ImageIcon(bi);
		Graphics2D g2d = bi.createGraphics();

		GradientPaint paint = new GradientPaint(0, 0, Color.yellow, 30, 10,
				Color.red, true);
		g2d.setPaint(paint);

		g2d.fillRect(0, 0, bi.getWidth(), bi.getHeight());

		AffineTransform at = new AffineTransform();
		at.rotate(-Math.PI / 2);

		g2d.setTransform(at);
		g2d.setColor(Color.white);
		g2d.setFont(font);
		g2d.drawString(text, -100, bi.getWidth() / 2);

		return image;
	}

	@Override
	public Insets getInsets() {
		Insets insets = (Insets) super.getInsets().clone();
		insets.left += imageIcon.getIconWidth();
		return insets;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (imageIcon != null) {
			Insets insets = getInsets();
			g.drawImage(imageIcon.getImage(),
					insets.left - imageIcon.getIconWidth(), insets.top, null);
		}
	}

}

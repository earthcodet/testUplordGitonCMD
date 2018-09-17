package DatabaseAndTools;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ImageComponent extends JComponent {
	public BufferedImage image;
	public void paint(Graphics g) {
		if(image != null) {
			g.drawImage(image, 0, 0, 100,100,0,0,image.getWidth(),image.getHeight(),this);	
		}
	}
}
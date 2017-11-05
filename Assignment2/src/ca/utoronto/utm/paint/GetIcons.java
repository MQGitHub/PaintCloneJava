package ca.utoronto.utm.paint;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GetIcons {
	private String[] shape;
	public GetIcons(String[] shape) {
		this.shape = shape;
	}
	
	public ImageIcon[] icons() {
		ImageIcon[] icons = new ImageIcon[shape.length];
		int i = 0;
		for (String s : this.shape){
			ImageIcon x = new ImageIcon("shapes/"+s+".png");
			Image image = x.getImage();
			Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
			icons[i] = new ImageIcon(newimg);
			i ++;
		}
		
		return icons;
	}

}

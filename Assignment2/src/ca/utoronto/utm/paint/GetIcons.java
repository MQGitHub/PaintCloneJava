package ca.utoronto.utm.paint;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This class finds the shapes file in the repo and sets them
 * Image icon to be used for the buttons.
 * Has-A icons
 */
public class GetIcons {
	private String[] shape;
	public GetIcons(String[] shape) {
		this.shape = shape;
	}
	
	/**
	 * 
	 * @return an array of icons from a specific file in the repo.
	 */
	public ImageIcon[] icons() {
		ImageIcon[] icons = new ImageIcon[shape.length];
		int i = 0;
		for (String s : this.shape){
			ImageIcon x = new ImageIcon("shape/"+s+".png");
			Image image = x.getImage();
			Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
			icons[i] = new ImageIcon(newimg);
			i ++;
		}
		
		return icons;
	}

}

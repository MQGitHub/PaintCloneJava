package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * A TextBox is a Shape which has a font, fontSize and string input.
 *
 */
public class TextBox extends Shape {

	private String font;
	private int fontSize;
	private String input;

	/**
	 * Constructs a shape of type TextBox with a specific color, fontSize, font,
	 * input at the point corner.
	 * 
	 * @param colour
	 *            The colour of the text
	 * @param corner
	 *            The beginning point of the shape
	 * @param fontSize
	 *            The size of the text
	 * @param font
	 *            The type of font used in the text
	 * @param input
	 *            The string being painted
	 */
	public TextBox(Color colour, ca.utoronto.utm.paint.Point corner, int fontSize, String font, String input) {
		super(colour, 1, false, corner, new BasicStroke());
		this.font = font;
		this.fontSize = fontSize;
		this.input = input;
	}

	@Override
	public void draw(Graphics2D g2d) {
		int x = this.getCorner().getX();
		int y = this.getCorner().getY();
		g2d.setFont(new Font(this.font, Font.PLAIN, this.fontSize));
		g2d.setColor(this.getColor());
		g2d.drawString(input, x, y);

	}

}

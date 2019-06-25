package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class TextBoxManipulator extends ShapeManipulator {
	
	private TextBox tBox;
	private int fontSize;
	private String font;
	private int rotate;
	
	public TextBoxManipulator(View view) {
		super(view);
		fontSize = pp.getFontSize();
		font = pp.getTextFont();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operationPressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationClicked(MouseEvent e) {
		Color c = pp.getColor();
		thick = pp.getThickness();
		fill = pp.getOpacity();
		fontSize = pp.getFontSize();
		font = pp.getTextFont();
		stroke = pp.getStroke();
		rotate = pp.getRotate();
		this.model.addShape(new Square(c, thick, fill, new Point(-2,-2), 1, stroke));
		begin = new Point(c, thick, e.getX(), e.getY());
		String prompt = "Please add text to display.";
		String input = JOptionPane.showInputDialog(prompt);
		if (input == null) {
			input = " ";
		}
		this.tBox = new TextBox(c, begin, fontSize, font, input, rotate);
		this.model.addShape(tBox);
		
	}

	@Override
	public void operationReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void operationMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

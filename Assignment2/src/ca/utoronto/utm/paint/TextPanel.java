package ca.utoronto.utm.paint;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextPanel extends JTextArea implements ActionListener{
	private View view;
	private JMenuBar c;
	
	public TextPanel(View view) {
		this.view = view;
	}
	
	public JMenuBar textBar() {
		this.c = new JMenuBar();
		JMenu b = new JMenu("Text");
        b.setLayout(new GridLayout(0,1));
		
		JMenu font = new JMenu("Font");
		JButton x = new JButton("Times New Roman");
		x.setFont(new Font("Times New Roman", 10, 10));
		font.add(x);
		
		x = new JButton("Arial");
		x.setFont(new Font("Arial", 10, 10));
		font.add(x);
		
		x = new JButton("Comic Sans");
		x.setFont(new Font("Comic Sans", 10, 10));
		font.add(x);
		
		x = new JButton("Calibri");
		x.setFont(new Font("Calibri", 10, 10));
		font.add(x);
		
		b.add(font);
		
		JMenu size = new JMenu("Size");
		size.add(new JTextField(2));
		b.add(size);
		
		JRadioButton bold = new JRadioButton("Bold");
		b.add(bold);
		
		JRadioButton italics = new JRadioButton("Italicize");
		b.add(italics);
		
		JRadioButton underscore = new JRadioButton("Underscore");
		b.add(underscore);
		
		c.add(b);

		return c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getActionCommand() == "Bold"){
//			JRadioButton x = (JRadioButton) e.getSource();
//			this.view.getPaintPanel().isBold(x.isSelected());
//		} else if (e.getActionCommand() == "Italicize"){
//			JRadioButton x = (JRadioButton) e.getSource();
//			this.view.getPaintPanel().isItalics(x.isSelected());
//		}else if (e.getActionCommand() == "Underscore"){
//			JRadioButton x = (JRadioButton) e.getSource();
//			this.view.getPaintPanel().setUnderScore(x.isSelected());
//		}else if (e.getSource() == JTextField) {
//			JTextArea x = (JTextArea) e.getSource();
//			this.view.getPaintPanel().setFontSize(parseInt(x.getText()));
//		}else {
//			this.view.getPaintPanel().setFont(e.getActionCommand());
		
	}
	
	

}

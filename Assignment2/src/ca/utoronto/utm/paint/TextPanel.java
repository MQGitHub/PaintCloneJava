package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * A TextPanel has a TextBar from which the user can set the text font and text font size.
 *
 */
public class TextPanel extends JTextArea implements ActionListener, ChangeListener {
	private View view;
	private JMenuBar menuBar;
	private JMenu font;

	/**
	 * Initialize the view by connecting the view and TextPanel.
	 * @param view
	 * 			The view of Paint model.
	 */
	public TextPanel(View view) {
		this.view = view;
	}

	/**
	 * Construct a JMenuBar with two sub-menus to choose the font and font size.
	 * 
	 * @return JMenuBar with two sub-menus.
	 */
	public JMenuBar textBar() {
		this.menuBar = new JMenuBar();
		JMenu b = new JMenu("Text Editor");
		b.setOpaque(true);
		font = new JMenu("Font: Arial Narrow");
		String fonts[] = 
			      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		ButtonGroup group = new ButtonGroup();
		for (String label : fonts) {
			JCheckBoxMenuItem button;
			if (label == "Arial Narrow") {
				button = new JCheckBoxMenuItem(label, true);
			}else {
				button = new JCheckBoxMenuItem(label, false);
			}
			button.setFont(new Font(label, 12, 12));
			button.addActionListener(this);
			font.add(button);
			group.add(button);
		}
		MenuScroller.setScrollerFor(font, 20);
		b.add(font);

		JMenu size = new JMenu("Size");
		JSlider s = new JSlider(10, 70, 10);
		s.setName("Font Size");
		s.setMajorTickSpacing(10);
		s.setMinorTickSpacing(2);
		s.setPaintTicks(true);
		s.setPaintLabels(true);
		s.addChangeListener(this);
		size.add(s);
		b.add(size);

		menuBar.add(b);

		return menuBar;
	}

	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setFont(e.getActionCommand());
		this.font.setText("Font: " + e.getActionCommand());
	}
	
	public void stateChanged(ChangeEvent e) {
		JSlider x = (JSlider) e.getSource();
		this.view.getPaintPanel().setFontSize(x.getValue());
	}

}

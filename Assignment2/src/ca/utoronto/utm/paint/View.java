package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

/**
 * This is the top level View+Controller, it contains other aspects of the
 * View+Controller.
 * 
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private PaintModel model;

	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColourChooserPanel colourChooserPanel;

	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() { 
			public void windowClosing(java.awt.event.WindowEvent evt) {
				Object[] options = { "YES", "NO" };
				int pane = JOptionPane.showOptionDialog(null, "Do you want to exit the application?", "Confirm Exit",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (pane == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		this.setJMenuBar(createMenuBar());

		Container c = this.getContentPane();
		// c.add(new JButton("North"),BorderLayout.NORTH);
		// c.add(new JButton("South"),BorderLayout.SOUTH);
		// c.add(new JButton("East"),BorderLayout.EAST);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.colourChooserPanel = new ColourChooserPanel(this);
		c.add(this.shapeChooserPanel, BorderLayout.NORTH);

		this.model = model;

		this.paintPanel = new PaintPanel(model, this);
		this.paintPanel.setShape(new SquiggleManipulator(this));
		c.add(this.paintPanel, BorderLayout.CENTER);
		this.pack();
		// this.setSize(200,200);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}

	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	public ColourChooserPanel getColourChooserPanel() {
		return colourChooserPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");
		

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Clear");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("Clear");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Reset");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("Reset");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);
		
		menu = new JMenu("Help");

		// a group of JMenuItems
		menuItem = new JMenuItem("Draw");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Polygon");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Polyline");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		menu = new JMenu("About");

		// a group of JMenuItems
		menuItem = new JMenuItem("Credits");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);

		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Exit") {
			Object[] options = { "YES", "NO" };
			int pane = JOptionPane.showOptionDialog(null, "Do you want to exit the application?", "Confirm Exit",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (pane == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}else if (e.getActionCommand() == "New") {
			new Paint();
		} else if (e.getActionCommand() == "Undo") {
			this.model.Undo();
			
		} else if (e.getActionCommand() == "Redo") {
			this.model.Redo();
			
		} else if (e.getActionCommand() == "Clear") {
			this.model.Clear();
			
		} else if (e.getActionCommand() == "Reset") {
			Object[] options = { "YES", "NO" };
			int pane = JOptionPane.showOptionDialog(null, "Do you want to reset your canvas? \n this can not be undone.", "Confirm Exit",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (pane == JOptionPane.YES_OPTION) {
				this.model.clearAll();
			}
		}else if (e.getActionCommand() == "Draw") {
			Object[] options = { "OK"};
			int pane = JOptionPane.showOptionDialog(null, "Click on shape buttons to select wanted shape.?", "How to select shape",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		}else if (e.getActionCommand() == "Polygon") {
			Object[] options = { "OK"};
			int pane = JOptionPane.showOptionDialog(null, "Right-click or change shape to close the polygon", "How to use Polygon",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		} else if (e.getActionCommand() == "Polyline") {
			Object[] options = { "OK"};
			int pane = JOptionPane.showOptionDialog(null, "Changing shape or right-clicking will save the polyline", "How to use Polyline",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		}else if (e.getActionCommand() == "Credits") {
			Object[] options = { "OK"};
			int pane = JOptionPane.showOptionDialog(null, "This project was completed by: \n \t Radhika Lakhtakia \n \t Georges Hanna "
					+ "\n \t Hassan Khan \n \t Mateen Khan", "Credits",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		}

	}
}

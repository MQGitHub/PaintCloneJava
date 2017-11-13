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
					System.exit(0);
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
		c.add(this.shapeChooserPanel, BorderLayout.WEST);
		c.add(this.colourChooserPanel, BorderLayout.SOUTH);

		this.model = model;

		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);

		this.pack();
		// this.setSize(200,200);
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
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Clear All");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		String x = e.getActionCommand();
		if (x.equals("Exit")) {
			Object[] options = { "YES", "NO" };
			int pane = JOptionPane.showOptionDialog(null, "Do you want to exit the application?", "Confirm Exit",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (pane == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		System.out.println(e.getActionCommand());
	}
}

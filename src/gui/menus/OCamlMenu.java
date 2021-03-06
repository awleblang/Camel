package camel.gui.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import camel.gui.controller.FileHandler;
import camel.gui.code_area.CodeArea;
import camel.*;

/**
 * The OCaml menu.
 */
public class OCamlMenu extends JMenu implements ActionListener {

	/* The menu bar this menu is a part of */
	protected MenuBar parentBar;

	/* The code area of this menu's gui */
	protected CodeArea codeArea;

	/*Application*/
	protected Application app;

	protected JMenuItem _run;
	protected JMenuItem _debug;
	protected JMenuItem _resetInteractions;

	/**
	 * Create a new menu 
	 *
	 * @param parentBar the parent menubar of this menu
	 */
	public OCamlMenu(MenuBar parentBar, CodeArea codeArea, Application app) {
		
		super("OCaml");

		this.parentBar = parentBar;
		this.codeArea = codeArea;
		this.app = app;

		_run = new JMenuItem("Run", KeyEvent.VK_R);
		_run.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		_debug = new JMenuItem("Debug", KeyEvent.VK_D);
		_debug.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		_resetInteractions = new JMenuItem("Reset Interactions");

		add(_run);
		add(_debug);
		add(_resetInteractions);

		_run.addActionListener( this );
		_debug.addActionListener( this );
		_resetInteractions.addActionListener( this );

	}

	public void actionPerformed(ActionEvent evt) {

		if(evt.getSource() == _run) {
			codeArea.runCurrentFile();
		}

		if(evt.getSource() == _debug) {
			// TODO: launch debugger
			//app.openDebug();
			codeArea.debugCurrentFile();
		}

		if(evt.getSource() == _resetInteractions) {
			codeArea.resetInteractions();
		}
	}

	public void setEnable(Boolean b)
	{
		_run.setEnabled(b);
		_debug.setEnabled(b);
	}

}

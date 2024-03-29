package Bangla_Spell_Checker;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import Bangla_Spell_Checker.Dictionary.Node;

public class Notepad extends JFrame implements ActionListener {
	static JTextArea text;
	Container c;
	static String s, temp, path;
	ImageIcon cutIcon, copyIcon, pasteIcon, selectIcon, exitIcon, newIcon, openIcon, saveIcon, darkIcon, lightIcon;
	static JMenuBar menu;
	JMenu file, edit, help, view, spellCheck, theme;
	JMenuItem newItem, openItem, exitItem, cutItem, copyItem, pasteItem, clearallItem, selectallItem, saveItem, about,
			spellChecknow;
	static JMenuItem darkItem, lightItem;
	static int i;
	static String[] words;

	Notepad() {
		c = this.getContentPane();
		c.setLayout(null);
		newIcon = new ImageIcon("src/Image/new.png");
		Image newIcon1 = newIcon.getImage(); // transform it
		Image newimg = newIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		newIcon = new ImageIcon(newimg);
		exitIcon = new ImageIcon("src/Image/exit.png");
		Image exitIcon1 = exitIcon.getImage(); // transform it
		Image exitimg = exitIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		exitIcon = new ImageIcon(exitimg);
		openIcon = new ImageIcon("src/Image/open.png");
		Image openIcon1 = openIcon.getImage(); // transform it
		Image openimg = openIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		openIcon = new ImageIcon(openimg);
		saveIcon = new ImageIcon("src/Image/save.png");
		Image saveIcon1 = saveIcon.getImage(); // transform it
		Image saveimg = saveIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		saveIcon = new ImageIcon(saveimg);
		cutIcon = new ImageIcon("src/Image/cut.png");
		Image cutIcon1 = cutIcon.getImage(); // transform it
		Image cutimg = cutIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		cutIcon = new ImageIcon(cutimg);
		copyIcon = new ImageIcon("src/Image/copy.png");
		Image copyIcon1 = copyIcon.getImage(); // transform it
		Image copyimg = copyIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		copyIcon = new ImageIcon(copyimg);
		pasteIcon = new ImageIcon("src/Image/paste.png");
		Image pasteIcon1 = pasteIcon.getImage(); // transform it
		Image pasteimg = pasteIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		pasteIcon = new ImageIcon(pasteimg);
		selectIcon = new ImageIcon("src/Image/select.png");
		Image selectIcon1 = selectIcon.getImage();
		Image selectimg = selectIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		selectIcon = new ImageIcon(selectimg);
		darkIcon = new ImageIcon("src/Image/dark.jpg");
		Image darkIcon1 = darkIcon.getImage(); // transform it
		Image darkImg = darkIcon1.getScaledInstance(40, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		darkIcon = new ImageIcon(darkImg);
		lightIcon = new ImageIcon("src/Image/light.jpg");
		Image lightIcon1 = lightIcon.getImage(); // transform it
		Image lightImg = lightIcon1.getScaledInstance(40, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		lightIcon = new ImageIcon(lightImg);
		menu = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		spellCheck = new JMenu("Spell Checker");
		help = new JMenu("Help");
		theme = new JMenu("Theme");
		menu.add(file);
		menu.add(edit);
		menu.add(spellCheck);
		menu.add(theme);
		//menu.add(help);
		newItem = new JMenuItem("New");
		newItem.setIcon(newIcon);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		openItem = new JMenuItem("Open");
		openItem.setIcon(openIcon);
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		saveItem = new JMenuItem("Save");
		saveItem.setIcon(saveIcon);
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		exitItem = new JMenuItem("Exit");
		exitItem.setIcon(exitIcon);
		cutItem = new JMenuItem("Cut");
		cutItem.setIcon(cutIcon);
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		copyItem = new JMenuItem("Copy");
		copyItem.setIcon(copyIcon);
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		pasteItem = new JMenuItem("Paste");
		pasteItem.setIcon(pasteIcon);
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		selectallItem = new JMenuItem("Select all");
		selectallItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		clearallItem = new JMenuItem("Clear all");
		spellChecknow = new JMenuItem("Spell Check Now?");
		darkItem = new JMenuItem("Night Mode");
		darkItem.setIcon(darkIcon);
		lightItem = new JMenuItem("*Light Mode");
		lightItem.setIcon(lightIcon);
		about = new JMenuItem("About");
		file.add(newItem);
		file.add(openItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(cutItem);
		edit.add(copyItem);
		edit.add(pasteItem);
		edit.add(selectallItem);
		edit.add(clearallItem);
		spellCheck.add(spellChecknow);
		theme.add(lightItem);
		theme.add(darkItem);
		help.add(about);
		newItem.addActionListener(this);
		exitItem.addActionListener(this);
		about.addActionListener(this);
		saveItem.addActionListener(this);
		openItem.addActionListener(this);
		cutItem.addActionListener(this);
		copyItem.addActionListener(this);
		pasteItem.addActionListener(this);
		selectallItem.addActionListener(this);
		clearallItem.addActionListener(this);
		spellChecknow.addActionListener(this);
		darkItem.addActionListener(this);
		lightItem.addActionListener(this);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 25, 650, 680);
		this.setTitle("Spell Checker");
		this.setJMenuBar(menu);
		ImageIcon frameIcon = new ImageIcon("src/Image/note.jpg");
		Image frameIcon1 = frameIcon.getImage(); // transform it
		Image frameimg = frameIcon1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		frameIcon = new ImageIcon(frameimg);
		this.setIconImage(frameimg);
		text = new JTextArea();
		// text.setTransferHandler(null);//desable copy paste
		JScrollPane pane = new JScrollPane(text);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		pane.setBounds(0, 0, 630, 620);
		text.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		this.add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newItem) {
			text.setText("");
		} else if (e.getSource() == exitItem) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Title", JOptionPane.YES_NO_OPTION, 2,
					null);
			if (a == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "File Exit");
				System.exit(0);
			}
		} else if (e.getSource() == about) {
			new About();
		} else if (e.getSource() == saveItem) {
			// System.out.println(text.getText());
			if (text.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Empty file.Can't save this file", "Alert",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JFileChooser fchoose = new JFileChooser();
				int option = fchoose.showSaveDialog(Notepad.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					String name = fchoose.getSelectedFile().getName();
					String path = fchoose.getSelectedFile().getParentFile().getPath();
					String file = path + "\\" + name + ".txt";
					try {
						FileWriter fw = new FileWriter(file);
						fw.write(text.getText());
						fw.write("\n");
						fw.close();
					} catch (IOException e1) {
						System.out.println(e1);
					}
				} else {
					JOptionPane.showMessageDialog(null, "The user cancelled the operation", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} else if (e.getSource() == openItem) {
			JFileChooser j = new JFileChooser("f:");
			// show the save dialog
			int r = j.showOpenDialog(null);
			// If the user selects a file
			if (r == JFileChooser.APPROVE_OPTION) {
				File fi = new File(j.getSelectedFile().getAbsolutePath());
				try {
					String s1 = "", sl = "";
					FileReader fr = new FileReader(fi);
					BufferedReader br = new BufferedReader(fr);
					sl = br.readLine();
					// Take the input from the file
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}
					text.setText(sl);
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(null, evt.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "The user cancelled the operation", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == cutItem) {
			text.cut();
		} else if (e.getSource() == copyItem) {
			text.copy();
		} else if (e.getSource() == pasteItem) {
			text.paste();
		} else if (e.getSource() == selectallItem) {
			// panel.select(0, 5);
			text.selectAll();
		} else if (e.getSource() == clearallItem) {
			text.setText("");
		} else if (e.getSource() == spellChecknow) {
			Dictionary.root = new Node();
			try {
				BufferedReader br = new BufferedReader(new FileReader(Dictionary.path));
				int i = 0;
				String string = br.readLine();
				while (string != null) {
					Dictionary.insert(Dictionary.root, string);
					// System.out.println(string);
					string = br.readLine();
				}
				br.close();
			} catch (Exception e2) {
			}
			String sentence = text.getText();
			words = sentence.split("\\s");
			String s = "";
			for (i = words.length - 1; i >= 0; i--) {
				// System.out.println(words[i]);
				temp = words[i];
				if (text.getText() == "") {
					JOptionPane.showMessageDialog(null, "Don't put any Text");
					continue;
				}
//					System.out.println(words[i].charAt(0));
				Filecontroller file = new Filecontroller(temp);
				path = file.pathName();
				if (path == null) {
					JOptionPane.showMessageDialog(null, "Invalid Text");
					text.setText("");
					break;
				}
				try {
					Spell spell = new Spell(path);
					if (spell.trueString(temp)) {
						s = temp + " ";
						// text.setText(s);
					} else if (Dictionary.searchword(temp)) {
						s = temp + " ";
						// text.setText(s);
					} else {
						new suggested_word();
//					System.out.println(Spell.error);
//					if(Spell.error==1) {
//						s = "প্রস্তাবিত শব্দ ";
//					}
						// System.out.println(path);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == lightItem) {
			text.setBackground(Color.white);
			lightItem.setText("*Light Mode");
			darkItem.setText("Night Mode");
			menu.setBackground(new Color(229, 229, 229));
			text.setForeground(Color.black);
			help.setForeground(Color.black);
			theme.setForeground(Color.black);
			spellCheck.setForeground(Color.black);
			edit.setForeground(Color.black);
			file.setForeground(Color.black);
		} else if (e.getSource() == darkItem) {
			text.setBackground(new Color(39, 40, 34));
			darkItem.setText("*Night Mode");
			lightItem.setText("Light Mode");
			help.setForeground(Color.white);
			theme.setForeground(Color.white);
			spellCheck.setForeground(Color.white);
			edit.setForeground(Color.white);
			file.setForeground(Color.white);
			menu.setBackground(new Color(31, 31, 31));
			text.setForeground(Color.white);
		}
	}
	public static void main(String[] args) throws Exception {
		Notepad demo = new Notepad();
	}
}
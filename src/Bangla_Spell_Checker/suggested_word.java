package Bangla_Spell_Checker;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class suggested_word extends JFrame implements ActionListener {
	JPanel contentPane;
	JTextField not_found;
	JLabel selectlabel;
	JLabel changeLabel;
	JTextField change;
	JTable table;
	JButton ignore, closeb, adddic, changeB;
	DefaultTableModel model;
	private JTable table_1;
	int j = j = Notepad.i;
	static TreeSet<String> correctStrings;

	public static void main(String[] args) {
		try {
			new suggested_word();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public suggested_word() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 135, 500, 500);
		contentPane = new JPanel();
		// contentPane.setBackground(Color.black);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setForeground(Color.red);

		not_found = new JTextField();
		not_found.setBounds(24, 43, 155, 37);
		not_found.setText(Notepad.temp);
		not_found.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		not_found.setColumns(10);
		not_found.setForeground(Color.red);
		contentPane.add(not_found);

		JLabel not_foundlabel = new JLabel("Not found in dictionary:");
		// not_foundlabel.setForeground(Color.white);
		not_foundlabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		not_foundlabel.setBounds(24, 0, 194, 47);
		contentPane.add(not_foundlabel);

		selectlabel = new JLabel("Select from Suggestions(s):");
		// selectlabel.setForeground(Color.white);
		selectlabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectlabel.setBounds(24, 89, 194, 37);
		contentPane.add(selectlabel);

		changeLabel = new JLabel("Change To :");
		// changeLabel.setForeground(Color.white);
		changeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		changeLabel.setBounds(292, 5, 119, 37);
		contentPane.add(changeLabel);

		change = new JTextField();
		change.setForeground(Color.green);
		change.setBounds(291, 43, 172, 37);
		change.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		contentPane.add(change);
		String s = null;
		table = new JTable();
		model = new DefaultTableModel(0, 1);
		table.setModel(model);
		table.setBorder(null);
		table.setBounds(132, 154, 208, 198);
		table.setFont(new Font("Kalpurush", Font.PLAIN, 20));
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		table.setRowHeight(30);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(100, 129, 283, 244);
		contentPane.add(pane);
		if (Notepad.path != null) {
			Spell spelling = new Spell(Notepad.path);
			correctStrings = spelling.getSuggestionSpell(Notepad.temp);
			Dictionary.modify(Notepad.temp);
			Dictionary.checkPresent(Dictionary.root, Notepad.temp);
			correctStrings.addAll(Dictionary.correct_word);
			Dictionary.correct_word.clear();
			// System.out.println(correctStrings);
			Iterator<String> itr = correctStrings.iterator();
			int i = 0;
			while (itr.hasNext()) {
				// table.setValueAt(s, i, 0);
				// table.addRowSelectionInterval(i, i);
				i++;
				// s = s + itr.next() + " ";
				model.addRow(new Object[] { itr.next() });
			}
			correctStrings.clear();
		}
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int number = table.getSelectedRow();
				String wordString = model.getValueAt(number, 0).toString();
				change.setText(wordString);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		ignore = new JButton("Ignore");
		ignore.setBounds(180, 399, 119, 37);
		ignore.addActionListener(this);
		contentPane.add(ignore);

		changeB = new JButton("Change");
		changeB.setBounds(24, 399, 119, 37);
		changeB.addActionListener(this);
		contentPane.add(changeB);
		closeb = new JButton("Close");
		closeb.setBounds(344, 399, 119, 37);
		closeb.addActionListener(this);
		contentPane.add(closeb);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		this.setTitle("Bangla Spell Checker");
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ignore) {
			String from = not_found.getText();
			int start = Notepad.text.getText().indexOf(from);
			if (start >= 0 && from.length() > 0) {
				Notepad.text.replaceRange(not_found.getText(), start, start + from.length());
			}
			dispose();
		} else if (e.getSource() == changeB) {
			String from = not_found.getText();
			int start = Notepad.text.getText().indexOf(from);
			if (start >= 0 && from.length() > 0) {
				Notepad.text.replaceRange(change.getText(), start, start + from.length());
			}
			dispose();
		} else if (e.getSource() == closeb) {
			dispose();
		}
	}
}
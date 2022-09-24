package Bangla_Spell_Checker; 
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class intro extends JFrame {
	JFrame frame,demo;
    JLabel image = new JLabel(new ImageIcon("src\\Image\\b.png"));
    JLabel text = new JLabel("বাংলা বানান পরীক্ষক");
    JProgressBar progressBar = new JProgressBar();
    JLabel message = new JLabel();
    intro() {
    	//create GUI
    	 frame = new JFrame();
         frame.getContentPane().setLayout(null);
         frame.setUndecorated(true);
         frame.setBounds(350, 25, 650, 680);
         frame.setLocationRelativeTo(null);
         frame.getContentPane().setBackground(Color.WHITE);
         frame.setVisible(true);
         image.setBounds(80, 25, 550, 400);
         frame.add(image);
         frame.getRootPane().setBorder(
        	        BorderFactory.createMatteBorder(4, 2, 1, 3, Color.black)
        	);
         text.setFont(new Font("Kalpurush", Font.PLAIN, 50));
         text.setBounds(125, 438, 600, 75);
         text.setForeground(Color.black);
         frame.add(text);
         progressBar.setBounds(125, 520, 400, 28);
         progressBar.setBorderPainted(true);
         progressBar.setStringPainted(true);
         progressBar.setBackground(Color.DARK_GRAY);
         progressBar.setForeground(Color.black);
         progressBar.setValue(0);
         frame.add(progressBar);
         message.setBounds(275, 570, 200, 40);
         message.setForeground(Color.black);
         message.setFont(new Font("arial", Font.BOLD, 15));
         frame.add(message);
        running();
    }
//Loading Bar
    public void running() {
        int i = 0;
        while (i <= 100) {
            try {
                Thread.sleep(40);
                progressBar.setValue(i);
                message.setText("LOADING " + Integer.toString(i) + "%");
                i++;
                if (i >= 50) {
                    i = i + 2;
                }
                else if(i >= 75) {
                	 i = i + 4;
                }
                if (i == 100) {
                    frame.dispose();
                    Notepad home_page = new Notepad();
                    home_page.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

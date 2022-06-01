package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
public class PracticeExam {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JLabel label = new JLabel("Hi I'm Label");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.WHITE);
		label.setBounds(100, 100, 20, 9);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("click me");
		button.setBounds(0, 200, 100, 30);
		button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "waddup");
			}  
		});
		frame.getContentPane().add(button);
	}

}

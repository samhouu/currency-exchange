package main;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartFrame {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame window = new StartFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("0x2F2F2F"));
		frame.setBounds(100, 100, 522, 769);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Currency Converter");
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconcur.png")));
		//frame.setBackground(Color.decode("0x37383A"));
		
		JLabel labelToIcon = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/currencyshadow.png"));
		labelToIcon.setIcon(img);
		labelToIcon.setBounds(141, 240, 214, 217);
		frame.getContentPane().add(labelToIcon);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConverterFrame.main(null);
				frame.dispose();
			}
		});
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnStart.setBorder(emptyBorder);
		btnStart.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnStart.setForeground(Color.BLACK);
		btnStart.setBackground(Color.WHITE);
		btnStart.setBounds(188, 603, 115, 54);
		//btnStart.setFocusPainted(false);
		frame.getContentPane().add(btnStart);
		
		JLabel lblTitleC = new JLabel("Convert your currency now!");
		lblTitleC.setForeground(Color.WHITE);
		lblTitleC.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTitleC.setBounds(141, 97, 214, 54);
		frame.getContentPane().add(lblTitleC);
		
		JLabel lblTitle = new JLabel("Convertify");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Montserrat Black", Font.PLAIN, 51));
		lblTitle.setBounds(100, 23, 301, 97);
		frame.getContentPane().add(lblTitle);
	}
}

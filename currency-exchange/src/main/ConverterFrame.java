package main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import main.APIConverter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import org.json.JSONException;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class ConverterFrame {

	private JFrame frame;
	private JTextField tfAmount;
	static JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterFrame window = new ConverterFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public ConverterFrame() throws JSONException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public void initialize() throws JSONException, IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("0x2F2F2F"));
		frame.setBounds(100, 100, 522, 769);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Currency Converter");
		frame.getContentPane().setLayout(null);
		
		JLabel labelToIcon = new JLabel("");
		ImageIcon imgConvIcon = new ImageIcon(this.getClass().getResource("/converticon3.png"));
		labelToIcon.setIcon(imgConvIcon);
		labelToIcon.setBounds(217, 367, 60, 60);
		
		frame.getContentPane().add(labelToIcon);
		
		JLabel lblTitleCurrency = new JLabel("Exchange Rate");
		lblTitleCurrency.setFont(new Font("Montserrat Medium", Font.BOLD, 30));
		lblTitleCurrency.setForeground(Color.WHITE);
		lblTitleCurrency.setBounds(131, 41, 249, 43);
		frame.getContentPane().add(lblTitleCurrency);
		
		tfAmount = new JTextField();
		tfAmount.setFont(new Font("Montserrat", Font.PLAIN, 18));
		tfAmount.setBounds(61, 239, 372, 62);
		frame.getContentPane().add(tfAmount);
		tfAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setBounds(61, 209, 46, 14);
		frame.getContentPane().add(lblAmount);
		
		//COMBO BOX "TO" 
		JComboBox cbTo = new JComboBox();
		cbTo.setFont(new Font("Montserrat", Font.PLAIN, 18));
		cbTo.setBackground(Color.WHITE);
		cbTo.setBounds(295, 365, 138, 62);
		
		APIList.JsonGetKeys(cbTo);
		frame.getContentPane().add(cbTo);
		
		//COMBO BOX "FROM"
		JComboBox cbFrom = new JComboBox();
		cbFrom.setFont(new Font("Montserrat", Font.PLAIN, 18));
		cbFrom.setBackground(Color.WHITE);
		cbFrom.setBounds(61, 365, 138, 62);
		
		APIList.JsonGetKeys(cbFrom);
		frame.getContentPane().add(cbFrom);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setBounds(61, 340, 46, 14);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblTo.setForeground(Color.WHITE);
		lblTo.setBounds(295, 340, 46, 14);
		frame.getContentPane().add(lblTo);
		
		JButton btnConvert = new JButton("CONVERT");
		btnConvert.setForeground(Color.DARK_GRAY);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnConvert.setBorder(emptyBorder);
		
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cbFromGetItem = cbFrom.getSelectedItem().toString();
				String cbToGetItem = cbTo.getSelectedItem().toString();
				String tfAmountValueToString = tfAmount.getText();
				int tfAmountValue = Integer.parseInt(tfAmountValueToString);
				
				try {
					lblResult.setText(APIConverter.getData(cbFromGetItem, cbToGetItem, tfAmountValue));
				} catch (IOException | JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConvert.setFont(new Font("Poppins", Font.BOLD, 23));
		btnConvert.setBackground(Color.WHITE);
		btnConvert.setBounds(61, 485, 372, 62);
		btnConvert.setFocusPainted(false);
		frame.getContentPane().add(btnConvert);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconcur.png")));
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Montserrat Black", Font.PLAIN, 42));
		lblResult.setForeground(new Color(0, 250, 154));
		lblResult.setBounds(61, 102, 372, 71);
		frame.getContentPane().add(lblResult);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setForeground(Color.DARK_GRAY);
		btnClear.setFont(new Font("Poppins", Font.BOLD, 23));
		btnClear.setBackground(Color.WHITE);
		Border emptyBorder1 = BorderFactory.createEmptyBorder();
		btnClear.setBorder(emptyBorder1);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfAmount.setText("");
			}
		});
		btnClear.setBounds(61, 585, 372, 60);
		frame.getContentPane().add(btnClear);
		frame.setBackground(Color.decode("0x37383A"));
		
	}
}

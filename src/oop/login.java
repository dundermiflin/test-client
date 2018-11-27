package oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private String password ="pass";
	private JLabel dispLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPassword = new JLabel("Admin password");
		lblAdminPassword.setBounds(112, 118, 110, 29);
		contentPane.add(lblAdminPassword);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPasswordField input=(JPasswordField)e.getSource();
				char[] passy =input.getPassword();
				String p =new String(passy);
				if(p.equals(password)) {
					select f =new select();
					f.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Try Again!");
				}
			}
		});
		passwordField.setBounds(221, 116, 92, 32);
		contentPane.add(passwordField);
		
		dispLbl = new JLabel("Enter password");
		dispLbl.setBounds(225, 171, 147, 14);
		contentPane.add(dispLbl);
	}
}

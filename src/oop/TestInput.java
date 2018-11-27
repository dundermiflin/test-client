package oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class TestInput extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestInput frame = new TestInput();
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
	public TestInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel qLabel= new JLabel("No Of Qs");
		qLabel.setBounds(189, 59, 73, 27);
		contentPane.add(qLabel);
		
		JLabel Lbl2= new JLabel("Press enter to generate test");
		Lbl2.setBounds(141, 147, 170, 27);
		contentPane.add(Lbl2);
		
		JTextField TestIP =new JTextField();
		TestIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defined.TestIP=Integer.parseInt(TestIP.getText());
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(defined.Subject));
					int checkRange=Integer.parseInt(br.readLine());
					br.close();
					if(checkRange>=defined.TestIP) {

						TestOP f=new TestOP();
						f.setVisible(true);
						dispose();
					}
					else {
						Lbl2.setText("Try a smaller set!");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		TestIP.setBounds(155, 97, 116, 27);
		contentPane.add(TestIP);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectTest f =new selectTest();
				f.setVisible(true);
				dispose();
			}
		});
		btnMenu.setBounds(20, 182, 89, 23);
		contentPane.add(btnMenu);
	
	}
	
	
	
}

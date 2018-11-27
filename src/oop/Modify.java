package oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Modify extends JFrame {

	private JPanel contentPane;
	int num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify frame = new Modify();
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
	public Modify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel mod =new JLabel("Question No:");
		mod.setBounds(74, 39, 63, 14);
		mod.setVisible(true);
		contentPane.setLayout(null);
		contentPane.add(mod);
		
		JTextField newQ =new JTextField();
		newQ.setBounds(74, 85, 236, 23);
		newQ.setVisible(true);
		contentPane.add(newQ);
		
		JTextField newA =new JTextField();
		newA.setBounds(74, 125, 236, 32);
		newA.setVisible(true);
		contentPane.add(newA);
		
		JTextField quest =new JTextField();
		quest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num=Integer.parseInt(quest.getText());
				try {
					

				BufferedReader br= new BufferedReader(new FileReader(defined.Subject));
				String line;
				while((line=br.readLine())!=null) {
					
					if(line.startsWith("Q"+String.valueOf(num))){
						newQ.setText(line.substring(3));
					}
					else if(line.startsWith("A"+String.valueOf(num))){
						newA.setText(line.substring(3));
					}
					
				}
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			}
		});
		quest.setBounds(163, 30, 75, 32);
		quest.setVisible(true);
		contentPane.add(quest);
		
		JLabel stat = new JLabel("");
		stat.setBounds(337, 222, 46, 14);
		contentPane.add(stat);	
		
		JButton con =new JButton("Confirm");
		con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!newQ.getText().equals("")&&!newQ.getText().equals("")) {
					try {
						BufferedReader br= new BufferedReader(new FileReader(defined.Subject));
						String line;
						int qno=Integer.parseInt(br.readLine());
						String nl=System.lineSeparator();
						FileWriter fw=new FileWriter(defined.Subject);
						String changed=String.valueOf(qno)+nl+nl;
						while((line=br.readLine())!=null) {
							String s="";
							if(!line.equals("")) {
								s=s+line.charAt(1);
								int i=Integer.parseInt(s);
								if(i!=num) {
									if(line.startsWith("Q")) {
										changed=changed+line+nl;
									}
									else if(line.startsWith("#")) {
										changed=changed+line+nl;
									}
									else {
										changed=changed+line+nl+nl;
									}
								}
								
							}
							
						}
						changed=changed+nl+"#"+String.valueOf(num)+nl+"Q"+String.valueOf(num)+"."+newQ.getText()+nl+"A"+String.valueOf(num)+"."+newA.getText()+nl;
						
						fw.write(changed);
						br.close();
						fw.close();
						stat.setText("Done!");
						
					}catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		con.setBounds(332, 165, 92, 23);
		con.setVisible(true);
		contentPane.add(con);
		
		JLabel lblQ = new JLabel("Q");
		lblQ.setBounds(28, 89, 46, 14);
		contentPane.add(lblQ);
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(28, 125, 46, 14);
		contentPane.add(lblA);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select f =new select();
				f.setVisible(true);
				dispose();
			}
		});
		btnMenu.setBounds(10, 213, 89, 23);
		contentPane.add(btnMenu);
		
		
		
	}
}

package oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class delete extends JFrame {

	private JPanel contentPane;
	int num;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete();
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
	public delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel stat=new JLabel("Enter to delete");
		stat.setHorizontalAlignment(SwingConstants.CENTER);
		stat.setHorizontalTextPosition(SwingConstants.CENTER);
		stat.setBounds(90, 133, 235, 14);
		stat.setVisible(true);
		contentPane.setLayout(null);
		contentPane.add(stat);
		
		
		JLabel quest = new JLabel("Enter question no.");
		quest.setBounds(163, 43, 89, 14);
		contentPane.add(quest);
		JTextField no =new JTextField();
		no.setBounds(163, 82, 89, 20);
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
						if(!no.getText().equals("")) {
							num=Integer.parseInt(no.getText());
						}
	
					BufferedReader br= new BufferedReader(new FileReader(defined.Subject));
					String line;
					int qno=Integer.parseInt(br.readLine());
				if(qno>=num) {
					qno--;
					System.out.println(qno);
					String nl=System.lineSeparator();
					FileWriter fw=new FileWriter(defined.Subject);
					String changed=String.valueOf(qno)+nl+nl;
					while((line=br.readLine())!=null) {
						String s="";
						if(!line.equals("")) {
							s=s+line.charAt(1);
							int i=Integer.parseInt(s);
						
						if(i>num){
							String changedNo=String.valueOf(i-1);
							if(line.startsWith("Q")) {
								changed=changed+"Q"+changedNo+line.substring(2)+nl;
							}
							else if(line.startsWith("#")) {
								changed=changed+"#"+changedNo+line.substring(2)+nl;
							}
							else {
								changed=changed+"A"+changedNo+line.substring(2)+nl+nl;
							}
							
						}
						else if(i<num) {
							String changedNo=String.valueOf(i);
							if(line.startsWith("Q")) {
								changed=changed+"Q"+changedNo+line.substring(2)+nl;
							}
							else if(line.startsWith("#")) {
								changed=changed+"#"+changedNo+line.substring(2)+nl;
							}
							else {
								changed=changed+"A"+changedNo+line.substring(2)+nl+nl;
							}
							
						}
					}
					}
					fw.write(changed);
					br.close();
					fw.close();
					stat.setText("Deleted!");
				}
				else {
					stat.setText("Q not present");
				}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		contentPane.add(no);
		no.setText("1");
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select f =new select();
				f.setVisible(true);
				dispose();
			}
		});
		btnMenu.setBounds(10, 209, 89, 23);
		contentPane.add(btnMenu);
		
		
	}
	}


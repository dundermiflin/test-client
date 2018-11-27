package oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TestOP extends JFrame {

	private JPanel contentPane;
	int setArr[]=new int[100];;
	int i=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestOP frame = new TestOP();
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
	public TestOP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel no =new JLabel("Q No:");
		no.setHorizontalAlignment(SwingConstants.CENTER);
		no.setBounds(117, 37, 166, 23);
		contentPane.add(no);
		
		JLabel Q =new JLabel("--Question--");
		Q.setHorizontalAlignment(SwingConstants.CENTER);
		Q.setBounds(0, 91, 414, 14);
		contentPane.add(Q);
		
		JButton gen =new JButton("Get Q.");
		gen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				i++;
				
				if(i<=defined.TestIP) {
					
					try {					
						
						BufferedReader br= new BufferedReader(new FileReader(defined.Subject));
						String line;
						int range=Integer.parseInt(br.readLine());
						Random rand =new Random();
						int num=rand.nextInt(range)+1;
						while((line=br.readLine())!=null) {
							
							if(setArr[num]!=1&&line.startsWith("Q"+String.valueOf(num))){
								no.setText("Q: "+String.valueOf(i));
								Q.setText(line.substring(3));
								setArr[num]=1;
							}
							
						}
						br.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}
				else{
					no.setText("Test Comlete!!");
				}
				
				
			}
		});
		gen.setBounds(169, 157, 84, 23);
		contentPane.add(gen);
		
	}

}

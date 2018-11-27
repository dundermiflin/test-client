package oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class add extends JFrame {

	private JPanel contentPane;
	String type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add frame = new add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(21, 5, 55, 23);
		contentPane.add(lblQuestion);
		
		JTextField question = new JTextField();
		question.setBounds(74, 2, 260, 29);
		question.setVisible(false);
		contentPane.add(question);
		question.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(21, 62, 55, 14);
		contentPane.add(lblAnswer);
		
		JTextField answer = new JTextField();
		answer.setBounds(84, 58, 186, 23);
		answer.setVisible(false);
		contentPane.add(answer);
		answer.setColumns(10);
		
		JTextField opa = new JTextField();
		opa.setBounds(326, 80, 76, 23);
		opa.setVisible(false);
		contentPane.add(opa);
		opa.setColumns(10);
		
		JTextField opb = new JTextField();
		opb.setBounds(326, 114, 76, 29);
		opb.setVisible(false);
		contentPane.add(opb);
		opb.setColumns(10);
		
		JTextField opc = new JTextField();
		opc.setBounds(326, 154, 76, 23);
		opc.setVisible(false);
		contentPane.add(opc);
		opc.setColumns(10);
		
		JLabel lbla = new JLabel("a");
		lbla.setBounds(316, 88, 18, 18);
		lbla.setVisible(false);
		contentPane.add(lbla);
		
		JLabel lblb = new JLabel("b");
		lblb.setBounds(316, 121, 24, 14);
		lblb.setVisible(false);
		contentPane.add(lblb);
		
		JLabel lblc = new JLabel("c");
		lblc.setBounds(316, 151, 18, 29);
		lblc.setVisible(false);
		contentPane.add(lblc);
		
		
		JComboBox cb = new JComboBox();
		cb.setBounds(354, 11, 48, 30);
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data=""+cb.getItemAt(cb.getSelectedIndex());
				if(data.equalsIgnoreCase("T/F")) {
					type=new String("T/F");
					answer.setVisible(true);
					question.setVisible(true);
					lbla.setVisible(false);
					lblb.setVisible(false);
					lblc.setVisible(false);
					opa.setVisible(false);
					opb.setVisible(false);
					opc.setVisible(false);
				}
				else if(data.equalsIgnoreCase("FIB")) {
					
					type=new String("FIB");
					answer.setVisible(true);
					question.setVisible(true);
					lbla.setVisible(false);
					lblb.setVisible(false);
					lblc.setVisible(false);
					opa.setVisible(false);
					opb.setVisible(false);
					opc.setVisible(false);
					
				}
				else if(data.equalsIgnoreCase("MCQ")) {
					type=new String("MCQ");
					answer.setVisible(true);
					question.setVisible(true);
					lbla.setVisible(true);
					lblb.setVisible(true);
					lblc.setVisible(true);
					opa.setVisible(true);
					opb.setVisible(true);
					opc.setVisible(true);
				}
			}
		});
		cb.setModel(new DefaultComboBoxModel(new String[] {"T/F", "MCQ", "FIB"}));
		contentPane.add(cb);
		JLabel statLbl = new JLabel("");
		statLbl.setBounds(115, 129, 123, 14);
		contentPane.add(statLbl);
		
		
		
		JButton addBtn=new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String q=question.getText();
				String ans=answer.getText();
				String oa=new String("|| a."+opa.getText());
				String ob=" b."+opb.getText();
				String oc=" c."+opc.getText();
				
				try {
					BufferedReader br= new BufferedReader(new FileReader(defined.Subject));
					String line;
					int qno=Integer.parseInt(br.readLine());
					qno++;
					System.out.println(qno);
					String nl=System.lineSeparator();
					FileWriter fw=new FileWriter(defined.Subject);
					String changed=String.valueOf(qno)+nl;
					while((line=br.readLine())!=null) {
						changed=changed+line+nl;
					}
					if(cb.getSelectedIndex()==1) {
						changed=changed+nl+"#"+String.valueOf(qno)+nl+"Q"+String.valueOf(qno)+"."+q+" "+oa+ob+oc+"  ["+type+"]  "+nl+"A"+String.valueOf(qno)+"."+ans+nl;
					}
					else {
						changed=changed+nl+"#"+String.valueOf(qno)+nl+"Q"+String.valueOf(qno)+"."+q+"  ["+type+"]  "+nl+"A"+String.valueOf(qno)+"."+ans+nl;
					}
					fw.write(changed);
					br.close();
					fw.close();
					statLbl.setText("Question Added");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		addBtn.setBounds(28, 121, 77, 23);
		contentPane.add(addBtn);
		
		JButton btnHome = new JButton("Menu");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Main f =new Main();
				select f =new select();
				f.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(30, 207, 89, 23);
		contentPane.add(btnHome);
		
		
		
			}
}

package oop;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;


public class selectTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectTest frame = new selectTest();
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
	public selectTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JRadioButton p=new JRadioButton("Phy");
		p.setBounds(187, 62, 140, 23);
		JRadioButton m=new JRadioButton("Math");
		m.setBounds(187, 112, 117, 23);
		JRadioButton c=new JRadioButton("Chem");
		c.setBounds(183, 166, 121, 23);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(p);  
		contentPane.add(m);  
        contentPane.add(c);  
        contentPane.setSize(400,400);
        contentPane.setVisible(true); 
        
        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Main window = new Main();
				window.frame.setVisible(true);
				dispose();
        	}
        });
        
        btnHome.setBounds(10, 213, 89, 23);
        contentPane.add(btnHome);
        contentPane.setVisible(true);
        
        
        p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				defined.Subject=new String("Physics.txt");
				TestInput f= new TestInput();
				f.setVisible(true);
				dispose();
			}
		});
        
        c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				defined.Subject=new String("Chemistry.txt");
				TestInput f= new TestInput();
				f.setVisible(true);
				dispose();
			}
		});
        m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				defined.Subject =new String("Mathematics.txt");
				TestInput f= new TestInput();
				f.setVisible(true);
				dispose();
			}
		});
	}
}


package oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class services extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					services frame = new services();
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
	public services() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton addBtn =new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add f=new add();
				f.setVisible(true);
				dispose();
			}
		});
		addBtn.setBounds(183, 52, 91, 23);
		contentPane.add(addBtn);
		JButton delBtn =new JButton("Delete");
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete f=new delete();
				f.setVisible(true);
				dispose();
			}
		});
		delBtn.setBounds(183, 114, 91, 23);
		contentPane.add(delBtn);
		JButton modBtn =new JButton("Modify");
		modBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify mod =new Modify();
				mod.setVisible(true);
				dispose();
			}
		});
		modBtn.setBounds(183, 182, 91, 23);
		contentPane.add(modBtn);
	}

}

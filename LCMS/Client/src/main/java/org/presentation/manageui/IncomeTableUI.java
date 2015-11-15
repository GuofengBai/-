package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


public class IncomeTableUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeTableUI window = new IncomeTableUI();
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
	public IncomeTableUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(315, 229, 93, 23);
		panel.add(button);
		
		JLabel label = new JLabel("\u6210\u672C\u6536\u76CA\u8868");
		label.setBounds(182, 10, 74, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u603B\u6536\u5165");
		label_1.setBounds(72, 64, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u603B\u652F\u51FA");
		label_2.setBounds(182, 64, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u6536\u76CA");
		label_3.setBounds(293, 64, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u6536\u5165\u6570\u989D");
		label_4.setBounds(61, 105, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u652F\u51FA\u6570\u989D");
		label_5.setBounds(182, 105, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u5229\u6DA6");
		label_6.setBounds(293, 105, 54, 15);
		panel.add(label_6);
	}

}
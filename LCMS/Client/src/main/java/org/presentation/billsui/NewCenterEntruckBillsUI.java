package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import org.businesslogic.billsbl.NewCenterEntruckBillsBL;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CEBVO;
import org.vo.StateListVO;


public class NewCenterEntruckBillsUI extends JPanel {
	private JPanel superview;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField entruckNum;
	private JTextField hallNum;
	private JTextField carNum;
	private JTextField examerName;
	private JTextField driverName;
	private JButton deleteState;
	private JButton addState;
	private JTextField goodNum;
	private JLabel label_7;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton submit;
	DefaultTableModel model;
	private JButton back;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewCenterEntruckBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(10, 299, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewCenterEntruckBillsBLService bl = BLFactory.getNewCenterEntruckBillsBL();
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				CEBVO bvo = new CEBVO(date, entruckNum.getText(), hallNum.getText(), carNum.getText(), driverName.getText(), examerName.getText(), list);
				bl.addCenterEntruckBills(bvo);
			}
			
		});		
	}
	public NewCenterEntruckBillsUI(JPanel superview,CEBVO vo){
		this.superview = superview;
		submit = new JButton("更新");
		submit.setBounds(107, 299, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewCenterEntruckBillsBLService bl = BLFactory.getNewCenterEntruckBillsBL();
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				CEBVO bvo = new CEBVO(date, entruckNum.getText(), hallNum.getText(), carNum.getText(), driverName.getText(), examerName.getText(), list);
				bl.updateCenterEntruckBills(bvo);
			}
			
		});
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		entruckNum.setText(vo.TrafficNum);
		hallNum.setText(vo.HallNum);
		carNum.setText(vo.Vehicle);
		driverName.setText(vo.DriverName);
		examerName.setText(vo.ScouterName);
		for(StateListPO po:vo.po){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
		this.list=vo.po;
	}
	
	private void panel(){
		setLayout(null);
		
		JLabel label = new JLabel("\u88C5\u8F66\u65E5\u671F");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setBounds(63, 10, 66, 21);
		newyear.setColumns(10);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setBounds(134, 10, 66, 21);
		newmonth.setColumns(10);
		add(newmonth);
		
		newday = new JTextField();
		newday.setBounds(205, 10, 66, 21);
		newday.setColumns(10);
		add(newday);
		
		JLabel label_1 = new JLabel("\u6C7D\u8FD0\u7F16\u53F7");
		label_1.setBounds(10, 41, 48, 15);
		add(label_1);
		
		entruckNum = new JTextField();
		entruckNum.setColumns(10);
		entruckNum.setBounds(73, 38, 198, 21);
		add(entruckNum);
		
		JLabel label_2 = new JLabel("\u76EE\u7684\u8425\u4E1A\u5385");
		label_2.setBounds(10, 66, 64, 15);
		add(label_2);
		
		hallNum = new JTextField();
		hallNum.setBounds(83, 63, 188, 21);
		add(hallNum);
		hallNum.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8F66\u8F86\u4EE3\u53F7");
		label_3.setBounds(10, 91, 54, 15);
		add(label_3);
		
		carNum = new JTextField();
		carNum.setBounds(63, 88, 66, 21);
		add(carNum);
		carNum.setColumns(10);
		
		JLabel label_4 = new JLabel("\u76D1\u88C5\u5458");
		label_4.setBounds(10, 116, 54, 15);
		add(label_4);
		
		examerName = new JTextField();
		examerName.setBounds(63, 113, 66, 21);
		add(examerName);
		examerName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u62BC\u8FD0\u5458");
		lblNewLabel.setBounds(146, 91, 54, 15);
		add(lblNewLabel);
		
		driverName = new JTextField();
		driverName.setBounds(203, 88, 66, 21);
		add(driverName);
		driverName.setColumns(10);
		
		final JLabel price = new JLabel("");
		price.setBounds(238, 116, 33, 15);
		add(price);
		
		deleteState = new JButton("\u5220\u9664");
		deleteState.setBounds(146, 178, 125, 23);
		add(deleteState);
		deleteState.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		final JComboBox goodState = new JComboBox();
		goodState.setBounds(205, 142, 66, 21);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("损坏");
		goodState.addItem("丢失");
		
		
		addState = new JButton("\u6DFB\u52A0");
		addState.setBounds(10, 178, 119, 23);
		add(addState);
		addState.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = goodNum.getText();
				String state = goodState.getSelectedItem().toString();
				StateListVO item = new StateListVO(num,state);
				StateListPO po = new StateListPO(num,state);
				model.addRow(item);
				goodNum.setText("");
				list.add(po);
				
				
			}
			
		});
		
		goodNum = new JTextField();
		goodNum.setColumns(10);
		goodNum.setBounds(68, 142, 120, 21);
		add(goodNum);
		
		label_7 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_7.setBounds(10, 145, 54, 15);
		add(label_7);
			
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("货物状态");
		model = new DefaultTableModel(vo,str);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		table.setFillsViewportHeight(true);		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 211, 267, 78);
		add(scrollPane);

		
		JButton getPrice = new JButton("显示费用");
		getPrice.setBounds(139, 112, 89, 23);
		add(getPrice);
		
		back = new JButton("返回");
		back.setBounds(185, 299, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
		getPrice.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				price.setText("600元");
			}
			
		});		
	}
}

package org.vo;

import java.util.Vector;

import javax.swing.JPanel;

import org.po.PayingBills;
import org.po.myDate;

public class PayingBillVO extends Vector<String> implements PanelCreaterService{
	public PayingBillVO(myDate date,long money,String name,String accountName,String item,String remark,boolean examined){
		this.add(date.toString());
		this.add(String.valueOf(money));
		this.add(name);
		this.add(accountName);
		this.add(item);
		this.add(remark);
		
		if(examined){
			this.add("已审批");
		}else{
			this.add("未审批");
		}
	}
	
	public PayingBillVO(PayingBills bill){
		this.add(bill.getDate().toString());
		this.add(String.valueOf(bill.getMoney()));
		this.add(bill.getname());
		this.add(bill.getAccountName());
		this.add(bill.getItem());
		this.add(bill.getRemark());
		
		if(bill.Examined){
			this.add("已审批");
		}else{
			this.add("未审批");
		}
		
	}

	public JPanel careatePanel(JPanel su) {
		
		return null;
	}
	
}

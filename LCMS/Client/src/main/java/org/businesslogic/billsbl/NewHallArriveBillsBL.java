package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallArriveBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.CenterFreightBills;
import org.po.HallArrivingBills;
import org.po.ResultMessage;
import org.po.State;
import org.po.myDate;
import org.po.theGoodState;
import org.vo.HABVO;
import org.vo.StateListVO;

public class NewHallArriveBillsBL implements NewHallArriveBillsBLService{

	public ResultMessage addHallArriveBills(HABVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallArriveBillsData();
			message=billsData.addBills(new HallArrivingBills(vo.date,vo.idNum,vo.startPlace,vo.entruckNum,vo.list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}

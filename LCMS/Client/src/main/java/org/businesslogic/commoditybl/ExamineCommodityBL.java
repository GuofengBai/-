package org.businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.ExamineCommodityBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ComPO;
import org.po.InstorageBills;
import org.po.myDate;
import org.vo.ExamineVO;

public class ExamineCommodityBL implements ExamineCommodityBLService {
	private CommodityDataService cds;

	public Vector<ExamineVO> examineCommodity(myDate timestart, myDate timeend,
			String centerNum) throws RemoteException {
		ArrayList<BillsPO> inbillslist, outbillslist;
		Vector<ExamineVO> result = new Vector<ExamineVO>();
		List<String> arealist = this.getArea(centerNum);
		int inNum = 0, outNum = 0, nowNum = 0;
		inbillslist = RMIHelper.getDataFactory().getBillsDataFactory()
				.getNewInstorageBillsData().getByDate(timestart, timeend);
		outbillslist = RMIHelper.getDataFactory().getBillsDataFactory()
				.getNewOutstorageBillsData().getByDate(timestart, timeend);
		
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		for (String area : arealist) {
			/*
			 * 需完善
			 */
			for (BillsPO bills : inbillslist) {
				if (bills.type == BILLSTYPE.IB) {

				}
			}
			for (BillsPO bills : outbillslist) {
				if (bills.type == BILLSTYPE.OB) {

				}
			}
			ExamineVO vo = new ExamineVO(area, timestart, timeend,
					inNum, outNum, nowNum);
			result.add(vo);
		}

		// TODO Auto-generated method stub
		return result;
	}

	public ExamineCommodityBL() throws RemoteException {
		cds = RMIHelper.getDataFactory().getCommodityData();
	}

	public List<String> getArea(String centerNum) throws RemoteException {
		ArrayList<ComPO> list = cds.getAllCom(centerNum);
		String p;
		List<String> area = new ArrayList<String>();
		for (ComPO po : list) {
			p = po.getArea();
			if (!area.contains(p)) {
				area.add(p);
			}
		}
		// area.add("航运区");
		// area.add("火车区");
		// area.add("汽运区");
		return area;
	}

}

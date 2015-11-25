package org.businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.myDate;
import org.vo.CommodityVO;

public class DistrictChangeBL implements DistrictChangeBLService {
	private final static int QU = 10;
	private final static int PAI = 10;
	private final static int JIA = 10;
	private final static int WEI = 10;
	Vector<CommodityVO> vdata1;
	Vector<CommodityVO> vdata2;

	// List<String> area;
	public DistrictChangeBL() {
		vdata1 = new Vector<CommodityVO>();
		vdata2 = new Vector<CommodityVO>();

	}

	public void change(String from, String to, int index)
			throws RemoteException {
		// TODO Auto-generated method stub
		CommodityVO vo = vdata1.get(index);
		myDate newdate = new myDate(Integer.parseInt(vo.getyear()),
				Integer.parseInt(vo.getmonth()), Integer.parseInt(vo.getday()));
		CommodityVO newvo = new CommodityVO(vo.getGoodsNum(), newdate,
				vo.getplace(), vo.getLocation(), to, vo.getcity());
		changeDistrict(vo);
	}

	public Vector<CommodityVO> getDistrictCommodity(String centerNum,
			String from) throws RemoteException {
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		vdata1 = new Vector<CommodityVO>();
		ArrayList<ComPO> list = cds.getAllCom();
		for (ComPO po : list) {
			CommodityVO vo;
			if (po.getcenterNum().equals(centerNum)) {
				if (po.getArea().equals(from))
					vdata1.add(vo = new CommodityVO(po.getGoodsNum(), po
							.getinDate(), po.getplace(), po.LocationNum(), po
							.getArea(), po.getcenterNum()));
			}
		}
		return vdata1;
	}

	public void changeDistrict(CommodityVO vo) throws RemoteException {
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		ComPO po, po1;
		try {
			po = cds.findCom(vo.getGoodsNum());
			cds.delCom(po);
			po1 = new ComPO(vo.getGoodsNum(), po.getinDate(), vo.getplace(),
					vo.getLocation(), vo.getarea(), po.getcenterNum());
			cds.addCom(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> getArea(String centerNum) throws RemoteException {
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		ArrayList<ComPO> list = cds.getAllCom();
		String p;
		List<String> area = new ArrayList<String>();
		for (ComPO po : list) {
			if (po.getcenterNum().equals(centerNum)) {
				p = po.getArea();
				if (!area.contains(p)) {
					area.add(p);
				}
			}
		}
		// area.add("航运区");
		// area.add("火车区");
		// area.add("汽运区");
		return area;
	}

	public Vector<CommodityVO> getEmpty(String centerNum, String to)
			throws RemoteException {
		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		ArrayList<ComPO> list = cds.getAllCom();
		vdata2 = new Vector<CommodityVO>();
		String location;
		for (ComPO po : list) {
			CommodityVO vo;
			if (po.getcenterNum().equals(centerNum)) {
				for (int quhao = 0; quhao < QU; quhao++) {
					for (int paihao = 0; paihao < PAI; paihao++) {
						for (int jiahao = 0; jiahao < JIA; jiahao++) {
							for (int weihao = 0; weihao < WEI; weihao++) {
								if (!po.getGoodsNum().equals(
										location = String.valueOf(quhao)
												+ String.valueOf(paihao)
												+ String.valueOf(jiahao)
												+ String.valueOf(weihao))) {
									vdata2.add(vo = new CommodityVO(" ",
											new myDate(0, 0, 0), " ", location,
											" ", " "));
								}
							}
						}
					}
				}
			}
			// 设计每个仓库（航运仓库、火车仓库、汽运仓库）下各有10区，每区下10排，每排下10架，每架下10位
		}
		return vdata2;
	}

}

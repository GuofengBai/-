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
import org.vo.CommodityVO;

public class DistrictChangeBL implements DistrictChangeBLService {
	private final static int QU=20;
	private final static int PAI=20;
	private final static int JIA=20;
	private final static int WEI=20;
	Vector<CommodityVO> vdata;
	//List<String> area;

	public ComPO change(String from, String to) throws RemoteException {
		// TODO Auto-generated method stub
		getDistrictCommodity(from);
		
		return null;

	}

	public Vector<CommodityVO> getDistrictCommodity(String from) throws RemoteException {
		CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();
		vdata=new Vector<CommodityVO>();
		ArrayList<ComPO> list = cds.getAllCom();
		for (ComPO po : list) {
			CommodityVO vo;
			if (po.getArea().equals(from))
				vdata.addElement(vo = new CommodityVO(po.getGoodsNum(), po
						.getinDate(), po.getplace(), po.LocationNum(), po
						.getArea()));
		}
		return vdata;
	}
	public void changeDistrict(CommodityVO vo) throws RemoteException{
		CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();
		ComPO po,po1;
		try {
			po=cds.findCom(vo.getGoodsNum());
			cds.delCom(po);
			po1=new ComPO(vo.getGoodsNum(),po.getinDate(),vo.getplace(),vo.getLocation(),vo.getarea(),po.getcity());
			cds.addCom(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<String> getArea() throws RemoteException{
		CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();
		ArrayList<ComPO> list = cds.getAllCom();
		String p;
		List<String> area = new ArrayList<String>();
		//for(ComPO po:list){
		//	p=po.getArea();
		//	if(!area.contains(p)){
		//		area.add(p);
		//	}
		//}
		area.add("航运区");
		area.add("火车区");
		area.add("汽运区");
		return area;
	}
	public Vector<CommodityVO> getEmpty(String to) throws RemoteException {
		CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();
		ArrayList<ComPO> list = cds.getAllCom();
		vdata=new Vector<CommodityVO>();
		for (ComPO po : list) {
			CommodityVO vo;
			for(int quhao=11;quhao<QU;quhao++){
				for(int paihao=11;paihao<PAI;paihao++){
					for(int jiahao=11;jiahao<JIA;jiahao++){
						for(int weihao=11;weihao<WEI;weihao++){
							if(!po.getGoodsNum().equals(String.valueOf(quhao)+String.valueOf(paihao)+String.valueOf(jiahao)+String.valueOf(weihao))){
								
							}
						}
					}
				}
			}
			//设计每个仓库（航运仓库、火车仓库、汽运仓库）下各有10区，每区下10排，每排下10架，每架下10位
		}
		return vdata;
	}

}

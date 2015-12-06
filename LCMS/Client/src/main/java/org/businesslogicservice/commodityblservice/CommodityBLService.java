package org.businesslogicservice.commodityblservice;

import org.po.ResultMessage;
import org.po.myDate;

import java.util.Date;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

public interface CommodityBLService {
	boolean Commodityinable = true;
	/**
	 * 
	 * @param centerNum
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage addCenter(String centerNum) throws RemoteException;
	/**
	 * 
	 * @param centerNum
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage delCenter(String centerNum) throws RemoteException;
	
	
	
}




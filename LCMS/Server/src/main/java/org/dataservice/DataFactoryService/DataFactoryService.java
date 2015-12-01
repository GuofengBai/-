package org.dataservice.DataFactoryService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.dataservice.billsdataservice.BillsDataService;

import org.dataservice.commoditydataservice.CommodityDataService;
import org.dataservice.managedataservice.ManageDataService;
import org.dataservice.organizationdataservice.OrganizationDataService;
import org.dataservice.staffdataservice.StaffDataService;
import org.dataservice.userdataservice.UserDataService;

public interface DataFactoryService extends Remote{

	public CommodityDataService getCommodityData()throws RemoteException;
	
	public BillsDataFactoryService getBillsDataFactory()throws RemoteException;
	
	public UserDataService getUserData()throws RemoteException;
	
	public OrganizationDataService getOrganizationData()throws RemoteException;
	
	public StaffDataService getStaffData()throws RemoteException;
	
	public ManageDataFactoryService getManageDataFactory()throws RemoteException;
	

}
package org.dataservice.DataFactoryService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.dataservice.organizationdataservice.HallDataService;

public interface OrganizationDataFactoryService extends Remote{
	
	public HallDataService getHallData()throws RemoteException;
	

}
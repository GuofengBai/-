package org.po;

import java.util.ArrayList;

public class CenterCom {
	
	public ArrayList<ComPO> ComList;
	
	public String centerNum;
	
	public CenterCom(){
		this(null,null);
	}

	public CenterCom(ArrayList<ComPO> ComList,String centerNum){
		super();
		this.ComList=ComList;
		this.centerNum=centerNum;
	}
}

package org.vo;

import org.po.myDate;

public class ComVO {
	private String GoodsNum;// ���˵���
	private myDate inDate;// �������
	private String place;// Ŀ�ĵ�
	private String LocationNum;// �����źżܺ�λ��
	private String area;

	public ComVO(String GoodsNum, myDate inDate, String place, String LocationNum,String area) {
		this.GoodsNum = GoodsNum;
		this.inDate = inDate;
		this.place = place;
		this.LocationNum = LocationNum;
		this.area=area;
	}
}

package com.biz.commerce.vo;

public class DataVO {

	private String strDate ;
	private String barCode ;
	private String strHow ; // 거래구분
	private int intPrice ;
	private int intQuan ;
	
	
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getStrHow() {
		return strHow;
	}
	public void setStrHow(String strHow) {
		this.strHow = strHow;
	}
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	public int getIntQuan() {
		return intQuan;
	}
	public void setIntQuan(int intQuan) {
		this.intQuan = intQuan;
	}
	
	@Override
	public String toString() {
		return "DataVO [strDate=" + strDate + ", barCode=" + barCode + ", strHow=" + strHow + ", intPrice=" + intPrice
				+ ", intQuan=" + intQuan + "]";
	}
	
	
}

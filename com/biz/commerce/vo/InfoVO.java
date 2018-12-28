package com.biz.commerce.vo;
/*
 * 상품정보 파일의 데이터를 저장할 vo선언
 */
public class InfoVO {
	/*
	 * 상품정보의 각 요소를 저장할 member변수선언
	 * 은닉, 캡슐화를 위해 private 선언
	 */
	private String barCode ;
	private String pName ; // 상품명
	private String tax ;
	private int iPrice ;
	private int oPrice ;
	private String index ; // 품목
	private String cPart ; // 거래처
	
	/*
	 * 멤버변수에 접근해서 작업할 getter setter 선언
	 */
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public int getiPrice() {
		return iPrice;
	}
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	public int getoPrice() {
		return oPrice;
	}
	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getcPart() {
		return cPart;
	}
	public void setcPart(String cPart) {
		this.cPart = cPart;
	}
	
	@Override
	public String toString() {
		return "ComVO [barCode=" + barCode + ", pName=" + pName + ", tax=" + tax + ", iPrice=" + iPrice + ", oPrice="
				+ oPrice + ", index=" + index + ", cPart=" + cPart + "]";
	}
	
	
	
}

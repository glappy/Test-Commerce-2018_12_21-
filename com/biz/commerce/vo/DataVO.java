package com.biz.commerce.vo;

public class DataVO {
	/*
	 * 매입매출데이터 파일을 읽어서 list를 만들때 쓸 vo선언
	 * 
	 * 거래일자:상품코드:거래구분:단가:수량   데이터를 읽어서 각 member변수에 저장
	 * 각 변수는 정보은닉과 캡슐화를 위해 private으로 선언
	 */
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
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * vo에 데이터를 저장한 후 데이터를 확인하는 디버깅용 메서드를 재정의한다
	 */
	@Override
	public String toString() {
		return "DataVO [strDate=" + strDate + ", barCode=" + barCode + ", strHow=" + strHow + ", intPrice=" + intPrice
				+ ", intQuan=" + intQuan + "]";
	}
	
	
}

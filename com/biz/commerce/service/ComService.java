package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.DataVO;
import com.biz.commerce.vo.InfoVO;

/*
 * 매입매출과 관련된 작업을 수행할 클래스 선언
 */
public class ComService {

	/*
	 * 각 데이터를 관리할 list선언
	 */
	List<DataVO> dvList;
	List<InfoVO> ifList;
	DataVO dvo = new DataVO(); // 다른 메서드에서 다시 초기화나 선언 않고 쓰기 위해 생성자 위에서 선언, 초기화
	InfoVO ivo = new InfoVO();

	public ComService() {
		/*
		 * 생성자에서 list초기화
		 */
		dvList = new ArrayList();
		ifList = new ArrayList();

	}

	/*
	 * 데이터파일을 읽어올 메서드 선언
	 * 읽은 내용을 vo와 list에 저장한다
	 */
	public void readDataFile() {
		
		String dataFile = "src/com/biz/commerce/service/매입매출데이터.txt";
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(dataFile);
			buffer = new BufferedReader(fr);

			while (true) {
				String dataRead = buffer.readLine();
				if (dataRead == null)
					break;
				String[] sDataRead = dataRead.split(":");

				
				dvo.setStrDate(sDataRead[0]);
				dvo.setBarCode(sDataRead[1]);
				dvo.setStrHow(sDataRead[2]);
				dvo.setIntPrice(Integer.valueOf(sDataRead[3]));
				dvo.setIntQuan(Integer.valueOf(sDataRead[4]));

				dvList.add(dvo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 상품정보 파일을 읽겠다는 메서드 선언
	 * 읽어서 각 정보를 vo와 list에 저장한다
	 */
	public void readInfoFile() {
		String infoFile = "src/com/biz/commerce/service/상품정보.txt";
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(infoFile);
			buffer = new BufferedReader(fr);

			while (true) {
				String infoRead = buffer.readLine();
				if (infoRead == null)
					break;
				String[] sInfoRead = infoRead.split(":");

				
				/*
				 * 한줄 한줄 읽어서 ":"를 기준으로 분리한 값들을 vo 항목에 저장하고 list에 vo를 저장하되  infoRead값이 null이면 멈춰라
				 */
				ivo.setBarCode(sInfoRead[0]);
				ivo.setpName(sInfoRead[1]);
				ivo.setTax(sInfoRead[2]);
				ivo.setiPrice(Integer.valueOf(sInfoRead[3]));
				ivo.setoPrice(Integer.valueOf(sInfoRead[4]));
				ivo.setIndex(sInfoRead[5]);
				ivo.setcPart(sInfoRead[6]);
				ifList.add(ivo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 읽은 내용을 조합해서 저장하는 메서드
	 * pw 선언
	 */
	public void saveNew() {
		String newFile = "src/com/biz/commerce/service/상품매입매출.txt";
		PrintWriter pw;

		int iPrice = 0;
		int oPrice = 0;
		String pwInout = "";
		
		try {
			pw = new PrintWriter(newFile);

			for (InfoVO ivo : ifList) {
				/*
				 * 상품정보 파일에서 구분이 1이면 데이터파일의 가격과 수량을 곱해서 매입금액으로, 그렇지 않으면 가격과 수량을 곱해서 매출금액으로 저장한다
				 */

				if(ivo.getIndex().equals("1")) {
					iPrice = dvo.getIntPrice()*dvo.getIntQuan();
					oPrice = 0;
					pwInout = "매입";
				} else {
					iPrice = 0;
					oPrice = dvo.getIntPrice()*dvo.getIntQuan();
					pwInout = "매출";
				}
				
				/*
				 * if에서 수행된 결과를 파일에 저장
				 */
				pw.println("거래일자:거래구분:상품코드:상품명:단가:수량:매입금액:매출금액");
				pw.print(dvo.getStrDate() + ":");
				pw.print(pwInout + ":");
				pw.print(dvo.getBarCode() + ":");
				pw.print(ivo.getpName()+ ":");
				pw.print(dvo.getIntPrice() + ":");
				pw.print(dvo.getIntQuan() + ":");
				pw.print(iPrice + ":");
				pw.print(oPrice + "\n");
				
			}
			/*
			 * 파일에 저장하고 pw를 마무리
			 */
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
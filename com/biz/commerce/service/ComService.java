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

public class ComService {

	List<DataVO> dvList;
	List<InfoVO> ifList;
	DataVO dvo;
	InfoVO ivo;

	public ComService() {
		dvList = new ArrayList();
		ifList = new ArrayList();

	}

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

				DataVO dvo = new DataVO();
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

				InfoVO ivo = new InfoVO();

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

	public void saveNew() {
		String newFile = "src/com/biz/commerce/service/상품매입매출.txt";
		PrintWriter pw;

		try {
			pw = new PrintWriter(newFile);

			for (DataVO dvo : dvList) {

				if (dvo.getStrHow().equals("1")) {
					pw.printf("%s:%s:%s:%s:%d:%d:%d:%d\n", dvo.getStrDate(), "매입", dvo.getBarCode(), ivo.getpName(),
							dvo.getIntPrice(), dvo.getIntQuan(), dvo.getIntPrice() * dvo.getIntQuan(), 0);

				} else {
					pw.printf("%s:%s:%s:%s:%d:%d:%d:%d\n", dvo.getStrDate(), "매출", dvo.getBarCode(), ivo.getpName(),
							dvo.getIntPrice(), dvo.getIntQuan(), 0, dvo.getIntPrice() * dvo.getIntQuan());
				}
			}

			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

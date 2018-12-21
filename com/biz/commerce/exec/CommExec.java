package com.biz.commerce.exec;

import com.biz.commerce.service.ComService;

public class CommExec {

	public static void main(String[] args) {
		ComService cs = new ComService();
		cs.readDataFile();
		cs.readInfoFile();
		cs.saveNew();
	}

}

package com.biz.exam.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.biz.exam.domain.BBsVO;
import com.biz.exam.utils.BBsInfo;

public class BBsReadServiceV1 implements BBsReadService {

	List<BBsVO> bbsList;
	@Override
	public List<BBsVO> getBBsList() {
		return bbsList;
	}

	@Override
	public void readBBS(String bbsFile) throws Exception {
		
		bbsList = new ArrayList<BBsVO>();
		
		FileReader fileReader;
		BufferedReader buffer;
		
		fileReader = new FileReader(bbsFile);
		buffer = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			reader = buffer.readLine();
			if(reader == null) break;
			
			String[] bbss = reader.split(":");
			BBsVO bbsVO = new BBsVO();
			int intSeq = Integer.valueOf(bbss[BBsInfo.LIST.SEQ]);
			bbsVO.setSeq(intSeq);
			bbsVO.setAuth(bbss[BBsInfo.LIST.AUTH]);
			int intDate = Integer.valueOf(bbss[BBsInfo.LIST.DATE]);
			bbsVO.setDate(intDate);
			bbsVO.setSubject(bbss[BBsInfo.LIST.SUB]);
			bbsVO.setText(bbss[BBsInfo.LIST.TEXT]);
			int intCount = Integer.valueOf(bbss[BBsInfo.LIST.COUNT]);
			bbsVO.setCount(intCount);
			
			bbsList.add(bbsVO);
			
		}
		buffer.close();
		fileReader.close();
		
	}
}
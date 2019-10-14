package com.biz.exam.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.biz.exam.domain.BBsVO;

public class BBsViewServiceV1 implements BBsViewService {

	List<BBsVO> bbsList;
	Collections sort;
	
	@Override
	public void setBBsList(List<BBsVO> bbsList) {
		this.bbsList = bbsList;
	}

	@Override
	public void viewTitle() {
		System.out.println("=====================================================================================================");
		System.out.println("게시판");
		System.out.println("=====================================================================================================");
		System.out.println("순번\t작성자\t작성일자\t제목\t내용\t조회수");
		System.out.println("-----------------------------------------------------------------------------------------------------");
	}

	@Override
	public void viewBody(BBsVO bbsVO) {
		System.out.print(bbsVO.getSeq() + "\t");
		System.out.print(bbsVO.getAuth() + "\t");
		System.out.print(bbsVO.getDate() + "\t");
		System.out.print(bbsVO.getSubject() + "\t");
		System.out.print(bbsVO.getText() + "\t");
		System.out.print(bbsVO.getCount() + "\n");
	}

	@Override
	public void viewBBS() {
		this.viewTitle();
		for(BBsVO bbsVO : bbsList) {
			this.viewBody(bbsVO);
		}
		System.out.println("=====================================================================================================");
	}

	@Override
	public void viewBBS(String subject) {
		this.viewTitle();
		for(BBsVO bbsVO : bbsList) {
			if(bbsVO.getSubject().contains(subject.trim())) {
				this.viewBody(bbsVO);
			}
		}
		System.out.println("=====================================================================================================");
	}

	@Override
	public void viewBBS(int sDate, int eDate) {
		this.viewTitle();
		for(BBsVO bbsVO : bbsList) {
			int date = bbsVO.getDate();
			if(date >= sDate && date <= eDate ) {
				this.viewBody(bbsVO);
			}
		}
		System.out.println("=====================================================================================================");
	}

	@Override
	public void viewBBS(boolean sort) {
		/*
		   public int compare(bbsKus o1, Board o2) {
		         
		        int c1 = o1.getCnt();
		        int c2 = o2.getCnt();
		        if (c1 < c2) {
		            return 1;
		        } else if (c1 > c2) {
		            return -1;
		        } else { // c1 == c2
		            // (-1) 내림차순을 위한 부호 변환
		            return (-1) * (o1.getDate().compareTo(o2.getDate()));
		        }
		        	*/
	}
	
	// 오름차순 내림차순을 해보려고 했으나 어려웠습니다..
}
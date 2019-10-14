package com.biz.exam.exec;

import java.util.List;
import java.util.Scanner;

import com.biz.exam.domain.BBsVO;
import com.biz.exam.service.BBsReadService;
import com.biz.exam.service.BBsReadServiceV1;
import com.biz.exam.service.BBsViewService;
import com.biz.exam.service.BBsViewServiceV1;

public class BBsEx_01 {

	public static void main(String[] args) {
		
		BBsReadService bbsRead = new BBsReadServiceV1();
		String bbsFile = "src/com/biz/exam/bbs.txt";
		
		BBsViewService bbsView = new BBsViewServiceV1();
		
		Scanner scan = new Scanner(System.in);
		
		try {
			bbsRead.readBBS(bbsFile);
			
			List<BBsVO> bbsVO = bbsRead.getBBsList();
			bbsView.setBBsList(bbsVO);
			
			bbsView.viewBBS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("==============================================");
		System.out.println("게시판 관리 시스템 v1");
		System.out.println("==============================================");
		System.out.println("1.전체 2.제목 3. 날짜 4.오름순번 5.내림순번 0.종료");
		System.out.println("----------------------------------------------");
		System.out.print("업무선택 >> ");
		String works = scan.nextLine();
		int work = Integer.valueOf(works);
		while(true) {
			if(work == 0) break;
			
			if(work == 1) {
				bbsView.viewBBS();
				return;
				// return 을 하지 않으면 무한을 보여지고 
				// 전체 조회를 한번만 보여주고 하고 다시 위로 돌아가려고 했는데
				// 그게 되지를 않아 return 문으로 1번만 조회 되게 했습니다.
			} else if(work == 2) {
				System.out.print("제목 >> ");
				String sub = scan.nextLine();
				bbsView.viewBBS(sub);
			} else if(work == 3) {
				System.out.print("시작 날짜 >> ");
				String sDate = scan.nextLine();
				System.out.print("마지막 날짜 >> ");
				String eDate = scan.nextLine();
				bbsView.viewBBS(Integer.valueOf(sDate), Integer.valueOf(eDate));
			} else if(work == 4) {
				bbsView.viewBBS(true);
			} else if(work == 5) {
				bbsView.viewBBS(false);
				
				// 오름차순 내림차순을 해보려고 했으나 어려웠습니다..
			}
		}
		System.out.println("종료");

	}

}
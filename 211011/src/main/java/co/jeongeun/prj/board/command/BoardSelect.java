package co.jeongeun.prj.board.command;

import java.util.Scanner;

import co.jeongeun.prj.board.service.BoardService;
import co.jeongeun.prj.board.service.BoardVO;
import co.jeongeun.prj.board.serviceImpl.BoardServiceImpl;

public class BoardSelect implements Command {
	private Scanner scb = new Scanner(System.in);
	@Override
	public void execute() {
//		BoardService dao = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		System.out.println("=================");
		System.out.println("조회할 글 번호를 입력하세요.");
		board.setBId(scb.nextInt());scb.nextLine();
		board = dao.boardSelect(board);
		
		System.out.print("번호: "+board.getBId());
		System.out.print(" 작성자: "+board.getBWriter());
		System.out.print(" 작성일: "+board.getBWriteDate());
		System.out.print(" 제목: "+board.getTitle());
		System.out.print(" 내용: "+board.getBContents());
		System.out.println(" 조회수: "+board.getBHit());
		
		
	}

}

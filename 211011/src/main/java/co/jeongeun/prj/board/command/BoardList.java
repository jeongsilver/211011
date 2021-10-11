package co.jeongeun.prj.board.command;

import java.util.*;

//import co.jeongeun.prj.board.service.BoardService;
import co.jeongeun.prj.board.service.BoardVO;
//import co.jeongeun.prj.board.serviceImpl.BoardServiceImpl;

public class BoardList implements Command { //게시글 목록 보는 명령
	private List<BoardVO> list = new ArrayList<BoardVO>();
//	private BoardService dao = new BoardServiceImpl();
	
	public void execute() {
		list = dao.boardSelectList();
		System.out.println("순번:  작성자	:	작성일자	:	제목	 : 조회수 ");
		for(BoardVO vo : list) {
			System.out.print(vo.getBId()+ "  : ");
			System.out.print(vo.getBWriter()+"	:	");
			System.out.print(vo.getBWriteDate()+ " : ");
			System.out.print(vo.getTitle()+ " : ");
			System.out.println(vo.getBHit());
			
		}
	}
}

package co.jeongeun.prj; //package : 회사도메인역순.prj명.단위서비스명

import co.jeongeun.prj.board.command.BoardList;
import co.jeongeun.prj.board.command.BoardSelect;
import co.jeongeun.prj.board.command.Command;
import co.jeongeun.prj.comm.BoardMenu;

public class MainApp {

	//게시판 프로젝트
	//1. vo 객체생성
	//2. interface 생성
	//3. interface 구현체 생성
	
	public static void main(String[] args) {
//		BoardListCommand blist = new BoardListCommand();
//		blist.execute();
		
//		Command command = new BoardSelect();
//		command.execute();
		
		BoardMenu boardMenu = new BoardMenu();
		boardMenu.run();

}
}


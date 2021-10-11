package co.jeongeun.prj.comm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.jeongeun.prj.board.command.BoardDelete;
import co.jeongeun.prj.board.command.BoardInsert;
import co.jeongeun.prj.board.command.BoardList;
import co.jeongeun.prj.board.command.BoardSelect;
import co.jeongeun.prj.board.command.BoardUpdate;
import co.jeongeun.prj.board.command.Command;

public class BoardMenu {
	private Scanner sc = new Scanner(System.in);
	private Map<String, Command> map = new HashMap<String, Command>();
	
	public BoardMenu() {
		map.put("boardList", new BoardList());
		map.put("boardSelect", new BoardSelect());
		map.put("boardInsert", new BoardInsert());
		map.put("boardUpdate", new BoardUpdate());
		map.put("boardDelete", new BoardDelete());
	}
	private void boardTitle() {
		System.out.println("================");
		System.out.println("=1. 공지사항 목록 =");
		System.out.println("=2. 공지사항 조회 =");
		System.out.println("=3. 공지사항 등록 =");
		System.out.println("=4. 공지사항 수정 =");
		System.out.println("=5. 공지사항 삭제 =");
		System.out.println("=6.    종료     =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 선택하세요.");
		
	}
	private void menu() {
		while(true) {
			boardTitle();
			int job = sc.nextInt();sc.nextLine();
			switch(job) {
			case 1:
				commandRun("boardList");
				break;
			case 2:
				commandRun("boardSelect");
				break;
			case 3:
				commandRun("boardInsert");
				break;
				
			case 4:
				commandRun("boardUpdate");
				break;
				
			case 5:
				commandRun("boardDelete");
				break;
				
			case 6:
				System.out.println("종료");
				sc.close();
				break;
				
			}
		} //while end
	}
	private void commandRun(String comm) {
		Command command = map.get(comm);
		command.execute();
		
	}
	
	public void run() {
		menu();
	}
}

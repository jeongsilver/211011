package co.jeongeun.prj.board.command;

import co.jeongeun.prj.board.service.BoardService;
import co.jeongeun.prj.board.serviceImpl.BoardServiceImpl;
import co.jeongeun.prj.mybatis.BoardMybatisService;

public interface Command {
//	public BoardService dao = new BoardServiceImpl();
	public BoardService dao = new BoardMybatisService(); //public은 무조건 상속이 됨
	public void execute();
}

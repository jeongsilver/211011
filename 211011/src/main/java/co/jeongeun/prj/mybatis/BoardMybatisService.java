package co.jeongeun.prj.mybatis;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;


import co.jeongeun.prj.board.service.BoardService;
import co.jeongeun.prj.board.service.BoardVO;

public class BoardMybatisService implements BoardService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BoardMapper map =  sqlSession.getMapper(BoardMapper.class);
		

	@Override
	public List<BoardVO> boardSelectList() {
		
		return map.boardSelectList();
	}

	@Override
	public BoardVO boardSelect(BoardVO board) {
		// TODO Auto-generated method stub
		return map.boardSelect(board);
	}

	@Override
	public int boardInsert(BoardVO board) {
		// TODO Auto-generated method stub
		return map.boardInsert(board);
	}

	@Override
	public int boardUpdate(BoardVO board) {
		// TODO Auto-generated method stub
		return map.boardUpdate(board);
	}

	@Override
	public int boardDelete(BoardVO board) {
		// TODO Auto-generated method stub
		return map.boardDelete(board);
	}

}

package co.jeongeun.prj.board.serviceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.jeongeun.prj.board.service.BoardService;
import co.jeongeun.prj.board.service.BoardVO;
import co.jeongeun.prj.comm.DataSource;

public class BoardServiceImpl implements BoardService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs; // select객체

	@Override
	public List<BoardVO> boardSelectList() { //전체리스트 가져오기
		// 리스트 객체 하나 필요
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO board;
		String sql = "select * from board";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO(); //BoardVO 초기화
				board.setBId(rs.getInt("bid"));
				board.setBWriter(rs.getString("bwriter"));
				board.setBWriteDate(rs.getDate("bwritedate"));
				board.setTitle(rs.getString("title"));
				board.setBHit(rs.getInt("bhit"));
				list.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO board) { //선택된 하나의 글 읽기
		String sql = "select * from board where bid=?"; //유니크키로 설정
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				board.setBWriter(rs.getString("bwriter"));
				board.setBWriteDate(rs.getDate("bwritedate"));
				board.setTitle(rs.getString("title"));
				board.setBContents(rs.getString("bcontents"));
				board.setBHit(rs.getInt("bhit"));
				hitUpdate(board.getBId()); //조회수 증가
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return board;
	}

	@Override
	public int boardInsert(BoardVO board) { //글 추가
		int n=0;
		String sql ="insert into board values(b_squ.nextval,?,sysdate,?,?,0)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,board.getBWriter());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getBContents());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
			
		return n;
	}

	@Override
	public int boardUpdate(BoardVO board) { //글 수정
		int n=0;
		String sql = "update board set bcontents =? where bid=?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBContents());
			psmt.setInt(2, board.getBId());
			n= psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO board) { // 글 삭제
		int n=0;
		String sql = "delete from board where bid =?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void hitUpdate(int bId) {//조회수 증가 
		String sql = "update board set bhit = bhit+1 where bid = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bId);
			psmt.executeUpdate();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package co.jeongeun.prj.board.service;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@NoArgsConstructor 디폴트 생성자
@Setter
@Getter
public class BoardVO {
	private int bId;
	private String bWriter;
	private Date bWriteDate;
	private String Title;
	private String bContents;
	private int bHit;
	


	
	
	
}

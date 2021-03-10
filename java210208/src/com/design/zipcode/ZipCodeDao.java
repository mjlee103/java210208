package com.design.zipcode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.util.DBConnectionMgr;
/*
 * A a = new A( );
 * 
 * A a = null;
 * a =new A();
 * 
 * A a = A.getInstance();
 */
public class ZipCodeDao {
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
	DBConnectionMgr 	dbMgr 	= null; //db연동 공동코드
	public ZipCodeDao() {
		dbMgr = DBConnectionMgr.getInstance(); 	//초기화, 위에 dbconnection이 인식 못해서 	ui가져오는 싱글톤 방식으로 설정.?
		try {
			con = dbMgr.getConnection();
		} catch (Exception e) {
			System.out.println("오라클 서버 연결 실패!!!!!");
		}
	}
	//클래스 쪼개기에서 초급자가 항상 염두에 둘 사항은 배달 사고 임. 파타미터 값이 String dong이 들어와야 함. 
	public ArrayList<ZipCodeVO> getZipCodeList(String dong){//<집브이오>:내 안에 너 있다. ArrayList는 import
		System.out.println("getZipCodeList 호출 성공"+dong);
		ArrayList zipcodeList = null;
		return zipcodeList;
	}
}


package ch5.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConnectionMgr;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/*************************************************************
 * 대량의 정보를 조회시 오라클에서 제공하는 REFCURSOR를 활용할 수 있다.
 * @author mjlee
 * CREATE OR REPLACE PROCEDURE apple.proc_temp_list(p_temp OUT sys_refcursor)
	IS
	BEGIN
    OPEN p_temp
    FOR SELECT emp_id, emp_name, lev FROM temp;
	END;
	
	JBDC 연동 기술은 공통된 관심사이다.
	매번 동시 접속사 수가 많을 수 있고, 다중처리를 해야하므로 DB커넥션 풀링을 고려해야 함. TOMCAT에서 자체 제공하는 풀링이 있음. 요즘으 HikariCP도 나옴.  
 *************************************************************/

public class REFCursorTest {
	Connection 				con 	= null;
	CallableStatement 		cstmt 	= null;
	OracleCallableStatement osctmt 	= null;
	ResultSet 				rs		= null;
	DBConnectionMgr 		dbMgr 	= null;
	public void init() {
		
	}
	public List<Map<String,Object>> getTempList(){ //map은 vo 대용으로 사용함. 
		List<Map<String,Object>> list = new ArrayList<>(); // 자바 가상머신 1.5이후에서만 이런식으로 작성가능 
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_temp_list(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			osctmt = (OracleCallableStatement)cstmt;
			rs = osctmt.getCursor(1);
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("emp_id",  rs.getInt("emp_id"));
				rmap.put("emp_name",  rs.getInt("emp_name"));
				rmap.put("lev",  rs.getInt("lev"));
				list.add(rmap);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		REFCursorTest rt = new REFCursorTest();
		rt.init();
		List<Map<String,Object>> list = rt.getTempList();
		for(Map<String,Object> pMap:list) {
			System.out.println(pMap);
		}

	}

}

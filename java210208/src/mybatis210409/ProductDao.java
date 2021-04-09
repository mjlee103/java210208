package mybatis210409;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ProductDao {
	   MyDeptVO dVO = null;
	   //전체조회
	   public void refresh(ProductCon pc) {
	      //연결 베이스///////////////////////////////////////
	      SqlSessionFactory sqlSessionFactory = null;
	      sqlSessionFactory = MyBatisCommonFactory.getInstance();
	      SqlSession sqlSession = null;
	      List<MyDeptVO> productList = new ArrayList<>();
	      //새로고침 하기////////////////////////////////////////
	      try {
	            sqlSession=sqlSessionFactory.openSession();
	            productList = sqlSession.selectList("refresh");
	         }
	      catch (Exception se) {
	            System.out.println("SQLException:"+se.getMessage());//좀 더 구체적인 예외처리 클래스 정보를 알 수 있다.
	      }finally {
	         sqlSession.close();
	      }
	      //while(pc.pv.dtm_dept.getRowCount()>0) {
	      //   pc.pv.dtm_dept.removeRow(0);
	      //}
	      for(MyDeptVO pro:productList) {
	         Vector onerow = new Vector();
	         onerow.add(pro.getProductnum());
	         onerow.add(pro.getProductname());
	         pc.pv.dtm_dept.addRow(onerow);
	      }
	   }
	
	public void set(String title, MyDeptVO dVO, ProductView pv, boolean isFlag1,boolean isFlag2,ProductCon pc) {
		pc.pv = pv;
		this.dVO   = dVO;
		pc.pv.pDia.setTitle(title);
		pc.pv.pDia.setVisible(true);
		this.setValue(this.dVO,pc);
		this.setEnabled(isFlag1,isFlag2,pc);
	}
	public void setEnabled(boolean isFlag1,boolean isFlag2,ProductCon pc) {
		pc.pv.pDia.jtf_productno.setEditable(isFlag2);
		pc.pv.pDia.jtf_productname.setEditable(isFlag2);
		pc.pv.pDia.jtf_danga.setEditable(isFlag1);
		pc.pv.pDia.jtf_productcompany.setEditable(isFlag2);
	}
	private void setValue(MyDeptVO dVO,ProductCon pc) {
      if(dVO == null) {
    	 pc.pv.pDia.jtf_productno.setText("");
    	 pc.pv.pDia.jtf_productname.setText("");
    	 pc.pv.pDia.jtf_danga.setText("");
    	 pc.pv.pDia.jtf_productcompany.setText("");
      }
	  //상세조회, 수정시에는 오라클에서 조회된 값으로 초기화 해야 합니다.
      else {
    	 pc.pv.pDia.jtf_productno.setText(dVO.getProductnum());
    	 pc.pv.pDia.jtf_productname.setText(dVO.getProductname());
    	 pc.pv.pDia.jtf_danga.setText(String.valueOf(dVO.getDanga()));
    	 pc.pv.pDia.jtf_productcompany.setText(dVO.getProductcompany());
      }
	}
	
	 //조회
	public void condition(String testname,ProductCon pc) {
		int index[] = pc.pv.jtb_dept.getSelectedRows();
		if(index.length==0) {
            JOptionPane.showMessageDialog(pc.pv.jf, "조회할 데이터를 선택하세요","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //선택된 로우가 한 개 이상인 경우
        else if(index.length > 1) {
            JOptionPane.showMessageDialog(pc.pv.jf, "데이터를 한건만 선택하세요","Error",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else {
        	String productno = pc.pv.dtm_dept.getValueAt(index[0], 0).toString();
        	MyDeptVO product = null;
    		//연결 베이스///////////////////////////////////////
    		SqlSessionFactory sqlSessionFactory = null;
    		sqlSessionFactory = MyBatisCommonFactory.getInstance();
    		SqlSession sqlSession = null;
    		//값 가져오기////////////////////////////////////////
    		try {
    			sqlSession = sqlSessionFactory.openSession();
    			product = sqlSession.selectOne("condition", productno);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(pc.pv.jf, "Exception : "+e.toString());
			} finally {
				sqlSession.close();
			}
    		if(testname=="jmi_sel") set("상세조회",dVO,pc.pv,false,false,pc);
    		else if(testname=="jmi_upd") set("수정", dVO, pc.pv, true,false,pc);
        }
	}
	
	/*프로시저
	 * CREATE OR REPLACE PROCEDURE proc_condition(
    p_product_no IN VARCHAR2
    ,p_num OUT VARCHAR2
    ,p_name OUT VARCHAR2
    ,p_danga OUT NUMBER
    ,p_company OUT VARCHAR2
	)
	IS
	BEGIN
	SELECT 제품번호, 제품명, 단가, 제조업체 INTO p_num, p_name,p_danga,p_company
	FROM 제품 
	WHERE 제품번호=p_product_no;
	END;
	 */
	/*
	//새로 입력이거나 수정
	public void updateORnewproduct(ProductCon pc) {
		   //연결 베이스///////////////////////////////////////
		   MYDBConnectionMgr dbMgr = MYDBConnectionMgr.getInstance();
		   Connection con = null; //데이터베이스 연결통로
		   PreparedStatement ipstmt = null;//SIUP불러오는 통
		   
		   MyDeptVO pdVO = new MyDeptVO();
           pdVO.setProductnum(pc.pv.pDia.jtf_productno.getText());
           pdVO.setProductname(pc.pv.pDia.jtf_productname.getText());
           pdVO.setDanga(Integer.parseInt(pc.pv.pDia.jtf_danga.getText()));
           pdVO.setProductcompany(pc.pv.pDia.jtf_productcompany.getText());
           if(dVO==null) { //입력일때
        	   StringBuilder sql_ins = new StringBuilder();
        	   sql_ins.append("INSERT INTO 제품 (제품번호, 제품명, 단가, 제조업체)");
               sql_ins.append(" VALUES(?, ?, ?, ?)         ");
               try {
            	   con   = dbMgr.getConnection();
                   ipstmt = con.prepareStatement(sql_ins.toString());
                   int i = 0;
                   ipstmt.setString(++i, pdVO.getProductnum());
                   ipstmt.setString(++i, pdVO.getProductname());
                   ipstmt.setInt(++i, pdVO.getDanga());
                   ipstmt.setString(++i, pdVO.getProductcompany());
                   int iresult = ipstmt.executeUpdate();
                   if(iresult==1) {
                      JOptionPane.showMessageDialog(pc.pv.jf, "등록하였습니다");
                   }
                   dbMgr.freeConnection(con, ipstmt);
                } catch (Exception e2) {
                   JOptionPane.showMessageDialog(pc.pv.jf, "Exception"+e2.toString());
                }
           }
           else { //수정일때
        	   StringBuilder sql_upd = new StringBuilder();
        	   sql_upd.append("UPDATE 제품");
               sql_upd.append("   SET 단가 = ?"  );
               sql_upd.append(" WHERE 제품번호 = ?");
               try {
            	   con   = dbMgr.getConnection();
            	   ipstmt = con.prepareStatement(sql_upd.toString());
                   int i = 0;
                   ipstmt.setInt(++i, pdVO.getDanga());
                   ipstmt.setString(++i, pdVO.getProductnum());
                   int uresult = ipstmt.executeUpdate();
                   if(uresult==1) {
	                 JOptionPane.showMessageDialog(pc.pv.jf, "수정하였습니다");
	               }
	               dbMgr.freeConnection(con, ipstmt);
               } catch (Exception e2) {
            	   JOptionPane.showMessageDialog(pc.pv.jf, "Exception"+e2.toString());
               }
           }
           refresh(pc);
           pc.pv.pDia.setVisible(false);
	}
	
	
	//삭제
	public void delete(ProductCon pc) {
		int index[] = pc.pv.jtb_dept.getSelectedRows();
		if(index.length==0) {
            JOptionPane.showMessageDialog(pc.pv.jf, "삭제할 데이터를 선택하세요","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
		else {
			//불러올 식 작성///////////////////////////////////////
			String sql = "DELETE FROM 제품 WHERE 제품번호 IN ( ";
			String productno[] = new String[index.length];
			for(int i=0;i<index.length-1;i++) {
				productno[i]=pc.pv.dtm_dept.getValueAt(index[i], 0).toString();
				sql+="? ,";
				
			}
			productno[index.length-1]=pc.pv.dtm_dept.getValueAt(index[index.length-1], 0).toString();
			sql+="? )";
			//연결 베이스///////////////////////////////////////
    		MYDBConnectionMgr dbMgr = MYDBConnectionMgr.getInstance();
    		Connection con = null; //데이터베이스 연결통로
    		PreparedStatement pstmt = null;//SIUP불러오는 통
    		//값 가져오기////////////////////////////////////////
    		try {
				con   = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql);
				for(int i=0;i<index.length;i++) {
					pstmt.setString(i+1, productno[i]);
				}
				pstmt.executeUpdate();
				refresh(pc);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(pc.pv.jf, "Exception : "+e.toString());
			}
		}
	}
	*/
}

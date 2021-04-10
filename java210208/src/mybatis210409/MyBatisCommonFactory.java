package mybatis210409;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//오라클과 마이바티스 연동 클래스 
/*public class MyBatisCommonFactory {
	//private인 이유는 외부에서 커넥션 건들이지 못하게 하기 위해서
	//static인 이유는 싱글톤-공통코드 
	private static SqlSessionFactory sqlSessionFactory = null; 
	//getInstance는 메소드 이름. static 은 변경할 때마다 새로운 설정값이 계속하여 소급 갱신된다. 
	//static을 사용하지 않고 i=3; 주고 i=20;하면 단일 값은 20이 되지만 새롭게 i를 불러오면 3이 된다. 
	//예제 만들어서 저장하기. 
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory ==null) {
		//synchronized는 if문 안쪽에 위치하는 것이 더 안전하다. 
			synchronized(SqlSessionFactory.class) {
				if(sqlSessionFactory == null) {
					try {
						String resource = "mybatis210409/Ma_product.xml";
						Reader reader = Resources.getResourceAsReader(resource);
						//리더가 resource 주소를 보고 해석해서 자바에게 넘겨준 것을 바탕으로 build된다. 
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sqlSessionFactory;
	}


}
*/

public class MyBatisCommonFactory {
	   private static SqlSessionFactory sqlSessionFactory = null;
	   public static SqlSessionFactory getInstance() {
	      if(sqlSessionFactory == null) {
	         synchronized(SqlSessionFactory.class) {
	            if(sqlSessionFactory == null) {
	               try {
	                  String resource = "mybatis210409/Ma_product.xml";
	                  Reader reader = Resources.getResourceAsReader(resource);
	                  sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }
	            }
	         }
	      }
	      return sqlSessionFactory;
	   }
	}


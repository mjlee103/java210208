package di.step1;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;   //ibitis의 잔재 구글쪽으로 넘어오면서 이름이 바뀐 것. 
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BookDao {
	String resource = "mybatis/step1/MapperConfig.xml";
	//다음의 SqlSessionFactory를 통하여 xml 문서의 정보를 읽고 커넥션을 얻어내는데 사용함. 
	SqlSessionFactory sqlMapper =null;
	public List<Map<String,Object>> getBookList(){
		List<Map<String,Object>> bookList = null;
		SqlSession session = null;
		try {
			//insert here
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bookList;
	}
	public static void main(String[] args) { //static이어서 내 자신이지만 인스턴스화 해야 함.
		BookDao bDao = new BookDao();
		bDao.getBookList();
		List<Map<String,Object>> bookList = null;
		bookList = bDao.getBookList();
		System.out.println(bookList);
	}

}

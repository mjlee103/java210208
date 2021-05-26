package ZipCodeSearch.copy;

public class StringTest {

	public static void main(String[] args) {
		String sql = "select";
		sql=sql + "empno, ename";
		sql=sql + "FROM emp";
		sql=sql + "WHERE empno>7000";
		System.out.println(sql);
		String sql2="JAVA";
		sql2.replace('J', 'H');
		System.out.println(sql2); //-> j를 h로 바꿨지만 원본이 바뀌지 않음. 
		sql2 = sql2.replace('J', 'H'); //원본 바꾸는 방법은 sql2를 받아줘야 함. 
		System.out.println(sql2);
	}

}

package question;



public class ParamTest {
	void effectParam(Param p) {
		//p=new Param();
		p.ival=500;
		System.out.println("sub  ival : "+p.ival); //500
	}
	public static void main(String[] args) {
	
		ParamTest tp=new ParamTest();
		Param p =new Param();
		p.ival=100;
		tp.effectParam(p);
		System.out.println("main ival : "+p.ival); //100	
	}

}
/*
 * effectParam에서 인스턴스화를 다시 하지 않는다면 (선생님 비유에 따르면) 풍선이 하나만 생긴 상태이니까 같은 p.ival이라서 
 * 둘 다 500이 찍히는 것으로 이해했습니다!
 * ==Param클래스 하나만 메모리에 로딩되어 있는 상태이니까 원본의 ival이라서 sub.ival 과 main.ival이 둘다 500이 출력된다.
 * 주소번지를 하나만 가지고 있는데 풍선을 파라미터로 넘기기전에는 원본을 넘긴것이다.
 * effectParam()에 넘겼을 때 
 * p=new Param();로 인스턴스화를 하게 되면서 새로운 풍선이 (새로운 주소가) 생성되면서 그 주소에 500이 저장되고
 * 넘겼던 주소번지는 적용되지 않게 된다.
 * 
 */
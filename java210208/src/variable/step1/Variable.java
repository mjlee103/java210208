package variable.step1;

public class Variable {
	//선언부
	
	//메소드 선언
	void methodA(int x) {
		
	}
	double methodB(int x) {//x는 지역변수 밖에서는 사용불가
		return 3.14;
	}
	//메인메소드는 exe 파일로 만들 수 ㅣㅇㅆ음.
	/*
	 * @return 이  void(비어있음) -> 돌려받을 값이 없다. => 에러 발생할 수 있음. 
	 */

	public static void main(String[] args) {
		// system: 나의 컴퓨터 out: 출력장치(모니터, 프린터...<-출력장치), print(): illegal, print(int i):legal
		System.out.print(5); //줄바꿈 안됨, 
		//메소드 선언할 때는 중괄호{} 사용함 
		//메소드를 호출할 때는 ; 사용
		//API, XXX.JAR, 이 들 안에 클래스(소스가 만들어졌으니 구체적임)가 있고 클래스 안에 객체(결정되지 않은 것들 ex: sonata.jave, class sonata{})에 있는 것을 꺼내씀
		//print 메소드의 종류가 많다. 
		//SELECT 이름 FROM 회원 집합 WHERE 아이디 = 'TEST' AND 비번 = '123'
		Variable v = new Variable();
		System.out.print(v.methodB(1)); //system.out.print(v.methodA(1));
		System.out.print(1+" "+1);
		System.out.print(10+10);
		System.out.print(10+"10");
		System.out.print("    ");
		System.out.println();//줄바꿈이 추가된 메소드.
	}

}

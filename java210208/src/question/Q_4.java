package question;

public class Q_4 {
/*
 * 실행 순서는 7-8(x에 5가 저장됨)-9(주번생김)-10(메소드호출됨-파라미터 5복사)-15( 파라미터로 5가 들어옴)
 * -16(후위연산자라서 5가 출력)- 16에서 증감연산자가 적용되어 6이 출력 됨.
 */
	public static void main(String[] args) {
		int x=5;//여기 x와 (1)
		Q_4 p=new Q_4();
		p.doStuff(x);
		System.out.print(" main x = "+x);
	}
	
	void doStuff(int x) {//여기 x는 (2)는 서로 다른 x이다.
		System.out.print(" doStuff x = "+x++);
		System.out.print(" doStuff x = "+x);
	}
}
/*
 * x가 main메소드 안에 선언된 지역변수이기 때문에 doStuff 메소드에서 적용된 연산인 x++은
 * doStuff 메소드 안에서만 유효하고 main 메소드 안의 x에는 영향을 미치지 않는다고 합니다!
 */

package book.ch8;

public class SuperNSubTest {
//자녀 클래스 인스턴스화 시 어떻게 부모 메소드 원형을 알고 있는 것일까?
//자녀 클래스에서 인스턴스화를 했어도 부모 클래스의 생성자가 항상 우선하여 실행됨. 
	public static void main(String[] args) {
		Super sup = new Super();
		Super sup2 = new Sub();
		//Sub sub2 = new Super();
		Sub sub = new Sub();
		sup.methodA();
		//자녀 클래스의 메소드만 호출됨. 이럴 경우 부모 메소드 -> 쉐도우 메소드 => 부모 클래스의 메소드는 호출 되지 않음. 
		sup2.methodA();
		sub.methodA();
		sub.methodB();
		//sup2.methodB();
	}

}

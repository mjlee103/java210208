package ch5.singleton;
/**************************************
 * 싱글톤 패턴의 정의
 * 해당 클래스의 인스턴스가 하나만 만들어지고 
 * 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴이다.
 * #9-17은고전적인 싱글톤 패턴 구현법이다.
 * 
 **************************************/
public class Singleton1_1 {

	private static Singleton1_1 uniqueInstance = null; //유일한 인스턴스 
	public static Singleton1_1 getInstance() { //getInstance는 메소드 이름
		if(uniqueInstance==null) { //uniqueInstance가 널이면 singletont1_1객체 생성해줘. 
			uniqueInstance = new Singleton1_1();
		}
		return uniqueInstance;
	}
}

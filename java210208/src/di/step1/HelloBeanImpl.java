package di.step1;

public class HelloBeanImpl implements HelloBean {
	private String msg333 = null; //스코프 속성을 싱글톤으로 했기 때문에 접근 제한자는 private 이어야 함. 
	String name = new String("SCOTT"); //객체 생성을 내가 관리해야 함. 
	//setter 객체 주입법임.(자바 코드 적용)
	//생성자 객체 주입법(xml 코드 활용) <- 초보자들이 포기하는 부분 
	public void setMsg333(String msg) { //setter메소드 사용하는 것은 객체 생성 및 관리를 스프링에서 대신 해줌. 
		this.msg333 = msg;
	}
	//msg = new String("안녕! 나.....") // 객체 주입 받는 것이 아니기 때문에 이렇게 해서는 안된다. 
	@Override
	public String getGreeting(String msg) {
		return "Spring"+this.msg333;
		//전역변수로 하고 싶다면 return "Spring"+this.msg;
	}
	//Bean이 초기화 된 후 호출되는 메소드
	public void initMethod() {
		System.out.println("initMethod 호출 성공");
	}
	//Bean이 소멸되기 전에 호출되는 메소드
	public void destroyMethod() {
		System.out.println("destroyMethod 호출 성공");
	}
}

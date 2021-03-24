package book.ch8;

public class Sub extends Super {
	//String title = null; 상속을 받은 상태라서 생성자 노 필요
	public Sub() {
		System.out.println("Sub() 호출 성공");
	}
	public Sub(String title) {
		System.out.println("Sub(String) 호출 성공");
		this.title = title;
	}
	@Override
	public void methodA() {
		System.out.println("Sub methodA 호출 성공");
	}
	public void methodA(int x) {
		System.out.println("Sub methodA(int) 호출 성공");
	}
	public void methodB() {
		System.out.println("Sub methodB 호출 성공");
	}
}

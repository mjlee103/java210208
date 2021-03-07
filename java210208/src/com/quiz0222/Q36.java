package com.quiz0222;

class Q36_1{
	void methodC() {
		Q36.methodB();
		Q36 q36 = new Q36();
		q36.methodB();
	}
}

/*
 * non-static 영역에서 static 타입은 접근할 수 있다.
 * 그러나
 * static 영역에서 non-static은 접근 불가
 */

public class Q36{
	//static 블럭이다.
	static {
		System.out.println("static block");
	}
	void methodA() {
		System.out.println("static main");
		methodB();
	}
	//메인메소드도 static이다.
	//main thread라고 한다. <-우선순위가 높다.
	//자바스크립트는 싱글스레드이다.
	public static void main(String[] args) {
		System.out.println("methodA 호출");
	}
	static void methodB() {
		System.out.println("static main");
		methodB();
	}

}

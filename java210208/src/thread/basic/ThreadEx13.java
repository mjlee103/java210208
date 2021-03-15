package thread.basic;
class A extends Thread {
	@Override // 같은 이름의 메소드를 여러개 사용 가능. 상속 관계이거나 구현체 클래스 관계일 때만 고려
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("[[[  A스레드 run   ]]]");
	} // run()
}/////// end of A
//class B extends Thread {
class B implements Runnable{
	@Override
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println("[[[  B스레드 run  ]]]");
	} // run()
}/////// end of B
class ThreadEx13 {
	static long startTime = 0;	
	/* 
	 * 29[main thread(A) 시작] - 30[b 스레드로딩: ready상태 ] - 32대기중(runnable)... [A run call]만났을때 go - 33[B run call]
     * 4->5->6->(-------|||||||||||-------|||||||-------------------)      	 
	 * 14->15->16->(||||||||||---|||||||||||||||)
	 */
	public static void main(String args[]) {
		A th1 = new A();
		B th = new B();
		Thread th2 = new Thread(th);
		th1.start(); //콜백 메소드인 run 호출 - 스레드가 start 된다. 
		th2.start();
		//스레드 활동 시간 계산. 
		startTime = System.currentTimeMillis(); //현재 시간
		/*try {
			th1.join();	// th1의 작업이 끝날 때까지 기다린다.
			th2.join();	// th2의 작업이 끝날 때까지 기다린다.
		 catch(InterruptedException e) {}
		 */
		System.out.print("소요시간:" + (System.currentTimeMillis() - ThreadEx13.startTime)); //실제 소요시간. 
	} // main
	
}
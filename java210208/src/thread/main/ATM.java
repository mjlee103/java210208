package thread.main;

public class ATM extends Thread { //10,000 원에 1,000원씩 찾아보자. 
	private int depositedMoney = 10000;
	public void run() {
		synchronized(this) { //밖에서 못들어오게 바리게이트 친 것. 
			for(int i=0;i<10;i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				withDraw(1000);
			}
		}///////////////end of sychronized
	}////////////////// end of run
	private void withDraw(int howMuch) {
		if(depositedMoney>0) {
			depositedMoney -= howMuch;
			System.out.print(Thread.currentThread().getName()+", ");			
			System.out.printf("잔액: %,d 원%n", depositedMoney);
		}
		else {
			System.out.print(Thread.currentThread().getName()+", ");			
			System.out.println("잔액이 부족합니다.");
		}
	}//////////////// end of withDraw
}

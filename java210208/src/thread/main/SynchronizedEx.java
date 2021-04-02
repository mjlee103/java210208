package thread.main;

public class SynchronizedEx {

	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread ey = new Thread(atm, "ey");
		Thread ht = new Thread(atm, "ht");
		ey.start();//ey를 먼저 출발시킨다고 해서 먼저 들어갈지는 모른다. cuz 가중치가 둘다 5이기 때문임. 
		ht.start();
	}

}

package thread.bakery;

public class Customer extends Thread {
	BakerStack bs = null;
	public Customer(BakerStack bs) {
		this.bs = bs;
	}
	@Override
	public void run() {
		String bread = null;
		bread = bs.pop();
		try {
			sleep((int)(Math.random()*1000));
		} catch (InterruptedException e) {
			System.out.println("누구......");
		}
	}
	private String getBread() {
		// TODO Auto-generated method stub
		return null;
	}

}

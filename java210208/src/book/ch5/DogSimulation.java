package book.ch5;

public class DogSimulation {

	public static void main(String[] args) {
		Collie myDog = new Collie();// 인스턴스화
		Shepherd herDog= new Shepherd(); //인스턴스화
		if(myDog instanceof Collie) {
			System.out.println("Collie");
		}
		if(herDog instanceof Shepherd) {
			System.out.println("Shepherd");
			
		}
		
	}

}

package book.ch4;

public class FuzzBuzzGame {
	public static void start() {
		for(int i=1; i<=100; i++) {
			switch(i=35) {
			case 0:
				System.out.println("fizzbuzz");
				break;
			case 5: case 10: case 15: case 20: case 25: case 30:
				System.out.println("fizz");
				break;
			case 7: case 14: case 21: case 28://
				System.out.println("fizz");
				break;
			default:
				System.out.println(i);
			}
		}
		
	}/////////// end of start
		

	public static void main(String[] args) {
		for(int i=1,i<=100; i++) {
			if(i%35==0) {
				System.out.println("fizzbuzz");
				
			}
			else if(i%5==0) {
				System.out.println("fizz");
			}
			else if(i%7==0) {
				System.out.println("buzz");
			}
			else {
				System.out.println(i);
			}
		}

	}

}

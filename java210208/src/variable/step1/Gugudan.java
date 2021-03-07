package variable.step1;

public class Gugudan {
	public void gugudan1() {
		for(int i=2;i<-9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.println(i+" X "+j+" = "+i*j);
			}
			System.out.println("");
		}
		System.out.println("");
	}
		public void gugudan2() {
			int i=2,j=2;
			while(i<=9) {
				while(j<=9) {
					System.out.println(i+" X "+j+" = "+i*j+" ");
					j++;
				}
				i++;
				j=2;
				System.out.println("");
			}
			System.out.println("");
		}
}
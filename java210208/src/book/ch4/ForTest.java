package book.ch4;

public class ForTest {

	public static void main(String[] args) {
		int i=11;
		int even=0;
		int odd=0;
		for(i=1;i<=10;i++) {
			//System.out.println(i);
			if(i%2==0) {//너 i로 나눈 나머지가 0하고  같은거야?
				even = even + i;
			}else {
				odd = odd + i;
			}
		}
		//나는 for 문 밖에서 한번만 30을 출력하고 싶어요
		System.out.println("1부터 10까지 세면서 짝수의 합을 구한 결과는 "+even);
		System.out.println("1부터 10까지 세면서 홀수의 합을 구한 결과는 "+odd);
		System.out.println("================================");
	}

}

package book.ch7;
/*
 * 배열은 한번 선언하면 원소의 수를 조정 불가함.
 * 끼워넣기가 암됨
 * 배열의 주소번지.length 명사형: 원소의 갯수이다. "hello".length():문자열 길이이다.  */

public class Array1 {
	int empnos[] = new int[14];
	public void printArray(int empnos[]){
		int cnt = 0;
		for(int i =0;i<14;i++) {//i<14 보다는 i<empnos.length를 사용해 주는 것이 안전하다.
			System.out.println(++cnt+"변방: "+empnos[i]);
		}
	}
	public static void main(String[] args) {
		int empnos[] = new int[14];
		// 저 14개 방에는 어떤 값이 들어있을까요? 0이 14개
		Array1 a1 = new Array1();
		Array1 a2 = new Array1();
		a1.printArray(empnos);

	}

}

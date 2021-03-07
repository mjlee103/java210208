package book.ch7;

public class Array5 {
	void methodB(boolean isOk[]) {
		//System.out.println(isOk[3]); 	//NullPointerException
		System.out.println(isOk.length);//NullPointerException
	}
	/*
	 * 11-12(선언만-초기화 안됨-방크기가 결정되지 않음.isOk.length:NullPointerException)
	 */
	public static void main(String[] args) {
		boolean isOk[] = null; //선언만 하였다. 크기가 결정되지 않았다.
		Array5 a5 = new Array5();
		a5.methodB(isOk);
	}

}


/*변수는 한번에 하나 값만 담을 수 잇다. 여러개 담으면 장애 일으킴
* 배열은 한번에 여러개 담을 수 있음. 그러나 다른 타입은 담을 수가 없다.[문제제기] <- 객체 배열, ArrayLIst는 가능하다.[문제해결능력가진자] 
* & 또 끼워넣기가 불가하다, 크기를 조절할 수 없다. <- ArrayList를 사용하면 문제가 해결 됨. 
* 
*
*
*
*
* 자료구조(List계열, Map계열, Set 계열) <- 크기가 늘었다 줄었다. 가능 = 끼워넣기 가능 EX 회원탈퇴, 신입사원 등록 등이 가능
* FIFO
* LIFO
* LILO...
*/






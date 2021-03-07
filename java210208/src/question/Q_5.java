package question;
/*
 *  ++i 는 i = i + 1; 과 같다.
 *  --i 는 i = i - 1; 과 같다.
 *  i++는 후위 연산자이므로 먼저 비교 하고 나중에 1을 증가 시킴.
 *  ++i는 전위 연사자이다.
 */
public class Q_5 {

	public static void main(String[] args) {
		int i=1;
		int j=2;
		if((++i>j--)&(++i>j)) {
			System.out.println("ok");
		}else {			
			System.out.println(i+", "+j);
		}
		i = 1;
		j = 2;
		if((++i>j--)&&(++i>j)) {
			System.out.println("ok");
		}else {
			System.out.println(i+", "+j);
		}
	}

}

package book.ch4;
/*제어문의 역할은 업무 순서에 대한 흐름을 바꾼다.
 * 순서에 대한 정보를 바탕으로 의사를 결정할 수 있는 것은 팀장, 차장, 부장 임
 * 선택(비지니스로직계층 or Model계층)에 따라 
 * break 는 흐름을 제어하기 위해 사용함 . <> continue
 * for 문과 while 문에서의 break는 무한 루프를 방지하기 위해 사용되며 메소드를 탈출하게 된다. 
 * if는 break 대신에 return을 써서 메소드를 탈출한다. 
 * switch 문에서의 break는 switch 문을 탈출하는데 사용된다. 
 */
public class SwitchTest {

	public static void main(String[] args) {  //trotocol을 써서 경우의 수를 나눔 
		int protocol = 100; //로그인
			protocol = 200; //입장하기
			protocol = 300; //다자간 대화
			protocol = 301; //귓속말 1:1채팅
			String id = "tomato";
			String input = "오늘 스터디 할까?";
			String msg = protocol+"#"+id+"#"+input;
		switch(protocol) {//원시형 타입+String 타입
		case 0: //실행문
			System.out.println("0입니다.");
			break;
		case 301: //실행문
			System.out.println("301입니다.");
			break;
		case 100: //실행문
			System.out.println("100입니다.");
			break;
		default:
			System.out.println("defaul 입니다.");
		}//////////////end of switch
		System.out.println("여기");
		System.out.println();
		
	}////

}

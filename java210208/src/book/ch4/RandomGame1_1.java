package book.ch4;

import java.util.Random;
import java.util.Scanner;

public class RandomGame1_1 {

	public static void main(String[] args) {
		//난수 발생을 지원하는 클래스 추가하기 – 인스턴스화 하기
		Random r = new Random();
		//그 클래스가 제공하는 메소드를 호출하여 채번하기
		int dap = r.nextInt(10); //0.0~10.0
		//사죵자로부터 입력한 값 받아오기
		Scanner sc = new Scanner(System.in);
		//사용자가 입력한 값 담기 - 선언하기, 초기화
		//질문 : 콘솔에서 입력받은 값은 숫자야? 문자야?
		
		System.out.println("0부처 9중에서 골라봐라!!");
		int count = 0;
		String user = null;
		//기회를 3번까지 준다 – 1, 2, 3번, 반복법
		//***************nextLine 정보찾아보기***********************
		for(;(user=sc.nextLine())!=null;){
		   //insert here – 실행문
		   //판별식
		   if(count<3){
			   //1번, 2번, 3번
			   if(Integer.parseInt(user)==dap) {
				   System.out.println("축하합니다!정답입니다.");
				   break;
			   }
			   else if(Integer.parseInt(user)>dap){
				   count++;
				   System.out.println("낮춰라");
			   }
			   else if(Integer.parseInt(user)<dap){
				   count++;
				   System.out.println("높여라");				
			   }
		   }
		   else {
			   System.out.println("바보야!!!!!!!!");
			   break;
		   }
		}
	}

}

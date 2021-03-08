package com.design;
 
public class BaseBallGameLogic { //아무것도 상속받지 않고 순수하게 업무만 처리하는 클래스이다. 
	//컴퓨터가 난수발생으로 얻어낸 값 저장 #9
	//컴퓨터가 진행하기 때문에 채번하는 메소드가 필요함.  #9
	//메소드 중심 코딩을 전개하기 <- 재사용성 첫단추 #9
	//새게임을 눌렀을 때 #9
	//정답을 눌렀을 때 #9 <- 답을 아는 것 
	int[] com = new int [3]; //0 0 0, 컴퓨터가 채번하기 때문에 변수 com, 전변
	int[] my = new int[3]; //my:**사용자가 입력한 값**이어서  로컬에서 나옴.  0 0 0, 전변
	public void nanSu(){ //난수를 활용하여 중복되는 숫자를 제외하고 임의의 3자리 숫자를 도출 함. 상속이나 인터페이스로 연결되지 않는게 오류 가능성 낮긴 함. 
		com[0] = (int)(Math.random()*10);
		do{
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do{
			com[2] = (int)(Math.random()*10);
		}while((com[0]==com[2])||(com[1]==com[2]));
		System.out.println(com[0]+""+com[1]+""+com[2]);
	}	
	//전광판에 출력될 메시지를 작성하는 메소드 선언 
	/*************************************************
	 * 
	 * @param input: jp_center속지의 남쪽에 JTextField 붙여놓음: "256" <-숫자를 적어도 문자로 인식함. 
	 * @return 1스트라이크 0볼 / 2스트라이크 1볼 (2자리는 숫자도 같고 위치도 같을 때 ), 1볼은 숫자는 있지만 위치가 다름 
	 * 1회: 256을 쳤다면 1스타리이크 0볼을 나타내야함
	 * 2회: 356 쳤을때 1스트라이크 1볼을 타나내야함.
	 * 전역변수는 회차를 뜻하는 cnt를 사용  (전변에서 static 고려대상이긴 하지만 갱신되어야 하기때문에 바뀌어야 함)
	 * 지역변수는 strike, ball를 사용. (지변에서 static은 고려 대상 아님)
	 **************************************************/
	public String call(String input){ //()사용자가 입력한 값 
		//스트라이크를 카운트할 변수
		int strike = 0;
		//볼을 카운트할 변수
		int ball = 0;		
		int temp = 0;
		//반드시 세자리 숫자 이어야 한다.
		if(input.length()!=3){
			return "세자리 숫자만 입력하세요!!!";
		}
		temp = Integer.parseInt(input);
		my[0] = temp/100;//백자리를 받는다.
		my[1] = (temp%100)/10;//십자리를 받는다.
		my[2] = temp%10;//일의 자리를 받는다. 
		for(int i=0;i<com.length;i++){
			for(int j=0;j<my.length;j++){
				//같은 숫자가 존재하는 경우(볼확보)
				//컴퓨터가 채번한 숫자가 있는지 비교
				if(com[i] == my[j]){
					//자리수까지도 일치하는 경우(스트라이크확보)
					//그 숫자가 존재하는 배열의 인덱스값을 비교
					if(i==j){
						strike++;
					}else{
						ball++;
					}
				}//  end of if          ////////////////
			}//////  end of inner for   ////////////////
		}//////////  end of outter for  ////////////////
		if(strike == 3) return "정답입니다.";
		return strike+"스트라이크" +ball+"볼";
	}/////////////  end of call ////////////////////////	

}

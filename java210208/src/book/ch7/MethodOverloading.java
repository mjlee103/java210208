package book.ch7;

import com.vo.DeptVO;
//전제 조건은 반드시 메소드 이름이 같을 때만 고려함.
public class MethodOverloading {
	void go() {
		
	}
	//public void go() {} 접근제한자는 영향없다.
	public void go(int[] a) {} //메소드 오버로딩임.
	//public void go(int[] b) {} //메소드 오버로딩이 아님.
	public void getDeptList(DeptVO dvo) { //메소드 오버로딩을 만족함.
		
	}
	/* 리턴타입이 있고 엾고는 영향이 없다.
	int go() {
		return 0;
	}
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

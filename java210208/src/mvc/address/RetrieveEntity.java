package mvc.address;

import java.util.List;

public class RetrieveEntity {
//오버로딩에 리턴 타입은 영향이 없다.
	public AddressVO select(AddressVO vo) {//무조건 1개로우만 가능함.
		System.out.println("RetrieveEntity select(vo) 호출 성공");
		return null;
	}
	public AddressVO[] select() {//n개 로우 가능함.
		System.out.println("RetrieveEntity select() 호출 성공");
		return null;
	}
	/*public AddressVO select(AddressVO vo)얘와 같아서 에러가 남
	public List<AddressVO> select(AddressVO vo) {//n개 로우 가능함.
		// TODO Auto-generated method stub
		return null;
	}
	*/
	public List<AddressVO> selectList(AddressVO vo) {//n개 로우 가능함.
		System.out.println("RetrieveEntity selectList() 호출 성공");
		return null;
	}
}

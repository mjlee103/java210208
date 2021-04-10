package mybatis.step1;

import java.util.HashMap;
import java.util.Map;

public class MessengerMap {
	private Map<String, Object> map = null;

	public MessengerMap() {
		columnInit();
	}

	private void columnInit() {
		map = new HashMap<String, Object>();
		map.put("id", "");
		map.put("password", "");
		map.put("nickname", "");
		/*
		 * 모든 테이블의 컬럼명을 미리 put 해놓기
		 * 
		 * 
		 */
	}

	public Map<String, Object> getMap() {
		return map;
	}

//	public void setMap(Map<String, Object> map) {
//		this.map = map;
//	}
}

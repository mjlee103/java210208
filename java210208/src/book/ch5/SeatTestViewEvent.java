package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class SeatTestViewEvent implements ActionListener, ItemListener { //인터페이스는 여러개 implements 가능
	SeatTestView stv = null;
	public SeatTestViewEvent(SeatTestView seatTestView) {
		this.stv = seatTestView; //변수 이름을 통일하는 것이 권장사항임. 해당 방법은 옳지 않음. 
	}

	@Override
	public void itemStateChanged(ItemEvent e) { 
		//System.out.println("itemStateChanged 호출 성공"); //감지되는지 단위테스트 
		Object c = e.getSource().getClass();
		int selseat = 0;
		//상태가 변화한 컴포넌트가 JCheckBox이니?
		if(c == JCheckBox.class) {
			//상태변화가 좌석선택이면
			if(e.getStateChange() == e.SELECTED) {
				System.out.println("좌석 선택일 때");
				stv.getJlb_selseatnum().setText(String.valueOf(++stv.inwon));
				//선택한 좌석 번호 표시
				/*for(JCheckBox box2:stv.jcb_seat) {
					if(box2.isSelected()) {
						stv.getJlb_selseat()[selseat].setText(box2.getActionCommand());
						selseat++;
					}
				}
				*/
				//좌석 선택 수가 최대 선택 가능 수와 같다면
				if(stv.inwon == stv.max_selection) {
					//선택안 된 좌석만 얼리기 
					for(JCheckBox box:stv.jcb_seat) {
						if(!box.isSelected()){
							box.setEnabled(false);
						}
					}
				}
			}
			//상태 변화가 좌석 선택 해제이면 
			else if(e.getStateChange() == e.DESELECTED) {
				//라벨에 선택한 좌석수 보여주기
				stv.getJlb_selseatnum().setText(String.valueOf(--stv.inwon));//- count가 일어남. 
				//선택 해제한 좌석번호 가져오기
				String deseljcb = ((JCheckBox)e.getSource()).getText();
				//선택 해제한 좌석번호 표시 지우기
				for(int i=0;i<stv.getJlb_selseat().length;i++) {
					if(deseljcb.equals(stv.getJlb_selseat()[i].getText())) {
						stv.getJlb_selseat()[i].setText("");
					}
				}
				//좌석 선택수가 최대 선택가능 수보다 작아지면 
				if(stv.inwon < stv.max_selection) {
					//모든 좌석 얼리기 풀기
					for(JCheckBox seatall:stv.jcb_seat) {
						seatall.setEnabled(true);
					}
				}
			}
		}
		///////////////상태 변화한 컴포넌트가 JComboBox이면
		else if(c == JComboBox.class) {
			//예매할 최대 좌석 수 설정
			stv.max_selection=stv.jcbb_max.getSelectedIndex()+1;
			//모든 좌석 선택 해제
			for(JCheckBox seatall:stv.jcb_seat) {
				seatall.setSelected(false);
			}
		}
	}/////////////////// end of ItemStateChanged

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

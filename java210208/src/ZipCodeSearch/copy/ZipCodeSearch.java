package ZipCodeSearch.copy;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ZipCodeSearch extends JFrame implements MouseListener
, ItemListener
, FocusListener
, ActionListener {
	//선언부
	String zdo     = null;
	String sigu    = null;
	String dong    = null;

	JPanel jp_north = new JPanel();

	JComboBox jcb_zdo    = null;
	JComboBox jcb_sigu    = null;
	JComboBox jcb_dong    = null;

	JTextField jtf_search = new JTextField(20);
	JButton jbtn_search = new JButton("조회");

	String sigus[] = null;
	String dongs[] = null;
	String zdos[] = null;
	String totals[] = {"전체"};
	Vector<String> vzdos = new Vector<>();
	
	String cols[] = {"주소", "우편번호"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data,cols);
	
	
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	JTableHeader jth = jtb_zipcode.getTableHeader();
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode
								,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
								,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	//DB연동
	DBConnectionMgr1     dbMgr   = DBConnectionMgr1.getInstance();
	Connection          con    = null;
	PreparedStatement   pstmt    = null;
	ResultSet          	rs       = null;
	
	//생성자
	public ZipCodeSearch() {
		zdos = getZDOList();
		jcb_zdo = new JComboBox(zdos);
		jcb_sigu = new JComboBox(totals);
		jcb_dong = new JComboBox(totals);
	}
	
	//화면처리부
	public void initDisplay() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		jth.setBackground(Color.blue);
		jth.setFont(new Font("맑은고딕",Font.BOLD,20));
		jth.setForeground(Color.white);
		
		jtb_zipcode.requestFocus();
		jtb_zipcode.addMouseListener(this);
		jbtn_search.addActionListener(this);
		jtf_search.addFocusListener(this);
		jtf_search.addActionListener(this);
		
		jcb_zdo.addItemListener(this);
		jcb_sigu.addItemListener(this);
		jcb_dong.addItemListener(this);

		jp_north.setLayout(new FlowLayout());
		  for(String s:vzdos) {
		         System.out.println("s===>"+s);
		      }
		  
		jp_north.setBackground(Color.red);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jcb_dong);
		jp_north.add(jtf_search);
		jp_north.add(jbtn_search);


		jtb_zipcode.setGridColor(Color.blue);
		//테이블 컬럼별 넓이 지정
		jtb_zipcode.getColumnModel().getColumn(0).setPreferredWidth(300);
		jtb_zipcode.getColumnModel().getColumn(1).setPreferredWidth(100);

		this.add("North",jp_north);
		this.add("Center",jsp_zipcode);
		this.setTitle("우편번호 검색");
		this.setSize(600, 700);
		this.setVisible(true);
	}


	public String[] getZDOList() {
		String zdos[] = null;	
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT '전체' zdo FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT zdo                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(zdo) zdo ");
		sb.append("          FROM zipcode_t         ");
		sb.append("        ORDER BY zdo asc         ");
		sb.append("       )                         ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			Vector<String> v = new Vector<>();

			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {

		} finally {

		}
		return zdos;
	}


	public String[] getSiguList(String pzdo) {
		String sigus[] = null;
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT '전체' sigu FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT sigu                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(sigu) sigu ");
		sb.append("          FROM zipcode_t         ");
		sb.append("         WHERE zdo=?         ");
		sb.append("        ORDER BY sigu asc         ");
		sb.append("       )                         ");

		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,pzdo);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
			sigus = new String[v.size()];
			v.copyInto(sigus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sigus;
	}

	public String[] getDongList(String psigu) {
		String dongs[] = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT '전체' dong FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT dong                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(dong) dong ");
		sb.append("          FROM zipcode_t         ");
		sb.append("         WHERE sigu=?         ");
		sb.append("        ORDER BY dong asc         ");
		sb.append("       )                         ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,psigu);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String dong = rs.getString("dong");
				v.add(dong);
			}
			dongs = new String[v.size()];
			v.copyInto(dongs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dongs;
	}

	public void refreshData(String zdo, String sigu, String myDong) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT address, zipcode");
		sql.append("  FROM zipcode_t");
		sql.append(" WHERE 1=1");
		
		if(zdo!=null && zdo.length()>0) {
			sql.append(" AND zdo=?");
		}
		
		//이거 빼먹었었음 
		if(sigu!=null && sigu.length()>0) { 
			sql.append("AND sigu=?");		
		}
		if(myDong!=null && myDong.length()>0) {
			sql.append(" AND dong LIKE '%'||?||'%'");
		}
		int i=1;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if(zdo!=null && zdo.length()>0) {
				pstmt.setString(i++,zdo);
			}
			//이거 빼먹었었음 
			if(sigu!=null && sigu.length()>0) {
				pstmt.setString(i++,sigu);
			}
			if(myDong!=null && myDong.length()>0) {
				pstmt.setString(i++,myDong);
			}         
			rs = pstmt.executeQuery();
			Vector<ZipCodeVO> v = new Vector<>();
			ZipCodeVO[] zVOS = null;
			ZipCodeVO zVO = null;
			while(rs.next()) {
				zVO = new ZipCodeVO();
				zVO.setAddress(rs.getString("address"));
				zVO.setZipcode(rs.getInt("zipcode"));
				v.add(zVO);
			}
			zVOS = new ZipCodeVO[v.size()];
			v.copyInto(zVOS);
			if(v.size()>0) {
				//조회 버튼 연속 클릭시 기존의 조회 결과 클리어 
				while(dtm_zipcode.getRowCount()>0) {
					dtm_zipcode.removeRow(0);
				}
				for(int x=0;x<v.size();x++) {
					Vector<Object>       oneRow    = new Vector<>();
					oneRow.add(0,zVOS[x].getAddress());
					oneRow.add(1,zVOS[x].getZipcode());
					
					dtm_zipcode.addRow(oneRow);
				}
			}
		} catch (SQLException se) {
			System.out.println("[[ query ]]"+sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		
	}/////////////////end of refreshData

	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ZipCodeSearch zcs = new ZipCodeSearch();
		zcs.initDisplay();
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == jtf_search) {
			jtf_search.setText("");
		}
	}
	@Override
	public void focusLost(FocusEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_search || obj == jtf_search) {
			String myDong = jtf_search.getText();
			refreshData(zdo, sigu, myDong);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		
		if(obj == jcb_zdo) {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				zdo = zdos[jcb_zdo.getSelectedIndex()];
				sigus = getSiguList(zdo);
				jcb_sigu.removeAllItems();
				for(int i=0;i<sigus.length;i++) {
					jcb_sigu.addItem(sigus[i]);
				}
			}
		}
		if(obj == jcb_sigu) {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				sigu = sigus[jcb_sigu.getSelectedIndex()];
				dongs = getDongList(sigu);
				jcb_dong.removeAllItems();
				for(int i=0;i<dongs.length;i++) {
					jcb_dong.addItem(dongs[i]);
				}
			}
		}
		if(obj == jcb_dong) {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				dong = dongs[jcb_dong.getSelectedIndex()];
			}
		}


	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {

	}
	@Override
	public void mousePressed(MouseEvent e) {

	}
	@Override
	public void mouseReleased(MouseEvent e) {


	}


}
package UI.hanbit;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MovieManager extends JFrame{
	//Logger logger = LogManager.getLogger(MovieManager.class);
	JFrame jf = new JFrame();
	JPanel jp_center = new JPanel();
	JPanel jp_west = new JPanel();
	JPanel jp_east = new JPanel();
	
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		jp_center.add("West", jp_west);
		jp_center.add("East", jp_east);
	}

	public static void main(String[] args) {
		MovieManager mm = new MovieManager();
		mm.initDisplay();

	}

}

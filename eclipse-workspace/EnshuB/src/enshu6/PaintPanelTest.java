package enshu6;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.RepaintManager; // この行を追加

public class PaintPanelTest {
	public PaintPanelTest() {
 JFrame jf = new JFrame("Paint");
 RepaintManager.currentManager(jf).setDoubleBufferingEnabled(false); // この行を追加
 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 jf.setLayout(new BorderLayout());
 jf.add(new PaintPanel(), BorderLayout.CENTER);
 jf.pack();
 jf.setVisible(true);
 }

	public static void main(String[] args) {
		new PaintPanelTest();
	}
}
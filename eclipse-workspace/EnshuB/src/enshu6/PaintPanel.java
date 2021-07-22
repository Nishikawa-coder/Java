//B9TB2174
//西川凜
package enshu6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private Point mp = new Point(0, 0);
	private Point ml = new Point(0, 0);
	private Color pen = Color.black;

	public PaintPanel() {
		this.setPreferredSize(new Dimension(400, 400));
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				mp = e.getPoint();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e2) {
				ml = e2.getPoint();
				repaint();
			}

			public void mouseMoved(MouseEvent e2) {
			}
		});
	}

	public void paint(Graphics g) {
		
		// 表示エリアのクリア
		Rectangle r = this.getBounds();
		//g.setColor(Color.white);
		//g.fillRect(r.x, r.y, r.width, r.height);

		// 長方形の描画
		g.setColor(Color.black);
		g.fillRect(0, 0, r.width / 8, r.width / 8);
		if (mp.x < r.width / 8 && mp.y < r.width / 8) {
			System.out.println(Color.black);
			pen = Color.black;
		}
		g.setColor(Color.blue);
		g.fillRect(r.width / 8, 0, r.width / 8, r.width / 8);
		if (mp.x > r.width / 8 && mp.x < r.width * 2 / 8 && mp.y < r.width / 8) {
			System.out.println(Color.blue);
			pen = Color.blue;
		}
		g.setColor(Color.red);
		g.fillRect(r.width / 4, 0, r.width / 8, r.width / 8);
		if (mp.x > r.width * 2 / 8 && mp.x < r.width * 3 / 8 && mp.y < r.width / 8) {
			System.out.println(Color.red);
			pen = Color.red;
		}
		g.setColor(Color.magenta);
		g.fillRect(r.width * 3 / 8, 0, r.width / 8, r.width / 8);
		if (mp.x > r.width * 3 / 8 && mp.x < r.width * 4 / 8 && mp.y < r.width / 8) {
			System.out.println(Color.magenta);
			pen = Color.magenta;
		}
		g.setColor(Color.green);
		g.fillRect(r.width / 2, 0, r.width / 8, r.width / 8);
		if (mp.x > r.width * 4 / 8 && mp.x < r.width * 5 / 8 && mp.y < r.width / 8) {
			System.out.println(Color.green);
			pen = Color.green;
		}
		g.setColor(Color.cyan);
		g.fillRect(r.width * 5 / 8, 0, r.width / 8, r.width / 8);
		if (mp.x > r.width * 5 / 8 && mp.x < r.width * 6 / 8 && mp.y < r.width / 8) {
			System.out.println(Color.cyan);
			pen = Color.cyan;
		}
		g.setColor(Color.yellow);
		g.fillRect(r.width * 3 / 4, 0, r.width / 8, r.width / 8);
		if (mp.x > r.width * 6 / 8 && mp.x < r.width * 7 / 8 && mp.y < r.width / 8) {
			System.out.println(Color.yellow);
			pen = Color.yellow;
		}
		g.setColor(Color.white);
		g.fillRect(r.width * 7 / 8, 0, r.width / 8, r.width / 8);
		if (mp.x > r.width * 7 / 8 && mp.x < r.width && mp.y < r.width / 8) {
			System.out.println(Color.white);
			pen = Color.white;
		}

		g.setColor(pen);
		g.fillRect(ml.x-3/2, ml.y-3/2, 3, 3);
		
	}

}

package part2;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import draw.UltraDraw;

public class SierpinskiTriangle implements MouseListener, MouseMotionListener {
	public static int recursion = 0;
	private Color background = new Color(34, 129, 34);
	Point2D.Double top, right, left;

	public SierpinskiTriangle() {
		UltraDraw.addMouseListener(this);
		UltraDraw.addMouseMotionListener(this);
		
		
		UltraDraw.setXscale(0, 150);
		UltraDraw.setYscale(75, 150);

		top = new Point2D.Double(75, 150);
		right = new Point2D.Double(150, 75);
		left = new Point2D.Double(0, 75);

		UltraDraw.clear(UltraDraw.GRAY);
	}

	public void sierpinski(Point2D.Double top, Point2D.Double right, Point2D.Double left, int n) {
		if (n <= 0)
			return;

		Point2D.Double lr = new Point2D.Double((right.x + left.x) / 2.0, right.y);
		Point2D.Double tr = new Point2D.Double((top.x + right.x) / 2.0, (top.y + right.y) / 2.0);
		Point2D.Double tl = new Point2D.Double((top.x + left.x) / 2.0, (top.y + left.y) / 2.0);
		drawTriangle(tl, tr, lr,  Color.BLACK );
		sierpinski(top, tr, tl, n - 1);
		sierpinski(tr, right, lr, n - 1);
		sierpinski(tl, lr, left, n - 1);

	}

	public void drawTriangle(Point2D.Double a, Point2D.Double b, Point2D.Double c, Color color) {
		double[] x = { a.x, b.x, c.x };
		double[] y = { a.y, b.y, c.y };
		UltraDraw.setPenColor(color);
		UltraDraw.filledPolygon(x, y);
	}

	public void draw(int n) {
		drawTriangle(top, right, left,  Color.WHITE);
		sierpinski(this.top, this.right, this.left, n-1);
	}

	public static void main(String[] args) {
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.draw(4);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e);
		recursion++;
		
		}
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.draw(recursion);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
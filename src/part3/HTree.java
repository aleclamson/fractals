package part3;
import java.awt.geom.Point2D;
import draw.StdDraw;


public class HTree {
	public Point2D.Double center;
	public H start;
	
	public static void main(String[] args) {
		HTree htree = new HTree();
		htree.start.draw();
		htree.draw(3, htree.start);
	}

	
	public HTree() {
		center = new Point2D.Double(75, 75);
		start = new H(center, 50);
		StdDraw.setXscale(0, 150);
		StdDraw.setYscale(0, 150);
		StdDraw.clear(StdDraw.GREEN);
	}
	
	public void draw(int n, H focus) {
		if (n == 0) return;
		H[] res = drawH(focus);
		for(H h : res) {
			draw(n - 1, h);
		}
	}
	
	public H[] drawH(H init) {
		init.draw();
		H topRight = new H(init.getTopRight(), init.getSize() / 2);
		H bottomLeft = new H(init.getBottomLeft(), init.getSize() / 2);
		H topLeft = new H(init.getTopLeft(), init.getSize() / 2);
		H bottomRight = new H(init.getBottomRight(), init.getSize() / 2);
		H[] Val = {bottomLeft, topLeft, bottomRight, topRight};
		return Val;
	}
	
}
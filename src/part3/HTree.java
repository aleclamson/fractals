package part3;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import draw.UltraDraw;


public class HTree implements KeyListener {
	public static int recursion = 0;
	public Point2D.Double center;
	public H start;
	
	public static void main(String[] args) {
		HTree htree = new HTree();
		htree.start.draw();
		htree.draw(3, htree.start);
	}

	
	public HTree() {
		UltraDraw.addKeyListener(this);
		
		center = new Point2D.Double(75, 75);
		start = new H(center, 50);
		UltraDraw.setXscale(0, 150);
		UltraDraw.setYscale(0, 150);
		UltraDraw.clear(UltraDraw.GREEN);
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


	@Override
	public void keyPressed(KeyEvent arg0) {
		UltraDraw.clear(UltraDraw.WHITE);
		System.out.println(getKeyChar());
		String str = sting.valueof(getKeyChar());
		int n = intager.parseint(str);
		drawH(n);
	
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
			
		}
		
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
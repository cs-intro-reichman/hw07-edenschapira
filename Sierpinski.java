/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double x1 = 0.2, y1 = 0.24; // Bottom left
        double x2 = 0.8, y2 = y1; // Bottom right
        double x3 = 0.5, y3 = 0.76; // Top middle

		// draw the large triangle
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);

		// call for the recursive fanction
		sierpinski(n, x1, x2, x3, y1, y2, y3);		
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n <= 0){
			return;
		}

		// calculate midpoints
		double m12x = (x1 + x2) / 2.0;
        double m12y = (y1 + y2) / 2.0;
        
        double m23x = (x2 + x3) / 2.0;
        double m23y = (y2 + y3) / 2.0;
        
        double m31x = (x3 + x1) / 2.0;
        double m31y = (y3 + y1) / 2.0;

		// set color to black
		StdDraw.setPenColor(StdDraw.BLACK);

		// Bottom left triangle 
        StdDraw.line(x1, y1, m12x, m12y);
        StdDraw.line(m12x, m12y, m31x, m31y);
        StdDraw.line(m31x, m31y, x1, y1);

        // Bottom right triangle 
        StdDraw.line(m12x, m12y, x2, y2);
        StdDraw.line(x2, y2, m23x, m23y);
        StdDraw.line(m23x, m23y, m12x, m12y);

        // Top triangle 
        StdDraw.line(m31x, m31y, m23x, m23y);
        StdDraw.line(m23x, m23y, x3, y3);
        StdDraw.line(x3, y3, m31x, m31y);

		// recursive call
		// Bottom left
		sierpinski(n - 1, x1, m12x, m31x, y1, m12y, m31y);
		// Bottom right
		sierpinski(n - 1, m12x, x2, m23x, m12y, y2, m23y);
		// Top middle
		sierpinski(n - 1, m31x, m23x, x3, m31y, m23y, y3);
	}
}

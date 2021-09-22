import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RendererMain extends JPanel {

    private final BufferedImage canvas;
    public static final int width = 256;
    public static final int height = 192;

    public RendererMain(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.drawImage(canvas, null, null);
    }

    public void setPixel(int x, int y, Color c) {
        int color = c.getRGB();
        canvas.setRGB(x, y, color);
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Direct draw demo");
        RendererMain panel = new RendererMain(width, height);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scene scene =
        	new Scene(
        	new ImagePlane(new Vector3d(1, 0.75, 0), new Vector3d(-1, 0.75, 0), new Vector3d(1, -0.75, 0), new Vector3d(-1, -0.75, 0)),
        	new Camera(new Vector3d(0, 0, -1)),
        	new ArrayList<Sphere>(Arrays.asList(new Sphere(new Vector3d(0, 0, 1.2), 0.8, new Material(new MyColor(0.2, 0.1, 0.1), new MyColor(0.4, 0.1, 0.1), new MyColor(0.7, 0.7, 0.7), 100, new MyColor(0.1, 0.1, 0.1))),
        	new Sphere(new Vector3d(1.7, 0.3, 2), 0.5, new Material(new MyColor(0, 0.73, 0.73), new MyColor(0.4, 0.1, 0.1), new MyColor(0.7, 0.7, 0.7), 50, new MyColor(0.2, 0.1, 0.16))),
        	new Sphere(new Vector3d(-1.6, 0.6, 2), 0.8, new Material(new MyColor(1, 0.61, 0), new MyColor(0.6, 0.4, 0), new MyColor(0.4, 0.6, 0.6), 80, new MyColor(0.1, 0.2, 0.1))))),
        	new ArrayList<Light>(Arrays.asList(new Light(new Vector3d(5, 2.5, 0.5), new MyColor(0.8, 0.8, 0.8), new MyColor(0.8, 0.8, 0.8)),
        	new Light(new Vector3d(-5, 2.5, 0.5), new MyColor(0.7, 0.7, 0.7), new MyColor(0.8, 0.8, 0.8)))),
        	new MyColor(0.8, 0.8, 0.8)
        	);

        for (int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++){
                Ray ray = new Ray(x, y);
                panel.setPixel(x, y, new RayTracer(ray, scene, 3).getColor().realColor());
            }
        }
    }
}

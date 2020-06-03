package JWard;

import javax.swing.JFrame;
import JWard.Canvas;
import javax.swing.SwingUtilities;


public class App {
    public static JFrame createGui(String title,
                                   int width,
                                   int height,
                                   Canvas canvas) {
        SwingUtilities.isEventDispatchThread();
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.add(canvas);
        //frame.pack();
        return frame;
    }
    
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame gui = createGui("swing paint demo",
                                       250,
                                       250,
                                       canvas);
                gui.setVisible(true);
            }
        });
    }
}

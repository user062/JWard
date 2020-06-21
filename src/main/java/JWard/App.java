package JWard;

import javax.swing.JFrame;
import JWard.Canvas;
import javax.swing.SwingUtilities;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Component;


public class App {
    public static JFrame createGui(String title,
                                   int width,
                                   int height,
                                   Canvas canvas,
                                   JSpinner strokeSpinner) {
        SwingUtilities.isEventDispatchThread();
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        strokeSpinner.setMaximumSize(new Dimension(25, 20));
        frame.add(strokeSpinner);
        frame.add(canvas);
        return frame;
    }
    
    public static void main(String[] args) {
        SpinnerNumberModel model         = new SpinnerNumberModel(1, 1, 30, 1);
        JSpinner           strokeSpinner = new JSpinner(model);
        Canvas             canvas        = new Canvas(strokeSpinner);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame gui = createGui("swing paint demo",
                                       25,
                                       25,
                                       canvas,
                                       strokeSpinner);
                gui.setVisible(true);
            }
        });
    }
}

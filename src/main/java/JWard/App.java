package JWard;

import javax.swing.JFrame;
import JWard.Canvas;
import javax.swing.SwingUtilities;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import JWard.ColorChooser;
import JWard.StrokeSpinner;

public class App {
    public static JFrame createGui(String title,
                                   Canvas canvas,
                                   JButton strokeSpinner,
                                   JButton colorChooser) {
        SwingUtilities.isEventDispatchThread();
        JFrame frame = new JFrame(title);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),
                                                       BoxLayout.X_AXIS));

        JToolBar toolBar = new JToolBar("Darwing Tools", JToolBar.VERTICAL);
        toolBar.setMinimumSize(new Dimension(490, 145));
        toolBar.add(strokeSpinner);
        toolBar.add(colorChooser);
        frame.add(toolBar);

        frame.add(canvas);
        return frame;
    }

    public static void main(String[] args) {
        ColorChooser  simpleColorChooser = new ColorChooser ();
        StrokeSpinner strokeSpinner      = new StrokeSpinner(1, 30);
        Canvas        canvas             = new Canvas(strokeSpinner.getStrokeSpinner(),
                                                      simpleColorChooser.getColorChooser());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {JFrame gui = createGui("swing paint demo",
                                                      canvas,
                                                      strokeSpinner.assignJButton("Brush Size"),
                                                      simpleColorChooser.assignJButton("Color Chooser"));
                gui.setVisible(true);
            }
        });
    }
}

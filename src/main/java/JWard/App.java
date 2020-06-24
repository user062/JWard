package JWard;

import javax.swing.JFrame;
import JWard.Canvas;
import javax.swing.SwingUtilities;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.BoxLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.JPanel;


public class App {
    public static JFrame createGui(String title,
                                   int width,
                                   int height,
                                   Canvas canvas,
                                   JSpinner strokeSpinner,
                                   JSpinner colorSpinner,
                                   JColorChooser colorChooser) {
        SwingUtilities.isEventDispatchThread();
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        strokeSpinner.setMaximumSize(new Dimension(25, 20));
        frame.add(strokeSpinner);

        //colorSpinner.setMaximumSize(new Dimension(45, 45));
        //frame.add(colorSpinner);
        

        colorChooser.setMaximumSize(new Dimension(90, 145));
        frame.add(colorChooser);

        frame.add(canvas);
        return frame;
    }
    
    public static void main(String[] args) {
        SpinnerNumberModel brushModel    = new SpinnerNumberModel(1, 1, 30, 1);
        JSpinner           strokeSpinner = new JSpinner(brushModel);

        SpinnerListModel   colorModel    = new SpinnerListModel(new Color[] {Color.BLUE, Color.GREEN});
        JSpinner           colorSpinner  = new JSpinner(colorModel);

        JColorChooser      colorChooser  = new JColorChooser();
        colorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] panels=colorChooser.getChooserPanels();

        for(AbstractColorChooserPanel p:panels)
            if(!p.getDisplayName().equals("Swatches"))
                colorChooser.removeChooserPanel(p);

        Canvas             canvas        = new Canvas(strokeSpinner, colorChooser);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println(Color.BLUE);
                JFrame gui = createGui("swing paint demo",
                                       750,
                                       750,
                                       canvas,
                                       strokeSpinner,
                                       colorSpinner,
                                       colorChooser);
                gui.setVisible(true);
            }
        });
    }
}

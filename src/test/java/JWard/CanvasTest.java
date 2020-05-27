package JWard;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.swing.JFrame;
import JWard.App;
import JWard.Canvas;

public class CanvasTest {
    @Test public void testFrame() {
        JFrame gui = App.createGui("swing paint demo", 250, 250, new Canvas());
        assertEquals("swing paint demo", gui.getTitle());
        assertEquals(gui.getWidth (), 250);
        assertEquals(gui.getHeight(), 250);
    }
}

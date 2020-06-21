package JWard;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import JWard.Dot;

public class DotTest {
    @Test
    public void testDot(){
        Dot dot = new Dot(9, 8);
        assertEquals(dot.getX(), 9);
        assertEquals(dot.getY(), 8);
    }
}

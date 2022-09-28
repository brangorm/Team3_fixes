import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
    //simple test for now, will add more detailed tests later
    NoFrame frame = new NoFrame(); 

    Ghost ghost = frame.addGhost(new Location(10, 9), "ghost", Color.red); 

    assertTrue(frame.getMap().move("ghost", new Location(10,10), Map.Type.GHOST));
  }
}

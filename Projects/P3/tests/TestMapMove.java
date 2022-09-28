import java.io.*;
import junit.framework.*;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
    //simple test for now, will add more detailed tests later
    NoFrame frame = new NoFrame(); 
    assertTrue(frame.getMap().move("ghost", new Location(10,10), Map.Type.GHOST));
  }
}

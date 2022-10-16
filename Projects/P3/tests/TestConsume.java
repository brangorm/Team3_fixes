import java.io.*;
import junit.framework.*;

public class TestConsume extends TestCase {

  public void testConsume() throws FileNotFoundException {
    // NOTE
    // This test was written by mattlacek
    // but I accidentially deleted it in a commit. 
    // Since I wish to keep the other changes from that commit,
    // I will not reverse the commit directly, I will
    // just add the method back here. 
    // Additionally, I updated this test because it wasn't passing.
    NoFrame frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(5, 5));
  
    assertTrue(frame.getMap().getLoc(new Location(5, 5)).contains(Map.Type.COOKIE));

    pacman.consume();

    assertFalse(frame.getMap().getLoc(new Location(5, 5)).contains(Map.Type.COOKIE));
  }
}

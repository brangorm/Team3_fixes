import java.io.*;
import junit.framework.*;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    MainFrame frame = new MainFrame();
    PacMan pacman = frame.addPacMan(new Location(5, 5));
  
    assertTrue(frame.getMap().getLoc(new Location(5, 5)).contains(Map.Type.COOKIE));

    frame.getMap().eatCookie(pacman.myName);

    assertFalse(frame.getMap().getLoc(new Location(5, 5)).contains(Map.Type.COOKIE));
  }
}

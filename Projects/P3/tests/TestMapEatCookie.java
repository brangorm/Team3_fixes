import java.io.*;
import junit.framework.*;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    MainFrame frame = new MainFrame();
    PacMan pacman = frame.addPacMan(new Location(5, 5));

    assertEquals(new CookieComponent(5, 5, 20), frame.getMap().eatCookie(pacman.myName));
  }
}

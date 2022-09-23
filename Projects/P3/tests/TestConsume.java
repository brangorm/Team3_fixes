import java.io.*;
import junit.framework.*;

public class TestConsume extends TestCase {

  public void testConsume() throws FileNotFoundException {
    MainFrame frame = new MainFrame();
    PacMan pacman = frame.addPacMan(new Location(5, 5));

    assertEquals(new CookieComponent(5, 5, 20), pacman.consume());
  }
}

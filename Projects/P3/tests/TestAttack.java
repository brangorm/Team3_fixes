import java.awt.Color;
import java.io.*;
import junit.framework.*;

public class TestAttack extends TestCase {

  public void testAttack() throws FileNotFoundException {
    MainFrame frame = new MainFrame();
    PacMan pacman = frame.addPacMan(new Location(5, 5));
    Ghost ghost = frame.addGhost(new Location(4, 5), "clyde", Color.orange);

    assertTrue(ghost.attack());
  }
}

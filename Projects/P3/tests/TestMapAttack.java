import junit.framework.*;
import java.io.FileNotFoundException;
import java.awt.Color;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); 
    Ghost ghost = frame.addGhost(new Location(2, 2), "name", Color.red); 
    PacMan pacman = frame.addPacMan(new Location(10, 10)); 
    Ghost ghost2 = frame.addGhost(new Location(10, 9), "name2", Color.orange);

    assertFalse(frame.getMap().isGameOver());
    assertFalse(frame.getMap().attack("name"));
    assertFalse(frame.getMap().isGameOver());
    assertTrue(frame.getMap().attack("name2"));
    assertTrue(frame.getMap().isGameOver());
    

  }
}

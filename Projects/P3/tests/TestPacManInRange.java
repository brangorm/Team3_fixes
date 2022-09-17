import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManInRange extends TestCase {

  public void testPacManInRange() throws FileNotFoundException {
    
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(2, 2), "name", Color.red); //Creates a red ghost named "name" at location x,y
    
    assertFalse(ghost.is_pacman_in_range());
    
    PacMan pacman = frame.addPacMan(new Location(10, 10)); //Creates PacMan at location x, y

    assertFalse(ghost.is_pacman_in_range());

    Ghost ghost2 = frame.addGhost(new Location(10, 9), "name2", Color.orange);

    assertTrue(ghost2.is_pacman_in_range());
  }
}
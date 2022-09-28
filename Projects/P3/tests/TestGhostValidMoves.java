import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import junit.framework.*;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    NoFrame frame =  new NoFrame(); 

    Ghost ghost = frame.addGhost(new Location(10,10), "testGhost", Color.CYAN);
    PacMan pacman = frame.addPacMan(new Location(10,11));
    ArrayList<Location> validMoves = ghost.get_valid_moves();

    //where pacman is
    assertTrue(validMoves.contains(new Location(10,11)));

    //standard other cases
    assertTrue(validMoves.contains(new Location(10,9)));
    assertTrue(validMoves.contains(new Location(9,10)));
    assertTrue(validMoves.contains(new Location(11,10)));
  }
}

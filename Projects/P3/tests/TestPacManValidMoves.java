import java.io.*;
import java.util.ArrayList;

import junit.framework.*;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    //will add more test cases later
    NoFrame frame =  new NoFrame(); 

    PacMan pacman = frame.addPacMan(new Location(10,10));
    ArrayList<Location> validMoves = pacman.get_valid_moves();

    //Non-wall
    assertTrue(validMoves.contains(new Location(10,9)));
    assertTrue(validMoves.contains(new Location(10,11)));

    //walls
    assertFalse(validMoves.contains(new Location(9,10)));
    assertFalse(validMoves.contains(new Location(11,10)));

  }
}

import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(5, 5), "name", Color.red); 
    PacMan pacman = frame.addPacMan(new Location(2, 2));

    assertTrue(frame.getMap().getLoc(new Location(5, 5)).contains(Map.Type.GHOST) );
    assertTrue(frame.getMap().getLoc(new Location(2, 2)).contains(Map.Type.PACMAN));

  }
}

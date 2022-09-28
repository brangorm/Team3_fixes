import java.io.*;
import junit.framework.*;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(5, 5), "name", Color.red); 
    PacMan pacman = frame.addPacMan(new Location(2, 2));

    assertTrue(frame.getMap().getLoc(5,5).containsKey(Map.Type.GHOST) );
    assertTrue(frame.getMap().getLoc(2,2).containsKey(Map.Type.PACMAN));

    assertTrue();
  }
}

import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    return null;
  }

  public boolean move() {
    ArrayList validMoves = get_valid_moves();

    if (validMoves == null || validMoves.size() == 0) {
      return false;
    }

    else {
      Location newPos = validMoves.get(0);
      myLoc = newPos;
      //move(String name, Location loc, Type type)
      myMap.move(myName, myLoc, Map.Type.PACMAN);
      return true;
    }
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}

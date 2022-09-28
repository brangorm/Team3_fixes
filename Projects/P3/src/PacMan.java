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
    return false;
  }

  public boolean is_ghost_in_range() {
    if (!myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.GHOST)) {
      return true;
    }

    else if (!myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.GHOST)) {
      return true;
    }

    else if (!myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.GHOST)) {
      return true;
    }

    else if (!myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.GHOST)) {
      return true;
    } 

    else {
      return false;
    }  
  }

  public JComponent consume() {
    if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
      return myMap.eatCookie(myName);
    } else {
      return null;
    }
  }
}

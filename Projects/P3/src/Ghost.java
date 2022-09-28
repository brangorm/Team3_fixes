import java.util.ArrayList;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
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

  public boolean is_pacman_in_range() {
    if (!myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
      return true;
    }

    else if (!myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN)) {
      return true;
    }

    else if (!myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN)) {
      return true;
    }

    else if (!myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN)) {
      return true;
    } 
    
    else {
      return false;
    }  
  }

  public boolean attack() {
    if (is_pacman_in_range()) {
      return myMap.attack(myName);
    } else {
      return false;
    }
  }
}
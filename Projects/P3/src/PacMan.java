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
    ArrayList<Location> possibleMoves = new ArrayList<Location>();
    ArrayList<Location> validMoves = new ArrayList<Location>();

    possibleMoves.add(this.myLoc.shift(0,1));
    possibleMoves.add(this.myLoc.shift(1,0));
    possibleMoves.add(this.myLoc.shift(-1,0));
    possibleMoves.add(this.myLoc.shift(0,-1));

    //now looping through possible moves and adding the valid moves into new arr

    //for now said that it was an invalid move to go into the ghost. Not sure if 
    // this is true or not in the real game. 
    for (int i=0; i < possibleMoves.size(); i++){
      if ((this.myMap.getLoc(possibleMoves.get(i)) != null) &&
           !(this.myMap.getLoc(possibleMoves.get(i)).contains(Map.Type.WALL)) &&
           !(this.myMap.getLoc(possibleMoves.get(i)).contains(Map.Type.GHOST))){
            validMoves.add(possibleMoves.get(i));
      }
    }
    return validMoves; 
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
    return null;
  }
}
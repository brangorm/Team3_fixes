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
    ArrayList<Location> possibleMoves = new ArrayList<Location>();
    ArrayList<Location> validMoves = new ArrayList<Location>();

    possibleMoves.add(this.myLoc.shift(0,1));
    possibleMoves.add(this.myLoc.shift(1,0));
    possibleMoves.add(this.myLoc.shift(-1,0));
    possibleMoves.add(this.myLoc.shift(0,-1));

    //now looping through possible moves and adding the valid moves into new list

    for (int i=0; i < possibleMoves.size(); i++){
      if ((this.myMap.getLoc(possibleMoves.get(i)) != null) &&
           !(this.myMap.getLoc(possibleMoves.get(i)).contains(Map.Type.WALL))){
            validMoves.add(possibleMoves.get(i));
      }
    }
    return validMoves; 
  }

  public boolean move() {
    return false;
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    return false;
  }
}

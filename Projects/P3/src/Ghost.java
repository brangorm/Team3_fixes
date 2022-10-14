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

    /*Uncomment this code to make it work again 

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
    */
   //breaks by always returning empty list 
    return validMoves; 
  }

  public boolean move() {
    ArrayList<Location> validMoves = get_valid_moves();

    if (validMoves == null || validMoves.size() == 0) {
      return false;
    }

    else {
      Location newPos = validMoves.get(0);
      myLoc = newPos;
      //move(String name, Location loc, Type type)
      myMap.move(myName, myLoc, Map.Type.GHOST);
      return true;
    }

  }

  public boolean is_pacman_in_range() {
    if (myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
      // Uh oh, someone changed the boolean below!
      return false;
    }

    else if (myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.PACMAN)) {
      return true;
    }

    else if (myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.PACMAN)) {
      return true;
    }

    else if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.PACMAN)) {
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
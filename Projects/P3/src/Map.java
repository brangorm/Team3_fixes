import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location
    

    //determining if we should return false becuase unable to move because either 
    //locations map doesn't have the name in it or the components map doesn't have name key 
    //the field does not have the location in it
    if ((!this.locations.containsKey(name)) || (!this.components.containsKey(name)) || 
        (!this.field.containsKey(loc))){
          return false;
    }
    //updating field by first removing type from the current location
    this.field.get(this.locations.get(name)).remove(type);
    //now adding type into new loc in field
    this.field.get(loc).add(type);
    //updating component
    this.components.get(name).setLocation(loc.x,loc.y);
    //updating location
    this.locations.put(name, loc);
    return true;

    

    //breaking it by always returning false, make sure to delete
    return false; 
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    // **HashMap<Location, HashSet<Type>> field
    if (field.containsKey(loc)) {
      return field.get(loc);
    }
    else if (loc.x < dim || loc.y < dim || loc.x > dim || loc.y > dim) {
      return emptySet;
    } else {
      return wallSet;
    }
  }

  public boolean attack(String Name) {
    Location ghostLoc = locations.get(Name);
    boolean success = false;
    Location newLoc = null;
    if (field.get(ghostLoc.shift(0, 1)).contains(Map.Type.PACMAN)) {
       success = true;
       newLoc = ghostLoc.shift(0, 1);
    }

    else if (field.get(ghostLoc.shift(1, 0)).contains(Map.Type.PACMAN)) {
      success = true;
      newLoc = ghostLoc.shift(1, 0);
    }

    else if (field.get(ghostLoc.shift(0, -1)).contains(Map.Type.PACMAN)) {
      success = true;
      newLoc = ghostLoc.shift(0, -1);
    }

    else if (field.get(ghostLoc.shift(-1, 0)).contains(Map.Type.PACMAN)) {
      success = true;
      newLoc = ghostLoc.shift(-1, 0);
    } 

    if (success) {
      field.get(ghostLoc).remove(Type.GHOST);
      field.get(newLoc).add(Type.GHOST);

      locations.remove(Name);
      locations.put(Name, newLoc);
      
      components.get(Name).setLocation(newLoc.x, newLoc.y);
      
      
      // uh oh, someone commented out the update to gameOver!
      gameOver = true;
    }
    

    return success;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
   if (getLoc(locations.get(name)).contains(Map.Type.COOKIE)) {
    JComponent c = components.get("tok_x"+locations.get(name).x+"_y"+locations.get(name).y);
    cookies--;
    locations.remove("tok_x"+locations.get(name).x+"_y"+locations.get(name).y);
    components.remove("tok_x"+locations.get(name).x+"_y"+locations.get(name).y);
    field.get(locations.get(name)).remove(Type.COOKIE);
    return c;
   } else {
    return null;
   }
  }
}

# Project 3: PacMan

## Group Members
- Matt Blodgett
- Matthew Lacek
- Olivia Miskala-Dinc
- Seth Treiman

## Image of code playing PacMan
<img width="596" alt="Screen Shot 2022-09-28 at 4 01 11 PM" src="https://user-images.githubusercontent.com/14205490/192877557-dbdddf33-d2a1-4b07-92fe-55b6a8f61d8c.png">

## How to run the code from the command line
First, compile the code by doing
```javac -cp "tests/junit-4.10.jar:src/:tests/" src/*.java tests/*.java```
Then, if you want to run the game, do
```java -cp "src/" StartMenu```
Finally, if you want to run all tests at once, do

> ``` java -cp "tests/junit-4.10.jar:src/:tests/" org.junit.runner.JUnitCore TestAttack  TestConsume  TestGhostInRange  TestGhostMove  TestGhostValidMoves  TestMapAttack  TestMapEatCookie  TestMapGetLoc  TestMapMove  TestPacManInRange  TestPacManMove  TestPacManValidMoves ```

## List of Functions
### get_valid_moves() in the Pacman Class
- This code works by putting all the non-diagonal adjacent locations into a list and then filtering out all the locations that contain either null, ghost, or a wall. Once done filtering, it returns a list of valid locations. 
- The test creates a board and a single pacman at location (10,10). It then calls the get_valid_moves(), and then makes sure list of valid locations contains ((10,9), (10,11), (9,10), (11,10)). 

### move() in the Pacman Class
- This code works by first calling the get_valid_moves() method to retreive the ArrayList of valid moves, then checks if there is a valid move to move to. If there are no valid moves, false is returned. If there is a valid move, the first available location is selected. Then the pacman's myLoc field is updates to the new location, and the pacman is moved on the map using the Map.move() method, and true is returned.
- The test creates a frame and adds a pacman at location 5,5 then asserts that the pacman is able to move.  

### is_ghost_in_range() in the Pacman Class
- This code works by checking the adjacent non-diagonal locations to see if one of them contains a ghost.
- The test creates a board with one pacman and one ghost where the ghost is not in pacman's range. It tests to make sure the method returns false. Then it adds a ghost in the range of pacman and tests to make sure the method returns true.

### consume() in the Pacman Class
- This code checks if the current location contains a COOKIE data Type. If so, it calls the eatCooke function on the current map, passing in the current name as input. If there is no cookie present, it returns null.
- The test initiates a new frame and adds a PacMan to an arbitrary point. It checks that a cookie is present at that location, then calls consume, then checks that a cookie is no longer present. 

### get_valid_moves() in the Ghost Class
- This code works by putting all the non-diagonal adjacent locations into a list and then filtering out all the locations that contain either null locations, ghost, or a wall. Once done filtering, it returns a list of the valid locations. 
- The test creates a board, single pacman at location (10,11), and a ghost at location (10,10). It then calls the get_valid_moves() function and then makes sure list of valid locations contains ((10,11), (10,9)) and list of invalid locations contains ((9,10), (11,10)). 

### move() in the Ghost Class
- This code works by first calling the get_valid_moves() method to retreive the ArrayList of valid moves, then checks if there is a valid move to move to. If there are no valid moves, false is returned. If there is a valid move, the first available location is selected. Then the ghost's myLoc field is updates to the new location, and the ghost is moved on the map using the Map.move() method, and true is returned.
- The test creates a frame and adds a ghost at location (5,5) then asserts that the ghost is able to move.  

### is_pacman_in_range() in the Ghost Class
- This code works by checking the adjacent non-diagonal locations to see if one of them contains pacman.
- The test creates a board with one ghost then it tests to make sure the method returns false. Then it adds a pacman out of the range of the ghost and tests to make sure the method still returns false. Finally, it adds another ghost that will have a pacman in range and checks that the method returns true.

### attack() in the Ghost Class
- This code first checks that PacMan is in range using the is_pacman_in_range function. If he is, it calls the attack function from the current map using the current name as input. If PacMan is not in range, it returns false.
- This test creates a board, places a PacMan on an arbitrary space, then places a Ghost on an adjacent space. It then checks that calling attack returns true.

### move(String name, Location loc, Type type) in the Map Class
- This code first verifies that the locations field contains the key "name", components field contains the key "name", and the field field contains the key "loc". If any of these fail to be true then this function returns False. From here, it first updates the type paramater from it's old location to new location in the field. Then it updates the component and loctation fields before returning True. 
- The test works by creating a frame and Ghost object in location (10,9) and color red. It then verifies that calling map move function returns True. 

### getLoc(Location loc) in the Map Class
- This code works by taking the Location loc parameter and first checking if the location is a valid location in the field. If it is a valid location, the method returns what is stored in the field map with the loc key. Otherwise, if the location is not found in the field, it checks to see if the location is found within the dimensions of the map. If it is, emptyset is returned. Otherwise, the wallset is returned. 
- The test creates a frame and places a ghost at location (5,5) and a ghost at location (2,2) and then asserts that there is a ghost at location (5,5) and a ghost at location (2,2).

### attack(String name) in the Map Class
- This code works by checking to make sure a pacman is in attack range, and if it is, it attacks and ends the game by setting gameOver to true.
- The test works by putting one ghost in the range of pacman and on ghost out of the range of pacman, then has the out of range ghost try to attack pacman. It asserts that the more distant ghost's attack fails and that the game is not over. Then it has the closer ghost attack pacman and asserts that the closer ghost's attack succeeds and that the game is over.

### eatCookie(String name) in the Map Class
- This code first checks that the location whose name is the input contains a COOKIE type object. If so, then it gets the cookie object from that location and stores it as a local variable. It then decrements the cookies variable and removes the cookie component from the locations, components, and field lists. Finally, it returns the earlier stored cookie object.
- This test creates a frame and places PacMan on an arbitrary location. It checks that a cookie is on that location, then calls eatCookie, then checks that the cookie is no longer there.



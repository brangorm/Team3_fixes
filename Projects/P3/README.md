# Project 3: PacMan

## Group Members
- Matt Blodgett
- Matthew Lacek
- Olivia Miskala-Dinc
- Seth Treiman
## Image of code playing PacMan

## How to run the code from the command line
code block here

## List of Functions
### get_valid_moves() in the Pacman Class
- description of implementation
- description of test 

### move() in the Pacman Class
- description of implementation
- description of test 

### is_ghost_in_range() in the Pacman Class
- This code works by checking the adjacent non-diagonal locations to see if one of them contains a ghost.
- The test creates a board with one pacman and one ghost where the ghost is not in pacman's range. It tests to make sure the method returns false. Then it adds a ghost in the range of pacman and tests to make sure the method returns true.

### consume() in the Pacman Class
- description of implementation
- description of test 

### get_valid_moves() in the Ghost Class
- description of implementation
- description of test 

### move() in the Ghost Class
- description of implementation
- description of test 

### is_pacman_in_range() in the Ghost Class
- This code works by checking the adjacent non-diagonal locations to see if one of them contains pacman.
- The test creates a board with one ghost then it tests to make sure the method returns false. Then it adds a pacman out of the range of the ghost and tests to make sure the method still returns false. Finally, it adds another ghost that will have a pacman in range and checks that the method returns true.

### attack() in the Ghost Class
- description of implementation
- description of test 

### move(String name, Location loc, Type type) in the Map Class
- description of implementation
- description of test 

### getLoc(Location loc) in the Map Class
- description of implementation
- description of test 

### attack(String name) in the Map Class
- This code works by checking to make sure a pacman is in attack range, and if it is, it attacks and ends the game by setting gameOver to true.
- The test works by putting one ghost in the range of pacman and on ghost out of the range of pacman, then has the out of range ghost try to attack pacman. It asserts that the more distant ghost's attack fails and that the game is not over. Then it has the closer ghost attack pacman and asserts that the closer ghost's attack succeeds and that the game is over.

### eatCookie(String name) in the Map Class
- description of implementation
- description of test 



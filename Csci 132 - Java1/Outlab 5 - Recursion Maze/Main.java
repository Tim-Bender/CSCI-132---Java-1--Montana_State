import java.io.IOException;
//Author: Timothy Bender

public class Main {

	
	public static void main(String[] args) throws IOException {
		//import the maze
		InputMaze in = new InputMaze("inputmaze.txt");
		char[][] maze = in.importMaze();
		
		//get the starting position, and starting hand position from the method.
		int[] position = getStartPos(maze); 
		
		//we cannot start in a corner, so check for that.
		//if the start is a corner, the sum of x+y will be either 0, 11, or 22
		if(position[0] + position[1] == 11 || position[0] + position[1] == 0 || position[0] + position[1] == 22) {
			System.out.println("Start cannot be in a corner");
			printMaze(maze);
			}
		
		else {
		solveMaze(maze,position[0],position[1],position[2],position[3]);
			}
		
	}
	
	public static void solveMaze(char[][] maze, int xLoc, int yLoc, int handLocationX, int handLocationY) {
		//base case, if we are on top of the finish 
		if(maze[xLoc][yLoc] == 'F') {
			maze[xLoc][yLoc] = 'O';
			printMaze(maze);
			System.out.println("Maze solved!!!!");
	    	return;
	    }
		//if the base case is not met, continue as normal 
		else {
		maze[xLoc][yLoc] = 'O';
		
		//information
		/*System.out.println("X Value: " + xLoc);
		System.out.println("Y Value: " + yLoc);
		System.out.println("Hand X: " + handLocationX);
		System.out.println("Hand Y: " + handLocationY);*/
		
		printMaze(maze);
	    
		try {
	    	Thread.sleep(50); //change this to speed up/slow down the program.
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    //facing right
		
		//'.' 'x' 'F' are all acceptable spots to move.
		try {
		if (handLocationY > yLoc) {
		    //if your hand is on a . x or F turn right.
		    if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') {
		   		maze[xLoc][yLoc] = 'x';
		   		solveMaze(maze,xLoc,yLoc+1,handLocationX-1,handLocationY);
		   	}//if your hand is on a wall, and a . x or F is in front of you, move forward
		   	else if((maze[xLoc + 1][yLoc] == '.' || maze[xLoc+1][yLoc] == 'x'|| maze[handLocationX][handLocationY] == 'F') && maze[handLocationX][handLocationY] == '#') { //if facing right and spot in front is open, move forward.
	    		maze[xLoc][yLoc] = 'x';
	    		solveMaze(maze,xLoc+1,yLoc,handLocationX+1,handLocationY);
	    	} //if there is a wall in front of you, and your hand is on a wall turn right
		   	else if(maze[xLoc+1][yLoc] == '#' && maze[handLocationX][handLocationY] == '#') {
		   		solveMaze(maze,xLoc,yLoc,handLocationX+1,handLocationY-1);
		   	}
	   }
			    
	    //facing left	
	    else if(handLocationY < yLoc) {
	    	if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') {
	    		maze[xLoc][yLoc] = 'x';
	    		solveMaze(maze,xLoc,yLoc-1,handLocationX+1,handLocationY);
	    	}
	    	//if facing left, and your hand is on a wall, and theres a spot open in front of you, move forward
	    	else if((maze[xLoc-1][yLoc] == '.' || maze[xLoc-1][yLoc] == 'x' || maze[xLoc-1][yLoc] == 'F') && maze[handLocationX][handLocationY] == '#') {
	    		maze[xLoc][yLoc] = 'x';
	    		solveMaze(maze,xLoc-1,yLoc,handLocationX-1,handLocationY);
	    		}
	    	//if you hit a wall turn right
	    	else if(maze[xLoc -1][yLoc] == '#' && maze[handLocationX][handLocationY] == '#') {
	    		solveMaze(maze,xLoc,yLoc,handLocationX-1,handLocationY+1);
	    		}
	    	}
	    
	    //facing up
	    else if(xLoc < handLocationX) {
	    	if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') {
	    		maze[xLoc][yLoc] = 'x';
	    		solveMaze(maze,xLoc+1,yLoc,handLocationX,handLocationY+1);
	    	}
	    	//if you can move forward, then do so
	    	else if((maze[xLoc][yLoc-1] == '.' || maze[xLoc][yLoc-1] == 'x' || maze[xLoc][yLoc-1] == 'F') && maze[handLocationX][handLocationY] == '#') {
	    		maze[xLoc][yLoc] = 'x';
	    		solveMaze(maze,xLoc,yLoc-1,handLocationX,handLocationY-1);
	    	}
	    	//if you run into a  corner turn left
	    	else if(maze[xLoc][yLoc-1] == '#' && maze[handLocationX][handLocationY] == '#') {
	    		solveMaze(maze,xLoc,yLoc,handLocationX-1,handLocationY-1);
	    	}
	    	
	    }
	    
	    //facing down
	    else if(xLoc > handLocationX) {
	    	//if you can turn right, do so
	    	if(maze[handLocationX][handLocationY] == '.' || maze[handLocationX][handLocationY] == 'x' || maze[handLocationX][handLocationY] == 'F') {
	    		maze[xLoc][yLoc] = 'x';
	    		solveMaze(maze,xLoc-1,yLoc,handLocationX,handLocationY-1);
	    	}
	    	//if you can move forward do so
	    	else if((maze[xLoc][yLoc +1] == '.' || maze[xLoc][yLoc+1] == 'x' || maze[xLoc][yLoc+1] == 'F' || maze[xLoc][yLoc+1] == 'F') && maze[handLocationX][handLocationY] == '#') {
	    		maze[xLoc][yLoc] = 'x';
	    		solveMaze(maze,xLoc,yLoc+1,handLocationX,handLocationY+1);
	    	}
	    	//if you run into a wall, and must turn right, do so.
	    	else if(maze[xLoc][yLoc + 1] == '#' && maze[handLocationX][handLocationY] == '#') {
	    		solveMaze(maze,xLoc,yLoc,handLocationX+1,handLocationY+1);
	    		}
	    	}  
	    	
	    }
		catch (ArrayIndexOutOfBoundsException exception){
			System.out.println("Array Index Out of Bounds Failure");
			}
		}   
	}
		//static method to print the maze
	public static void printMaze(char[][] maze) {
		try {
			for(int x = 0; x <= 11;x++) {
				for(int y = 0; y <= 11;y++) {
					System.out.print(maze[y][x]);
					System.out.print(" ");
					if(y == 11)
						System.out.print("\n");
				}
			}
			System.out.println("\n");
		} 
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("Array index out of bounds error");
		}
	}
	//will return the starting position, and starting hand position in an int array
	public static int[] getStartPos(char[][] maze) {
		int[] start = new int[4];
		for(int y = 0; y <= 11;y++) {
			for(int x = 0; x <= 11;x++) {
				if(y == 0) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x-1;
						start[3] = y;
					}
				}
				else if(y == 11) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x+1;
						start[3] = y;
					}
				}
				else if(x == 0) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x;
						start[3] = y+1;
					}
				}
				else if(x == 11) {
					if(maze[x][y] == '.') {
						start[0] = x;
						start[1] = y;
						start[2] = x;
						start[3] = y-1;
					}
				}
			}
		}
		return start;
	}
}

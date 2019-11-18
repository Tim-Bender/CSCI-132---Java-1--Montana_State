import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputMaze {
	String filename; 
	char[][] maze;
	
	
	public InputMaze(String file){
		filename = file;
		maze = new char[12][12];
	}
	
	
	public char[][] importMaze() throws FileNotFoundException{
		Scanner sc = new Scanner(new File(this.filename));
		for (int y = 0; y <= 11; y++) {
		    String line = sc.nextLine().replaceAll(" ", "");
		    System.out.println(line);
		    for (int x = 0; x <= 11; x++) {
		        this.maze[x][y] = line.charAt(x);
		    }
		}
		return this.maze;
		
	}
}

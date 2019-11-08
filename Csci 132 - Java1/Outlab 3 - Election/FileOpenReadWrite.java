import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class FileOpenReadWrite
{
    Scanner fin;
    FileOut fout;
    private int[] numbers;
    
    FileOpenReadWrite(final String fileName) {
        this.numbers = new int[100];
        try {
            this.fin = new Scanner(new File(fileName));
        }
        catch (IOException e) {
            System.err.println(e);
        }
        this.fout = new FileOut("output.txt");
        int counter = 0;
        while (this.fin.hasNext()) {
            final int num = this.fin.nextInt();
            this.numbers[counter] = num;
            ++counter;
            if (num != 0) {
                this.fout.write(String.valueOf(num) + " ");
            }
        }
    }
    
    public static void main(final String[] args) {
        try {
            new FileOpenReadWrite(args[0]);
        }
        catch (Exception e) {
            System.out.println("Usage: Need file input name");
            System.err.println(e);
        }
    }
    
    public int[] getNumbers() {
        return this.numbers;
    }
}
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class FileOut
{
    PrintStream fout;
    String outputString;
    
    FileOut(final String filename) {
        this.outputString = "";
        try {
            this.fout = new PrintStream(new FileOutputStream(filename));
        }
        catch (IOException fo) {
            System.out.println(fo);
        }
    }
    
    public void writer(final String out) {
        this.fout.println(out);
    }
    
    public void writer(final int out) {
        this.fout.println(out);
    }
    
    public void writer(final char out) {
        this.fout.println(out);
    }
    
    public void writer(final double out) {
        this.fout.println(out);
    }
    
    public void writer(final float out) {
        this.fout.println(out);
    }
    
    public void write(final String out) {
        this.fout.print(out);
    }
    
    public void write(final int out) {
        this.fout.print(out);
    }
    
    public void write(final char out) {
        this.fout.print(out);
    }
    
    public void write(final float out) {
        this.fout.print(out);
    }
    
    public void write(final double out) {
        this.fout.print(out);
    }
    
    public void addToString(final String output) {
        this.outputString = String.valueOf(this.outputString) + output;
    }
    
    public String getString() {
        return this.outputString;
    }
}

import java.util.Scanner;

public class Driver
{
    public static void main(final String[] args) {
        final FileOut fout = new FileOut("output.txt");
        final Scanner sc = new Scanner(System.in);
        System.out.println("Please input a filename");
        final String filename = sc.next();
        final FileOpenReadWrite fl = new FileOpenReadWrite(filename);
        final int[] numbers = fl.getNumbers();
        int counter = 0;
        for (int x = 0; x < numbers.length; ++x) {
            if (numbers[x] != 0) {
                ++counter;
            }
        }
        int position = 0;
        for (int number = 0; number < counter / 3; ++number) {
            final int N = numbers[position];
            final int K = numbers[position + 1];
            final int M = numbers[position + 2];
            fout.addToString("Program 4\n");
            fout.addToString("_________\n");
            fout.addToString("N = " + N + " k = " + K + " m = " + M + "\n");
            final LinkedList theList = new LinkedList();
            for (int x2 = 1; x2 <= N; ++x2) {
                final Node temp = new Node(x2);
                theList.add(temp);
            }
            theList.setMK();
            while (theList.getK() != theList.getM() && theList.getFirst() != null) {
                theList.moveK(K);
                theList.moveM(M);
                if (theList.getK() != theList.getM()) {
                    fout.addToString(String.valueOf(theList.getK()) + " " + theList.getM() + "\n");
                    theList.remove(theList.getKNode());
                    theList.remove(theList.getMNode());
                }
                if (theList.getK() == theList.getM() && theList.getFirst() != null) {
                    fout.addToString(String.valueOf(theList.getM()) + "\n");
                    if (theList.getFirst() == null) {
                        continue;
                    }
                    theList.remove(theList.getKNode());
                }
            }
            if (theList.getFirst() != null) {
                fout.addToString(String.valueOf(theList.getK()) + "\n");
            }
            position += 3;
        }
        fout.write(fout.getString());
    }
}
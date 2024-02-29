package y2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Charybdis2
 */

public class day2 {
    

    private int ribbon = 0;

/**
 * Calculates ribbon and wrapping paper lengths
 * @param line the line in format of wxlxh
 * @return total ribbon or wrapping paper for that present
 */

    public int presentCalc(String line) {
        String[] words = line.split("x");
    
        int l = Integer.parseInt(words[0]);
        int w = Integer.parseInt(words[1]);
        int h = Integer.parseInt(words[2]);
    

        int side1 = l * w;
        int side2 = w * h;
        int side3 = h * l;
    

        int smallestSide = Math.min(Math.min(side1, side2), side3);
    
        

        int smallestPerimeter = 2 * (l + w + h - Math.max(Math.max(l, w), h));
    

        this.ribbon += smallestPerimeter;
        int bowRibbon = l * w * h;
        this.ribbon += bowRibbon;
    
        return (2 * side1 + 2 * side2 + 2 * side3) + smallestSide;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader("day2.txt"));
        int total = 0;
        day2 obj = new day2();
        try {
            String line = bufferReader.readLine();
            while (line != null) {
                total += obj.presentCalc(line);
                line = bufferReader.readLine(); 
            } 
        } finally {
            bufferReader.close();
        }
        System.out.println("First Part: "+total);
        System.out.println("Second Part: "+obj.ribbon);
    }

    
}

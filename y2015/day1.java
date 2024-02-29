package y2015;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Charybdis2
 *  written 29/04/2024
 * I'm not too familiar with object methods so maybe the getter could've been better
 * 
 */

public class day1{

    private int negativeFloor;

    public int getNegativeFloor(){
        return this.negativeFloor;
    }

    /**
     * This also sets when the basement is first reached
     * @param line line from file
     * @return number of floors
     */
    public  int NumberOfFloors(String line){
        String[] words = line.split("");
        int totalFloor = 0;
        boolean flag = false;
        for (int i =0; i<words.length;i++){
            if (words[i].equals("(")){
                totalFloor ++;
            }else{
                totalFloor --;
                if (totalFloor == -1 && flag == false){
                    flag =true;
                    this.negativeFloor = i+1;

                }
            }
        }
        return totalFloor;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader("day1.txt"));
        int floor = 0; 
        day1 obj = new day1();
        try {
            String line = bufferReader.readLine();
            while (line != null) {
                floor += obj.NumberOfFloors(line); 
                line = bufferReader.readLine(); 
            }
            System.out.println("Final Floor: "+floor);
            System.out.println("First Negative floor: "+(obj.getNegativeFloor()));
    
        } finally {
            bufferReader.close();
        }
    }

}
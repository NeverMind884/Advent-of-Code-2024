import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[]args){

        try {
            //part 1
            File myObj = new File("localIDs.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Integer> col1 = new ArrayList<>();
            ArrayList<Integer> col2 = new ArrayList<>();
            ArrayList<Integer> allDiff = new ArrayList<>();
            ArrayList<Integer> allSimScores = new ArrayList<>();
            int totalDiff = 0;
            int totalSim = 0;
            int simScore = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] local = data.split("   ",2);
                col1.add(Integer.parseInt(local[0]));
                Collections.sort(col1);
                col2.add(Integer.parseInt(local[1]));
                Collections.sort(col2);
            }
            for(int i = 0; i < col1.size(); i++){
                int diff = Math.abs(col1.get(i) - col2.get(i));
                allDiff.add(diff);
                totalDiff = totalDiff + allDiff.get(i);
            }

            System.out.println(totalDiff);

            //Part 2

            for (Integer integer : col1) {
                simScore = Collections.frequency(col2, integer);
                allSimScores.add(integer * simScore);
            }
            for (Integer allSimScore : allSimScores) {
                totalSim = totalSim + allSimScore;
            }
            System.out.println(totalSim);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

//1hr and 21 minutes

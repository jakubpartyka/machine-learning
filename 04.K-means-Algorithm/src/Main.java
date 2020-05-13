import java.io.*;
import java.util.Scanner;

public class Main {
    private static int k;
    private static File input = new File("iris.data");

    public static void main(String[] args) throws IOException {
	    //set Centroid boud
        Centroid.setBound(10);

        //k selection
        System.out.println("enter K: ");
        k = new Scanner(System.in).nextInt();

        readInputFile();

        int iterationsWithoutChange = 0;

        while (iterationsWithoutChange < 2){

        }




    }

    private static void readInputFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line = reader.readLine();
        while (line != null){
            String [] data = line.split(",");
            InputObject object = new InputObject(data[0],data[1],data[2],data[3]);
            InputObject.data.add(object);
            line = reader.readLine();
        }
    }
}

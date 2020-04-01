import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    //file settings
    private static final String trainingSetPath = "perceptron.data.csv";
    private static final String dataSetPath = "perceptron.test.data.csv";

    //lists
    private static ArrayList<dataObject> trainingSet   = new ArrayList<>();
    private static ArrayList<dataObject> dataSet       = new ArrayList<>();

    public static void main(String[] args) {
	    loadTrainingSet();
        loadDataSet();
    }

    private static void loadTrainingSet() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(trainingSetPath));
            String line = reader.readLine();
            while (line != null){
                String [] data = line.split(",");
                double a = Double.parseDouble(data[0]),b = Double.parseDouble(data[1]),c = Double.parseDouble(data[2]),d = Double.parseDouble(data[3]);
                trainingSet.add(new dataObject(a,b,c,d,true,data[4]));
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found"+ trainingSetPath);
        } catch (IOException e) {
            System.out.println("an exception was thrown: " + e.getMessage());
        }

        System.out.println("training set read OK");
    }

    private static void loadDataSet() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataSetPath));
            String line = reader.readLine();
            while (line != null){
                String [] data = line.split(",");
                double a = Double.parseDouble(data[0]),b = Double.parseDouble(data[1]),c = Double.parseDouble(data[2]),d = Double.parseDouble(data[3]);
                dataSet.add(new dataObject(a,b,c,d,false,data[4]));
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found"+ dataSetPath);
        } catch (IOException e) {
            System.out.println("an exception was thrown: " + e.getMessage());
        }
        System.out.println("data set read OK");
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String TRAINING_SET_FILENAME = "iris.test.data";
    private static final String DATA_SET_FILENAME = "iris.data";
    private static int k = 4;
    private static List<TrainingObject> trainingSet = new ArrayList<>();
    private static List<TrainingObject> dataSet = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Program start");
        System.out.println("K = " + k);

        //load training set from file
        loadTrainingSet();

        //load actual data set
        loadSetToAnalyze();

        analyzeData();






    }

    private static void analyzeData() {
        for (TrainingObject dataObject : dataSet) {
            HashMap<TrainingObject,Double> distances = new HashMap<>();

            //calculate distances
            for (TrainingObject trainingObject : trainingSet) {
                distances.put(trainingObject,calculateDistance(dataObject,trainingObject));
            }

            //determine data object type according to K parameter



        }

    }

    private static Double calculateDistance(TrainingObject dataObject, TrainingObject trainingObject) {
        Double distance;
        double A = dataObject.a, B = dataObject.b, C = dataObject.c, D = dataObject.d;
        double a = trainingObject.a, b = trainingObject.b, c = trainingObject.c, d = trainingObject.d;

        distance = Math.sqrt(Math.pow(a-A,2) + Math.pow(b-B,2) + Math.pow(c-C,2) + Math.pow(d-D,2));

        return distance;
    }

    private static void loadTrainingSet() {
        System.out.println("loading training set from file: " + TRAINING_SET_FILENAME);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(TRAINING_SET_FILENAME));
            String line = reader.readLine();

            while (line != null){
                String [] data = line.split(",");

                TrainingObject object = new TrainingObject(data[0],data[1],data[2],data[3],data[4]);
                trainingSet.add(object);
                line = reader.readLine();
            }
            System.out.println("training set was read successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadSetToAnalyze() {
        System.out.println("loading data set from file: " + DATA_SET_FILENAME);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATA_SET_FILENAME));
            String line = reader.readLine();

            while (line != null){
                String [] data = line.split(",");

                AnalyzedObject object = new AnalyzedObject(data[0],data[1],data[2],data[3],data[4]);
                dataSet.add(object);
                line = reader.readLine();
            }
            System.out.println("data set was read successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

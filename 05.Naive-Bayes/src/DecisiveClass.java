import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class DecisiveClass {
    private HashMap<String,Double> classProbability = new HashMap<>();
    private HashMap<String,Double> occurrencesCount = new HashMap<>();
    private int occurrenceSum;
    private final static File training = new File("car.data");

    void countOccurences() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(training));
        String line = reader.readLine();
        while (line != null){
            String [] data = line.split(",");
            String key = data[data.length-1];

            //add to occurrences and increment sum
            if (!occurrencesCount.containsKey(key)) occurrencesCount.put(key,1.0);
            else occurrencesCount.put(key, occurrencesCount.get(key) + 1.0);
            occurrenceSum += 1;

            //read next line
            line = reader.readLine();

            for (String cls : occurrencesCount.keySet())
                classProbability.put(cls,(occurrencesCount.get(cls)/ occurrenceSum));
        }
        double check = 0;
        System.out.println("CLASS PROBABILITY: ");
        for (String s : occurrencesCount.keySet()) {
            System.out.println(s + "\t" + classProbability.get(s));
            check += classProbability.get(s);
        }
        if(check == 1.0) System.out.println("class probability read OK");
        else System.out.println("class probability read FAIL");

    }
}

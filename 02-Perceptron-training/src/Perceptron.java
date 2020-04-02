import com.sun.org.apache.regexp.internal.RE;

import java.util.List;
import java.util.Random;

class Perceptron {
    private int [] wageVector = new int[Main.NUMBER_OF_VARIABLES];
    private double deviation;   //odchylenie

    Perceptron(double deviation) {
        this.deviation = deviation;
        generateWageVector();
    }

    private void generateWageVector() {
        //a method that generates new random wage vector
        Random random = new Random();
        for (int i = 0; i < wageVector.length ; i++) {
            wageVector[i] = random.nextInt(9) + 1;
        }
    }

    String getWageVector(){
        StringBuilder output = new StringBuilder();
        for (int i : wageVector) {
            output.append(String.valueOf(i)).append(" ");
        }
        return output.toString();
    }

    void train(List<DataObject> trainingSet, double learningFactor, double trainingConstant, int errorMax, int maxIterations) {
        int iteration = 0;
        int errorCount = errorMax + 1;

        while (errorCount >= errorMax && iteration < maxIterations){

            for (DataObject dataObject : trainingSet) {
                //calculate perceptron's output value
                int y = calculateOutput(dataObject.dataAsVector());
                //set discovered type
                dataObject.setDiscoveredType(Main.values.get(y).toString());

                //DELTA RULE
                applyDeltaRule(dataObject);
            }

            iteration++;
        }
    }

    private void applyDeltaRule(DataObject dataObject) {
        //this method modifies deviation and wages vector according to delta rule and data object argument.
        if(!dataObject.isTraining){
            //check if passed object is a training object
            System.out.println("ten obiekt nie jest obiektem treningowym!");
            return;
        }

        //quit if type was discovered correctly - no changes will be applied anyway
        if(dataObject.getDiscoveredType().equals(dataObject.type))
            return;


    }

    int calculateOutput(double [] inputVector){
        //check if vectors match each other
        if(inputVector.length != wageVector.length){
            System.out.println("Zły wektor");
            return -1;
        }

        int net = 0;

        //calculate vectors' scalar product
        for (int i : wageVector) {
            net += wageVector[i] * inputVector[i];
        }
        net -= deviation;

        if(net >= 0)
            return 1;
        return 0;
    }
}

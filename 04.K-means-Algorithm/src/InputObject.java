import java.util.ArrayList;
import java.util.List;

class InputObject {
    static List<InputObject> data = new ArrayList<>();

    private int a,b,c,d;
    Centroid assignedCentroid;

    InputObject(String a, String b, String c, String d) {
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);
        this.c = Integer.parseInt(c);
        this.d = Integer.parseInt(d);
    }

    void findClosestCentroid(){
        //assign first centroid at the beginning
        double shortestDistance = calculateDistanceFromCentroid(Centroid.centroids.get(0));
        assignedCentroid = Centroid.centroids.get(0);
        assignedCentroid.assignedObjects.add(this);

        for (Centroid centroid : Centroid.centroids) {
            double newDistance = calculateDistanceFromCentroid(centroid);
            if(newDistance < shortestDistance){
                //remove from old centroid
                assignedCentroid.assignedObjects.remove(this);

                //set according to new centroid
                shortestDistance = newDistance;
                assignedCentroid = centroid;
                assignedCentroid.assignedObjects.add(this);
            }
        }
    }

    private double calculateDistanceFromCentroid(Centroid centroid) {
        double sum =
                Math.pow(this.a - centroid.a,2) +
                Math.pow(this.b - centroid.b,2) +
                Math.pow(this.c - centroid.c,2) +
                Math.pow(this.d - centroid.d,2);
        return Math.sqrt(sum);
    }
}

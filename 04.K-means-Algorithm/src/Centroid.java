import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public class Centroid {
    static List<Centroid> centroids = new ArrayList<>();

    List<InputObject> assignedObjects = new ArrayList<>();

    private static int bound = -1;
    int a,b,c,d;

    public Centroid() {
        if(bound == -1) {
            System.out.println("set correct centroid generation bound");
            return;
        }

        Random random = new Random();
        a = random.nextInt(bound);
        b = random.nextInt(bound);
        c = random.nextInt(bound);
        d = random.nextInt(bound);
        centroids.add(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(!obj.getClass().equals(this.getClass()))
            return false;
        Centroid otherCentroid = (Centroid) obj;
        return (otherCentroid.a == this.a && otherCentroid.b == this.b && otherCentroid.c == this.c && otherCentroid.d == this.d);
    }

    static void setBound(int bound) {
        Centroid.bound = bound;
    }
}

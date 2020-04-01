public class dataObject {
    double a,b,c,d;
    boolean isTraining = false;
    String type;
    private String discoveredType = null;

    public dataObject(double a, double b, double c, double d, boolean isTraining, String type) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.isTraining = isTraining;
        this.type = type;
    }

    public String getDiscoveredType() {
        if(isTraining){
            return "this is a training object - no discovered type";
        }
        return discoveredType;
    }

    public void setDiscoveredType(String discoveredType) {
        if(!isTraining)
            this.discoveredType = discoveredType;
    }
}

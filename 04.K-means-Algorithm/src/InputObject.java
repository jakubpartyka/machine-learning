import java.util.ArrayList;
import java.util.List;

class InputObject {
    static List<InputObject> data = new ArrayList<>();

    private int a,b,c,d;

    InputObject(String a, String b, String c, String d) {
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);
        this.c = Integer.parseInt(c);
        this.d = Integer.parseInt(d);
    }
}

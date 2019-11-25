import java.util.TreeSet;

public class LabeledPoint implements Comparable<LabeledPoint> {
    private int x;
    private int y;
    private String label;

    public LabeledPoint(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + "), Label: " + this.label;
    }

    public int hashCode() {
        final int HASH = 31;
        int result = 1;
        result = HASH * result + (int) (this.x ^ (this.x >>> 32));
        result = HASH * result + (int) (this.y ^ (this.y >>> 32));
        result = HASH * result + this.label.hashCode();
        return result;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof LabeledPoint) {
            LabeledPoint that = (LabeledPoint) o;
            return this.x == that.x && this.y == that.y && this.label.equals(that.label);
        }
        return false;
    }

    public int compareTo(LabeledPoint l) {
        if (this.x > l.x)
            return 1;

        else if (this.x < l.x)
            return -1;

        else if (this.y > l.y)
            return 1;

        else if (this.y < l.y)
            return -1;

        else if (this.label.compareTo(l.label) > 0)
            return 15;

        else if (this.label.compareTo(l.label) < 0)
            return -15;

        else
            return 0;

    }

    public static TreeSet<LabeledPoint> treeSetPoints() {
        TreeSet<LabeledPoint> ans = new TreeSet<>();

        LabeledPoint a = new LabeledPoint(2, 0, "magic");
        LabeledPoint b = new LabeledPoint(-2, 0, "blah");
        LabeledPoint c = new LabeledPoint(-2, 0, "bar");
        LabeledPoint d = new LabeledPoint(-2, -2, "map");

        ans.add(a);
        ans.add(b);
        ans.add(c);
        ans.add(d);

        return ans;
    }
}
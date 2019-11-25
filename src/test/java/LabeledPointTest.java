import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LabeledPointTest {
     @Test
    void shouldCompareDifferentXValues() {
        LabeledPoint p1 = new LabeledPoint(2, 3, "hello");
        LabeledPoint p2 = new LabeledPoint(3, 2, "world");
        assertEquals(-1, p1.compareTo(p2));
        assertEquals(1, p2.compareTo(p1));
    }

    @Test
    void shouldCompareDifferentYValues() {
        LabeledPoint p1 = new LabeledPoint(2, 3, "hello");
        LabeledPoint p2 = new LabeledPoint(2, 4, "world");
        assertEquals(-1, p1.compareTo(p2));
        assertEquals(1, p2.compareTo(p1));
    }

    @Test
    void shouldCompareDifferentLabelValues() {
        LabeledPoint p1 = new LabeledPoint(2, 3, "hello");
        LabeledPoint p2 = new LabeledPoint(2, 3, "world");
        assertEquals(-15, p1.compareTo(p2));
        assertEquals(15, p2.compareTo(p1));
    }

    @Test
    void shouldReturnZeroIfExactlySame() {
        LabeledPoint p1 = new LabeledPoint(2, 3, "hello");
        LabeledPoint p2 = new LabeledPoint(2, 3, "hello");
        assertEquals(0, p1.compareTo(p2));
    }

    @Test
    void shouldTestOrderedTree() {
        TreeSet<LabeledPoint> set = LabeledPoint.treeSetPoints();
        assertEquals(new LabeledPoint(-2, -2, "map"), set.pollFirst());
        assertEquals(new LabeledPoint(-2, 0, "bar"), set.pollFirst());
    }
}

package ComparatorEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        System.out.println("Using Java 7");
        Collections.sort(names, new NamesComparator());
        System.out.println(names);
        List<String> namesLetter = Arrays.asList("Abxc", "anna", "mike", "xenia");
        System.out.println("Using Java 8");

        Collections.sort(names, (String a, String b) -> a.compareTo(b));
        System.out.println(names);
    }
}

class NamesComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
}
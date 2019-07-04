package streamsExamples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMapOperationDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(23, "Mahesh");
        map.put(10, "Suresh");
        map.put(26, "Dinesh");
        map.put(11, "Kamlesh");

        List<Integer> list = map.keySet().stream().collect(Collectors.toList());
        System.out.println(list);

        List<String> list1 = map.values().stream().collect(Collectors.toList());
        System.out.println(list1);

    }
}

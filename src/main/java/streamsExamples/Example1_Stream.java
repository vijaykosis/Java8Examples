package streamsExamples;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example1_Stream {
    public static Predicate<Task> namePredicate = x -> x.getType().equalsIgnoreCase("java");

    public static void main(String[] args) {
        List<Task> tasks = getTasks();

        //  otherExamples(tasks);

        FilterExample(tasks);
        SortedExample(tasks);
        MapExample(tasks);
        MatchExample(tasks);
        CountExample(tasks);
        flateMapExample(tasks);
        flateMapExample2();
        //   IntStreamsExample();
    }

    private static void flateMapExample2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list3 = Arrays.asList(11, 12, 13, 14, 15);
        List<Integer> list4 = Arrays.asList(-1, -2, -3, -4, -5);
        List<List<Integer>> lists = Arrays.asList(list1, list2, list3, list4);
        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(lists);
        List<Integer> simpleList = lists.stream().flatMap(x -> x.stream()).sorted().collect(Collectors.toList());
        System.out.println(simpleList);

    }

    private static void flateMapExample(List<Task> tasks) {

        List<Task> taskList1 = Arrays.asList(new Task("Java", "Bruce "), new Task(".Net", "Test2 "), new Task("JavaScript", "Test3"));
        List<Task> taskList2 = Arrays.asList(new Task("Science", "T3 "), new Task("Math", "T4 "), new Task("Punjabi", "T4"));

        List<List<Task>> taskList = Arrays.asList(taskList1, taskList2, tasks);

        System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(taskList);
        List<Task> task = taskList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(task);
    }

    private static void CountExample(List<Task> tasks) {
        System.out.println("Count() Stream java example...>>>>>>>>>>");
        Predicate<Task> startWithJavaPredicate = x -> x.getType().equalsIgnoreCase("java");

        long startWithJava = tasks.stream().filter(startWithJavaPredicate).count();
        System.out.println(startWithJava);


    }

    private static void MatchExample(List<Task> tasks) {
        System.out.println("MatchExample>>>>>>>>>>>");
        Predicate<Task> matchName = x -> x.getType().equalsIgnoreCase("Java");
        Predicate<Task> andMatch = matchName.or(x -> x.getType().equalsIgnoreCase(".Net"));
        boolean anyStartsWithJavaOrDotNet = tasks.stream().allMatch(andMatch);
        System.out.println(anyStartsWithJavaOrDotNet);
    }

    private static void MapExample(List<Task> tasks) {
        System.out.println("MapExample>>>>>>>>>>>");
        tasks.stream().map(x -> x.getTitle().toUpperCase()).forEach(System.out::println);
    }

    private static void IntStreamsExample() {
        System.out.println("IntStreamsExample>>>>>>>>>>>");
        IntPredicate numPredicate = num -> num % 2 == 0;
        IntStream.range(1, 10).filter(numPredicate).forEach(System.out::println);
    }

    private static void otherExamples(List<Task> tasks) {

        List<String> readingTasks = tasks.stream().filter(task -> task.getType().equals("java")).sorted((t1, t2) -> t1.getTitle().length() - t2.getTitle().length()).map(Task::getTitle).collect(Collectors.toList());

        //readingTasks.forEach(System.out::println);
        System.out.println(readingTasks);

        new Example1_Stream().getResult(tasks);

        String result = readingTasks.stream().reduce("", (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());
        System.out.println("result>>>>>>>>>>>>>" + result);
    }

    private static void SortedExample(List<Task> tasks) {
        System.out.println("SortedExample>>>>>>>>>>>");
        List<Task> list = tasks.stream().filter(namePredicate).sorted((s1, s2) -> s1.getTitle().compareTo(s2.getTitle())).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void FilterExample(List<Task> tasks) {


        List<Task> taskList = tasks.stream().filter(namePredicate).collect(Collectors.toList());
        System.out.println("FilterExample>>>>>>>>>>>" + taskList);

    }


    private void getResult(List<Task> tasks) {

        Predicate<Task> startWithJavaPredicate = x -> x.getType().equalsIgnoreCase("java");

        long startWithJava = tasks.stream().filter(startWithJavaPredicate).count();
        System.out.println(startWithJava);

        System.out.println(" reduce Stream java example...>>>>>>>>>>");


    }

    class Counter {
        int count;

        Counter(int count) {
            this.count = count;
        }

        public String toString() {
            return "Counter-" + count;
        }
    }


    private static List<Task> getTasks() {
        List<Task> tasks = Arrays.asList(new Task("Book-1", "java"), new Task("Book-11", "java"),
                new Task("Book2", ".Net"),
                new Task("Book-119", "java"),
                new Task("Book3", "javaScript"),
                new Task("Book4", "Angular"));

        return tasks;
    }


    static Predicate<Task> stringPredicate = s -> s.equals("java");
}


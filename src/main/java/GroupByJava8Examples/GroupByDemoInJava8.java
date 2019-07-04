package GroupByJava8Examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * groupingBy() method of Collector class and Stream.
 */
public class GroupByDemoInJava8 {
    public static void main(String args[]) throws IOException {
        List<Employee> employeeList = getallEmployeDeatils();

        // Let's see how we can group objects in Java 8
        Map<String, List<Employee>> EmployeeByCity = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employee grouped by cities in Java 8: ");
        System.out.println(EmployeeByCity);

        // Now let's group Employee by age

        Map<Integer, List<Employee>> EmployeeByAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("Employee grouped by age in Java 8: ");
        System.out.println(EmployeeByAge);


        Predicate<Employee> filterBySal = p -> p.getSalary() > 50000;
        Map<Double, List<Employee>> employeeBySal = employeeList.stream().filter(filterBySal).collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println("Employee grouped by salary in Java 8: ");
        System.out.println(employeeBySal);


        // cobines name those sal> 50000
        System.out.println("Employee grouped by salary in Java 8 and cobines name those sal> 50000: ");
        Map<Double, String> result =
                employeeList.stream().filter(filterBySal).collect(
                        Collectors.groupingBy(Employee::getSalary,
                                Collectors.mapping(Employee::getName, Collectors.joining(" ")))
                );
        result.values().forEach(System.out::println);

    }


    private static List<Employee> getallEmployeDeatils() {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("John", "London", 21, 20000));
        employee.add(new Employee("Swann", "London", 21, 10000));
        employee.add(new Employee("Kevin", "London", 23, 32442));
        employee.add(new Employee("Monobo", "Tokyo", 23, 40000));
        employee.add(new Employee("Sam", "Paris", 23, 65443));
        employee.add(new Employee("Nadal", "Paris", 31, 76432));
        return employee;
    }
}

class Employee {
    private String name;
    private String city;
    private int age;
    private double salary;

    public Employee(String name, String city, int age, double salary) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
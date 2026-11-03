a. Filtering Even Numbers from a List
Filename: EvenNumberFilter.java


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumberFilter {
    public static void main(String[] args) {

        // Creating a list of numbers
        List<Integer> numbers = Arrays.asList(5, 12, 7, 8, 15, 24, 33, 16);

        // Filtering even numbers using Stream
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // Displaying even numbers
        System.out.println("Even Numbers: " + evenNumbers);
    }
}

b. Convert All Names to Uppercase
Filename: NameUpperCase.java


import java.util.Arrays;
import java.util.List;

public class NameUpperCase {
    public static void main(String[] args) {

        // Creating a list of names
        List<String> names = Arrays.asList(
            "ravi", "meena", "akash", "nisha"
        );

        System.out.println("Names in Uppercase:");

        // Converting names to uppercase using Stream
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}

c. Count Strings Starting with Letter "A"
Filename: CountNamesStartingWithA.java


import java.util.Arrays;
import java.util.List;

public class CountNamesStartingWithA {
    public static void main(String[] args) {

        // Creating a list of strings
        List<String> strings = Arrays.asList(
            "Apple", "Banana", "Avocado",
            "Apricot", "Berry", "Cherry"
        );

        // Counting strings starting with A
        long count = strings.stream()
                .filter(s -> s.startsWith("A"))
                .count();

        // Displaying the count
        System.out.println(
            "Number of strings starting with 'A': " + count
        );
    }
}

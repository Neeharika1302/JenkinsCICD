import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsJava {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Neeha", "Ravi", "Arun", "Kiran", "Rama", "Adam", "Arjun");
        List<String> list1 = Arrays.asList("Honey", "Krati", "Rahul", "Alekhya");
        System.out.println(list.stream().filter(s -> s.startsWith("A")).count());

        list.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println("Names with length > 4 " + s));

        list.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println("limited name " + s));

        list.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        list.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


        List<String> newlist = Stream.concat(list.stream(), list1.stream()).toList();
        System.out.println("New List");
        newlist.stream().sorted().forEach(s -> System.out.println(s));
        boolean flag = newlist.stream().anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);

        List<String> newlist1 = list.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
        System.out.println(newlist1);

        List<Integer> numList = Arrays.asList(2, 3, 6, 5, 8, 9, 4, 2, 1, 0);
        System.out.println(numList.stream().sorted().toList());
        List<Integer> distList=numList.stream().distinct().toList();
        System.out.println(distList);
        System.out.println(distList.get(2));
    }
}

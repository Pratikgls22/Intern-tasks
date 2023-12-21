package StreamApi;

import Lists.DefaultList;

import javax.xml.stream.events.StartElement;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static Lists.DefaultList.name;

public class StreamApiCode {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("java", "python", "dotnet");
        Stream<String> na = name.stream();
        na.map(n -> n + " " + n).forEach(System.out::println);
        //Stream <String> mapdata = na.map(n-> n+" "+n);
        //mapdata.forEach(n->System.out.println(n));
        //mapdata.forEach(System.out::println);

        //List<Integer> list2 = Arrays.asList(2, 5, 9, 7, 3);
        //in single line code
        // using method from another class
        DefaultList.number().
                stream().
                filter(n->n%2 == 1).
                map(n -> n * 2).
                sorted().
                //forEach(System.out::println);
                        forEach(n -> System.out.println(n));


        // Reduce Method
        int even = DefaultList.number().stream().
                map(n -> n * 2).
                sorted().
                reduce(0, (x, i) -> x + i);
        System.out.println(even);

        // Array Stream
        //String[] arr = {"one", "two", "three"};
        //Convert array in stream
        //Stream<String[]> sArray = Stream.of(arr);
        //Stream<String> sArray = Arrays.stream(arr);
        Arrays.stream(DefaultList.names()).sorted().filter(n-> n.startsWith("t")).forEach(System.out::println);

        Optional<String> any = Arrays.stream(DefaultList.names()).findAny();
        System.out.println(any.get());

        Optional<String> first = name().stream().findFirst();
        System.out.println(first.get());

    }
}

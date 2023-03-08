
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        Stream<Integer> numbers = list.stream();
        System.out.println(list.toString());
        findMinMax( list.stream().parallel(),
                Integer::compareTo,
                (min, max) -> System.out.println("Min " + min + ". Max " + max)
        );
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ){ List<? extends T> list = stream.sorted(order).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size()- 1));
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
    public static int evenNumbers(List<Integer> list) {
        return (int)list.stream().filter(a->a%2 ==0).count();

    }
}

package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTest {
    @Test
    void testGroupingBy() {
        Map<String, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.groupingBy(number -> {
                    if (number > 5) {
                        return "Besar";
                    } else {
                        return "Kecil";
                    }
                }));

        System.out.println(collect);
    }

    @Test
    void testGroupingBy2() {
        Map<String, List<String>> map = Stream.of("Muhamad", "Yasir", "Noval", "Budi", "Joko")
                .collect(Collectors.groupingBy(name -> {
                    if (name.length() > 4) {
                        return "Panjang";
                    } else {
                        return "Pendek";
                    }
                }));

        System.out.println(map);
    }

    @Test
    void testPartitioningBy() {
        Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.groupingBy(number -> {
                    return number > 5;
                }));

        System.out.println(collect);
    }
}

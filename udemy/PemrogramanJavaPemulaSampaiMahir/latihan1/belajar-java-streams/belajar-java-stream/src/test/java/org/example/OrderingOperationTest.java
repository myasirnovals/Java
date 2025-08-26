package org.example;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class OrderingOperationTest {
    @Test
    void testSorted() {
        List.of("Edo", "Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testSortedWithComparator() {
        Comparator<String> revereseComparator = Comparator.reverseOrder();

        List.of("Edo", "Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .sorted(revereseComparator)
                .forEach(System.out::println);
    }
}

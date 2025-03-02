package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RetrievingOperationTest {
    @Test
    void testLimit() {
        List.of("Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    void testSkip() {
        List.of("Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    void testTakeWhile() {
        List.of("Edo", "Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .takeWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

    @Test
    void testDropWhile() {
        List.of("Edo", "Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .dropWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

    @Test
    void testFindAny() {
        Optional<String> optional = List.of("Edo", "Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .findAny();

        optional.ifPresent(name -> {
            System.out.println(name);
        });
    }

    @Test
    void testFindFirst() {
        Optional<String> optional = List.of("Edo", "Derek", "Gary", "Ramirez", "Mac", "Gordon", "Gary", "Gary", "Gary").stream()
                .findFirst();

        optional.ifPresent(name -> {
            System.out.println(name);
        });
    }
}

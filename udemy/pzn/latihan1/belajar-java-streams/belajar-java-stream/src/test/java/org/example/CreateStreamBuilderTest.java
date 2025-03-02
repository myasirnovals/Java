package org.example;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CreateStreamBuilderTest {
    @Test
    void testCreateStreamBuilder() {
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Muhamad");
        builder.add("Yasir").add("Noval");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }

    @Test
    void testCreateStreamBuilderSimplify() {
        Stream<Object> stream = Stream.builder().add("Muhamad").add("Yasir").add("Noval").build();
        stream.forEach(System.out::println);
    }
}

package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {
    private String temp;

    @Test
    void testA() {
        temp = "Yasir";
    }

    @Test
    void testB() {
        System.out.println(temp);
    }
}

package programmer.zaman.now.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

@Tag("integration-test")
public class ConditionTest {
    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": \t" + value));
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyWindows() {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    void testEnabledOnJava8() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    void testDisabledOnJava8() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_22)
    void testEnabledOnJava11To22() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_22)
    void testDisabledOnJava11To22() {

    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnableOnJavaVendorOracle() {

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisabledOnJavaVendorOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisabledOnProfileDev() {

    }
}

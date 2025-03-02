package iyytechnology.lambda.app;

import iyytechnology.lambda.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceApp {
    public static void main(String[] args) {
        // Predicate<String> predicateIsLowerCase = value -> StringUtil.isLowerCase(value);
        Predicate<String> predicateIsLowerCase = StringUtil::isLowerCase;

        System.out.println(predicateIsLowerCase.test("yasir"));
        System.out.println(predicateIsLowerCase.test("Yasir"));

        // method reference di parameter
        // Function<String, String> functionUpper = value -> value.toUpperCase();
        Function<String, String> functionUpper = String::toUpperCase;

        System.out.println(functionUpper.apply("Yasir"));
    }

    public void run() {
        // Predicate<String> predicateIsLowerCase = value -> MethodReferenceApp.this.isLowerCase(value);
        Predicate<String> predicateIsLowerCase = this::isLowerCase;

        System.out.println(predicateIsLowerCase.test("yasir"));
        System.out.println(predicateIsLowerCase.test("Yasir"));
    }

    public void run2() {
        MethodReferenceApp app = new MethodReferenceApp();
        Predicate<String> predicateIsLowerCase = app::isLowerCase;

        System.out.println(predicateIsLowerCase.test("yasir"));
        System.out.println(predicateIsLowerCase.test("Yasir"));
    }

    public boolean isLowerCase(String value) {
        for (var c : value.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}

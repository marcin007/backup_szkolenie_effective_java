package com.for_comprehension.function.l6_template_method;

import java.time.Instant;

class L6_TemplateMethodModern {

    public static void main(String[] args) {
//        runWithLogging(() -> process(42));

        String result = timed(() -> process("foo"));
        // zalogować: execution time: xxx ms
    }

    static void runWithLogging(Runnable runnable) {
        System.out.println(STR."entering method at: \{Instant.now()}");
        runnable.run();
        System.out.println(STR."exiting method at: \{Instant.now()}");
    }

    private static String process(String input) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return input.toUpperCase();
    }
}

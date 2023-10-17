package com.for_comprehension.function.l6_template_method;

import java.time.Instant;

class L6_TemplateMethodClassic {

    public static void main(String[] args) {
        new ProcessWithLogging(42).run();
    }

    static class ProcessWithLogging extends WithLogging {

        private final int input;

        ProcessWithLogging(int input) {
            this.input = input;
        }

        @Override
        void runInternal() {
            process(input);
        }
    }

    static abstract class WithLogging {
        abstract void runInternal();

        void run() {
            System.out.println(STR."entering method at: \{Instant.now()}");
            runInternal();
            System.out.println(STR."exiting method at: \{Instant.now()}");
        }
    }

    private static <T> T process(T input) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return input;
    }
}

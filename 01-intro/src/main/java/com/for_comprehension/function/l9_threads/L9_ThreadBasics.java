package com.for_comprehension.function.l9_threads;

class L9_ThreadBasics {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            System.out.println("Hello from " + Thread.currentThread().getName());
        });
        thread.start();
//        thread.run(); RUNS ON MAIN!

    }
}

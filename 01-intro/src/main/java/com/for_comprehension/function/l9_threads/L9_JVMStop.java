package com.for_comprehension.function.l9_threads;

class L9_JVMStop {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(60_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.setDaemon(true); // JVM stops when all non-daemon threads complete
        thread.start();
    }
}

package com.for_comprehension.function.l1_optional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class L0_StackTraceDrop {
    /*
    java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "foo" is null
	at com.for_comprehension.function.l1_optional.L4_StackTraceDrop.lambda$main$0(L4_StackTraceDrop.java:16)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "foo" is null
	at com.for_comprehension.function.l1_optional.L4_StackTraceDrop.lambda$main$0(L4_StackTraceDrop.java:16)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "foo" is null
	at com.for_comprehension.function.l1_optional.L4_StackTraceDrop.lambda$main$0(L4_StackTraceDrop.java:16)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "foo" is null
	at com.for_comprehension.function.l1_optional.L4_StackTraceDrop.lambda$main$0(L4_StackTraceDrop.java:16)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "foo" is null
	at com.for_comprehension.function.l1_optional.L4_StackTraceDrop.lambda$main$0(L4_StackTraceDrop.java:16)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "foo" is null
	at com.for_comprehension.function.l1_optional.L4_StackTraceDrop.lambda$main$0(L4_StackTraceDrop.java:16)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)

	*********JVM DROPS STACKTRACES******************
java.lang.NullPointerException
java.lang.NullPointerException
java.lang.NullPointerException
java.lang.NullPointerException
java.lang.NullPointerException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        while (true) {
            Thread.sleep(1);
            executorService.submit(() -> {
                try {
                    String foo = null;
                    foo.toUpperCase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

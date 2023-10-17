package com.for_comprehension.function.l2_generics;

import java.util.ArrayList;
import java.util.List;

class L2_GenericTypeCapture {

    public static void main(String[] args) {
        // generics are not stored at runtime
        List<Integer> ints = new ArrayList<>();

        // generics imprinted into class definition
        OurParameterizedTypeReference<List<String>> ref = new OurParameterizedTypeReference<>() {
        };


        System.out.println(ref.getClass().getGenericSuperclass().getTypeName());
        System.out.println(ints.getClass().getGenericSuperclass());
    }

    static class ListStringTypeRef extends OurParameterizedTypeReference<List<String>> {

    }

    abstract static class OurParameterizedTypeReference<T> {
    }
}

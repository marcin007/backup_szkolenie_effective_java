package com.for_comprehension.function.l2_generics;

class L2_MarkerInterfaces {

    public static void main(String[] args) {

        Map map = new Map();

        if (map instanceof RandomAccess ra) {
        }
    }

    static class Map implements RandomAccess {

    }

    // marker interfaces
    interface RandomAccess {

    }
}

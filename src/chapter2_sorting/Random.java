package chapter2_sorting;

import StdLib.StdRandom;

public class Random {
    public static Integer[] getRandom(int N, int T) {
        Integer[] a = new Integer[100];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform(T);
            }
        }
        return a;
    }
}

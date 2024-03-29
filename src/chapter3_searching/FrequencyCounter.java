package chapter3_searching;

import StdLib.ST;
import StdLib.StdIn;
import StdLib.StdOut;



public class FrequencyCounter {
    public static void main(String[] args) {
        // 命令行参数表示了表中键的最短长度
        int minLen = Integer.parseInt(args[0]);
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen) {
                continue;
            }
            if (st.get(word) == null) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }
        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}

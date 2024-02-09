package chapter3_searching;

import chapter1_fundamentals.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        // 二分查找
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        // 在put方法中，i代表的是要插入元素的位置，即当前键值对在键数组中的索引。当i < N时，表示要插入的键在已有的键的范围内，所以可以直接将
        // 对应位置的vals[i]赋值为新的值val。
        // 这是因为在put方法中，首先会通过rank方法找到要插入的位置i。如果i小于当前键值对的数量N，意味着键数组中已经存在相同的键，此时只需要
        // 更新对应位置的值即可，而不需要插入新的键值对。
        // 对于i > N的情况，这意味着要插入的键超出了当前键值对的范围，需要将新的键值对添加到键数组的末尾，并增加键值对的数量N。
        // 所以，在put方法中，i < N时表示更新已有键值对，而i > N时表示添加新的键值对。
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
        assert check();
    }

    /**
     * Exercise 3.1.16
     *
     * @param key
     */
    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            N--;
            keys[N] = null;
            vals[N] = null;
        }
        assert check();
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * Exercise 3.1.17
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i < N) {
            if (keys[i].compareTo(key) == 0) {
                return key;
            } else if (i > 0) {
                return keys[i - 1];
            }
        }
        return null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    // Add for Exercise 3.1.29
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    // Exercise 3.1.30
    private boolean check() {
        return isSorted() && rankCheck();
    }

    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            }
        }
        return true;
    }
}
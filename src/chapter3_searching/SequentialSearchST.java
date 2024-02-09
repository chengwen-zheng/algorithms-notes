package chapter3_searching;

import chapter1_fundamentals.Queue;

public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N = 0;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    /**
     *  如果找到了具有相同键的节点，就更新该节点的值为新的值 val，然后返回。
     *  如果遍历完整个链表都没有找到具有相同键的节点，就创建一个新的节点，并将其作为链表的开头，然后更新 first 的引用指向新的节点。
     *  最后，增加链表中节点的数量 N。
    */
    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    // Exercise 3.1.5
    public int size() {
        return N;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

   /**
    首先，判断当前节点 x 是否为空。如果为空，说明已经遍历完整个链表，但没有找到具有指定键的节点，所以直接返回 null。
    接下来，判断当前节点 x 的键是否与指定的键 key 相等。如果相等，说明找到了要删除的节点。在这种情况下，先将节点数量 N 减1，
    然后返回当前节点的下一个节点 x.next，从而将当前节点从链表中删除。
    如果当前节点 x 不为空且键不相等，则递归调用 delete 方法，将其应用于当前节点的下一个节点 x.next 和指定的键 key。
    这样可以继续在链表中寻找具有指定键的节点。
    最后，将递归调用的结果赋值给当前节点的 next 引用，来更新节点之间的连接关系。然后返回当前节点 x。
    */
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (x.key.equals(key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}
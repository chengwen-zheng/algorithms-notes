# 查找

1. 符号表是可以存储信息的表格。存储键值对，支持put(插入)和get(查找)。
2. 三种经典的数据类型可以实现符号表：二叉查找数，红黑树，散列表。
3. 普通的符号表设计，[见代码](https://github.com/chengwen-zheng/algorithms-notes/blob/master/src/StdLib/ST.java)
    [ST test](https://github.com/chengwen-zheng/algorithms-notes/blob/master/src/chapter3_searching/FrequencyCounter.java)
4. 键的等价性。java中维护所有的Comparable类型中compareTo方法和equals()方法的一致性。即a.compareTo(b) == 0和 a.equals(b)相等。
5. 有序的符号表设计，[见代码](https://github.com/chengwen-zheng/algorithms-notes/blob/master/src/chapter3_searching/ArrayST.java)
6. 无序的符号表设计，[见代码](https://github.com/chengwen-zheng/algorithms-notes/blob/master/src/chapter3_searching/SequentialSearchST.java)
7. 基于有序数组的二分查找符号表，[见代码](https://github.com/chengwen-zheng/algorithms-notes/blob/master/src/chapter3_searching/BinarySearchST.java)
8. 二叉查找树定义：是一颗二叉树，其中每个结点都含有一个Comparable的键(以及相关联的值)，且每个结点的键都大于其左子树中的任意结点的键而小于右子
树的任意结点。
9. 二叉查找树设计，[见代码](https://github.com/chengwen-zheng/algorithms-notes/blob/master/src/chapter3_searching/BST.java)
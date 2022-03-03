package com.helsing.leetcode.note.structure.unionfind;

/**
 * 并查集是一种数据结构
 * 可以用于解决图的连通性
 *
 * @author HelSing
 * @date 2021/11/18
 */
public class Struct_UnionFind {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
    }

    //数组模拟树，实现并查集。数组内的元素代表老大的索引值，相当于指针。
    public static class UnionFind {
        //数组，表示并查集所有元素
        private int[] parent;
        //并查集的元素个数
        private int size;
        //记录树的重量
        private int[] weight;

        //初始化并查集
        public UnionFind(int size) {
            this.size = size;
            //一开始互不相通，每个并查集都指向自己
            parent = new int[size];
            weight = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1; //重量初始化为1
            }
        }

        /**
         * 查看元素所属于哪个集合
         *
         * @param element 要查看的元素
         * @return element元素所在的集合
         */
        private int find(int element) {
            while (element != parent[element]) {
                //进行路径压缩
                parent[element] = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        /**
         * 判断两个元素是否同属于一个集合
         *
         * @param firstElement  第一个元素
         * @param secondElement 第二个元素
         * @return <code>boolean</code> 如果是则返回true。
         */
        public boolean isConnected(int firstElement, int secondElement) {
            return find(firstElement) == find(secondElement);
        }

        /**
         * 合并两个元素所在的集合，也就是连接两个元素
         *
         * @param firstElement  第一个元素
         * @param secondElement 第二个元素
         */
        public void union(int firstElement, int secondElement) {
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);
            if (firstRoot == secondRoot) {
                return;
            }
            parent[firstRoot] = secondRoot;
        }
    }
}

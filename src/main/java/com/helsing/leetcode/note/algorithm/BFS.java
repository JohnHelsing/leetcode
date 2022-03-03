package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.editor.cn.Q0111_MinimumDepthOfBinaryTree;
import com.helsing.leetcode.editor.cn.Q0752_OpenTheLock;

/**
 * 广度优先搜索
 * Breadth First Search
 * BFS选取状态用队列的形式，先进先出。
 * <p>
 * BFS 找到的路径一定是最短的，但代价就是空间复杂度可能比 DFS 大很多
 * 写 BFS 算法都是用「队列」这种数据结构，每次将一个节点周围的所有节点加入队列。
 * <p>
 * 广度搜索
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class BFS {

    public static void main(String[] args) {
        
    }

    /**
     * 问题的本质就是让你在一幅「图」中找到从起点 start 到终点 target 的最近距离，
     * 这个例子听起来很枯燥，但是 BFS 算法问题其实都是在干这个事儿
     */
    private void think() {

    }

    private void template() {
        String template = """
                // 计算从起点 start 到终点 target 的最近距离
                int BFS(Node start, Node target) {
                    Queue<Node> q; // 核心数据结构
                    Set<Node> visited; // 避免走回头路
                    
                    q.offer(start); // 将起点加入队列
                    visited.add(start);
                    int step = 0; // 记录扩散的步数
                                
                    while (q not empty) {
                        int sz = q.size();
                        /* 将当前队列中的所有节点向四周扩散 */
                        for (int i = 0; i < sz; i++) {
                            Node cur = q.poll();
                            /* 划重点：这里判断是否到达终点 */
                            if (cur is target){
                                return step;
                            }
                            /* 将 cur 的相邻节点加入队列 */
                            for (Node x : cur.adj()) {
                                if (x not in visited) {
                                    q.offer(x);
                                    visited.add(x);
                                }
                            }
                        }
                        /* 划重点：更新步数在这里 */
                        step++;
                    }
                }
                """;
    }

    private void etc() {
        // 二叉树的最小深度
        Q0111_MinimumDepthOfBinaryTree.main(null);

        // 打开转盘锁
        Q0752_OpenTheLock.main(null);

    }
}

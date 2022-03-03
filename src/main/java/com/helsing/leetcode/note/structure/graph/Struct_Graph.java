package com.helsing.leetcode.note.structure.graph;

import com.helsing.leetcode.note.algorithm.Tarjan;

/**
 * 图
 *
 * @author HelSing
 * @date 2021/11/15
 */
public class Struct_Graph {
    public static void main(String[] args) {

    }

    /**
     * 图(graph)是一种比较松散的数据结构。
     * 它有一些节点(vertice)，在某些节点之间，由边(edge)相连。
     * 节点的概念在树中也出现过，我们通常在节点中储存数据。
     * 边表示两个节点之间的存在关系。
     * 在树中，我们用边来表示子节点和父节点的归属关系。
     * 树是一种特殊的图，但限制性更强一些。
     */
    public void graph() {

    }

    /**
     * Tarjan算法求割点
     */
    public void tarjan() {
        Tarjan tarjan = new Tarjan();
    }

    /**
     * Hierholzer算法找欧拉回路
     * <p>
     * 这种「一笔画」问题与欧拉图或者半欧拉图有着紧密的联系，下面给出定义：
     * 通过图中所有边恰好一次且行遍所有顶点的通路称为欧拉通路。
     * 通过图中所有边恰好一次且行遍所有顶点的回路称为欧拉回路。
     * 具有欧拉回路的无向图称为欧拉图。
     * 具有欧拉通路但不具有欧拉回路的无向图称为半欧拉图。
     */
    public void hierholzer() {
        /**
         * 如果没有保证至少存在一种合理的路径，我们需要判别这张图是否是欧拉图或者半欧拉图，具体地：
         * 对于无向图 GG，GG 是欧拉图当且仅当 GG 是连通的且没有奇度顶点。
         * 对于无向图 GG，GG 是半欧拉图当且仅当 GG 是连通的且 GG 中恰有 22 个奇度顶点。
         * 对于有向图 GG，GG 是欧拉图当且仅当 GG 的所有顶点属于同一个强连通分量且每个顶点的入度和出度相同。
         * 对于有向图 GG，GG 是半欧拉图当且仅当 GG 的所有顶点属于同一个强连通分量且
         * 恰有一个顶点的出度与入度差为 11；
         * 恰有一个顶点的入度与出度差为 11；
         * 所有其他顶点的入度和出度相同。
         */
        boolean isEuler = true;

        /**
         * Hierholzer 算法用于在连通图中寻找欧拉路径，其流程如下：
         * 从起点出发，进行深度优先搜索。
         * 每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
         * 如果没有可移动的路径，则将所在节点加入到栈中，并返回。
         */
    }
}

package com.helsing.leetcode.util;

import java.io.File;
import java.util.*;

/**
 * @author HelSing
 * @date 2021/11/12
 */
public class Report {

    private int total = 2422;
    private int solved = 0;

    private Map<String, int[]> tagsMap;

    public boolean init() {
        tagsMap = new LinkedHashMap<>();
        for (String s : STATIC_STR.split("\n")) {
            String[] cols = s.trim().split("\t");
            int[] nums = new int[2];
            nums[0] = Integer.parseInt(cols[1]);
            tagsMap.put(cols[0], nums);
        }
        String javaSourceDir = "D:\\workspace\\LeetCode\\src\\main\\java\\com\\helsing\\leetcode\\editor\\cn";
        File dir = new File(javaSourceDir);
        if (!dir.exists()) {
            System.out.println("目录不存在!");
        }
        File[] fileList = dir.listFiles((d, name) -> name.contains(".java"));
        solved = fileList.length;
        for (File file : fileList) {
            try (Scanner scan = new Scanner(file, "utf-8");) {
                String tempLine;
                while ((tempLine = scan.nextLine()) != null) {
                    if (tempLine.startsWith("// Related Topics ")) {
                        String[] cols = tempLine.trim().split("\\s+");
                        for (int i = 3; i < cols.length; i++) {
                            int[] nums = tagsMap.getOrDefault(cols[i], new int[2]);
                            nums[1]++;
                            tagsMap.put(cols[i], nums);
                        }
                    }
                }
            } catch (Exception ex) {
                continue;
            }
        }
        return true;
    }

    public void print() {
        System.out.println("做题进度统计如下:");
        System.out.println(String.format("解决数/总数：(%d%%)  %d/%d",
                Math.round(solved * 100 / total), solved, total));
        System.out.println("---------\n详情如下：");
        List<Map.Entry<String, int[]>> entryList = new ArrayList<>(tagsMap.entrySet());
        entryList.sort(Comparator.comparingInt(o -> o.getValue()[0]));
        for (Map.Entry<String, int[]> tag : entryList) {
            int[] v = tag.getValue();
            String name = tag.getKey();
            name = name.replaceAll("（", "(").replaceAll("）", ")");
            String split = name.length() < 4 || name.equals("Shell") ? "\t\t" : "\t";
            if (name.length() == 1) {
                split = "\t\t\t";
            }
            System.out.println(String.format("%s:%s(%d%%)\t%03d/%03d", name, split,
                    v[0] == 0 ? 100 : Math.round(v[1] * 100 / v[0]), v[1], v[0]));
        }
    }

    public static void main(String[] args) {
        Report report = new Report();
        if (report.init()) {
            report.print();
        } else {
            System.out.println("初始化失败！");
        }
    }


    public String STATIC_STR = "栈\t141\n" +
            "单调栈\t45\n" +
            "堆（优先队列）\t116\n" +
            "队列\t37\n" +
            "单调队列\t10\n" +
            "优先队列\t115\n" +
            "树状数组\t19\n" +
            "矩阵\t172\n" +
            "字符串\t556\n" +
            "数组\t1124\n" +
            "图\t94\n" +
            "树\t215\n" +
            "字典树\t49\n" +
            "线段树\t25\n" +
            "二叉树\t196\n" +
            "二叉搜索树\t54\n" +
            "最小生成树\t5\n" +
            "有序集合\t41\n" +
            "并查集\t66\n" +
            "哈希表\t404\n" +
            "链表\t92\n" +
            "双向链表\t11\n" +
            "欧拉回路\t2\n" +
            "扫描线\t4\n" +
            "数据流\t20\n" +
            "数据库\t179\n" +
            "基数排序\t2\n" +
            "计数排序\t6\n" +
            "桶排序\t8\n" +
            "归并排序\t11\n" +
            "拓扑排序\t25\n" +
            "排序\t249\n" +
            "哈希函数\t22\n" +
            "计数\t67\n" +
            "模拟\t81\n" +
            "分治\t51\n" +
            "递归\t60\n" +
            "回溯\t109\n" +
            "滑动窗口\t73\n" +
            "位运算\t151\n" +
            "双指针\t174\n" +
            "二分查找\t186\n" +
            "动态规划\t409\n" +
            "后缀数组\t5\n" +
            "前缀和\t76\n" +
            "最短路\t14\n" +
            "字符串匹配\t18\n" +
            "记忆化搜索\t33\n" +
            "广度优先搜索\t228\n" +
            "深度优先搜索\t282\n" +
            "拒绝采样\t2\n" +
            "水塘抽样\t4\n" +
            "随机化\t14\n" +
            "概率与统计\t9\n" +
            "数论\t10\n" +
            "博弈\t23\n" +
            "设计\t131\n" +
            "数学\t387\n" +
            "双连通分量\t1\n" +
            "强连通分量\t2\n" +
            "多线程\t9\n" +
            "迭代器\t10\n" +
            "快速选择\t10\n" +
            "组合数学\t13\n" +
            "滚动哈希\t14\n" +
            "交互\t18\n" +
            "枚举\t24\n" +
            "几何\t32\n" +
            "Shell\t4\n" +
            "贪心\t215\n" +
            "脑筋急转弯\t10\n" +
            "状态压缩\t33";
}

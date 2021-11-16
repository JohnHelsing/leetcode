package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 各种排序算法：
 * 名称      |    时间复杂度   平均/最好/最坏     |  空间复杂度 | 稳定性
 * ---------------------------------------------------------------
 * 选择排序     O(n^2)   / O(n^2)   / O(n^2)        O(1)       否
 * 冒泡排序     O(n^2)   / O(n)     / O(n^2)        O(1)       是
 * 插入排序     O(n^2)   / O(n)     / O(n^2)        O(1)       是
 * 希尔排序     O(nlogn) / O(n^4/3) / O(n^4/3)      O(1)       是
 * 快速排序     O(nlogn) / O(nlogn) / O(n^2)       O(logn)     否
 * 归并排序     O(nlogn) / O(nlogn) / O(nlogn)      O(n)       是
 * 基数排序     O(nk/d)  / -        / O(nk/d)       n+2^d      是
 * 计数排序     O(n+r)   / -        / O(n+r)        O(n+r)     是
 * 桶排序       O(n+r)   / -        / O(n+r)        O(n+r)     是
 * 堆排序       O(nlogn) / O(nlogn) / O(nlogn)      O(1)       是
 * Tim排序      O(nlogn) / O(n)     / O(nlogn)      O(n)       是
 * 二叉树排序    O(nlogn) / O(nlogn) / O(n^2)        O(n)       是
 *
 * @author HelSing
 * @date 2021/11/15
 */
public class Sort {

    /**
     * 选择排序
     * 先找到前n个元素中最大的值，然后和最后一个元素交换。
     * 这样保证最后一个元素一定是最大的，然后找到前n-1个元素中的最大值，和第n-1个元素进行交换
     * 然后找到前n-2个元素中最大值，和第n-2个元素交换，依次类推到第2个元素，这样就得到了最后的排序数组。
     *
     * @param nums
     * @return
     */
    public int[] selectSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            // 最大元素的位置
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            // 把这个最大的元素移到最后
            swap(nums, maxIndex, i);
        }
        return nums;
    }

    /**
     * 冒泡排序
     * 冒泡排序是从左到右依次比较相邻的两个元素，如果前一个元素比较大，就把前一个元素和后一个交换位置
     * 遍历数组之后保证最后一个元素相对于前面的永远是最大的。
     * 然后让最后一个保持不变，重新遍历前n-1个元素，保证第n-1个元素在前n-1个元素里面是最大的。
     * 依此规律直到第2个元素是前2个元素里面最大的，排序就结束了。
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        // 冒泡得到n-1个最大值
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    // 交换得到较大值
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    /**
     * 插入排序
     * 插入排序的核心思想是遍历整个数组，保持当前元素左侧始终是排序后的数组，
     * 然后将当前元素插入到前面排序完成的数组的对应的位置，使其保持排序状态。
     * 有点动态规划的感觉，类似于先把前i-1个元素排序完成，再插入第i个元素，构成i个元素的有序数组。
     *
     * @param nums
     */
    public void insertSort(int[] nums) {
        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            // 将当前元素移动到合适的位置
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }

    /**
     * 希尔排序
     * 希尔排序可以看作是一个冒泡排序或者插入排序的变形。
     * 希尔排序在每次的排序的时候都把数组拆分成若干个序列，一个序列的相邻的元素索引相隔的固定的距离gap，
     * 每一轮对这些序列进行冒泡或者插入排序，然后再缩小gap得到新的序列一一排序，直到gap为0
     */
    public void shellSort(int[] nums) {
        int gap = nums.length >> 1;
        while (gap > 0) {
            // 对每个子序列进行排序
            for (int i = 0; i < gap; i++) {
                // 插入排序的部分
                for (int j = i + gap; j < nums.length; j += gap) {
                    int temp = j;
                    while (temp > i && nums[temp] < nums[temp - gap]) {
                        swap(nums, temp, temp - gap);
                        temp -= gap;
                    }
                }
            }
            gap >>= 1;
        }
    }

    /**
     * 快速排序
     * 快速排序（有时称为分区交换排序）是一种高效的排序算法。
     * 由英国计算机科学家Tony Hoare于1959年开发并于1961年发表，它在现在仍然是一种常用的排序算法。
     * 如果实现方法恰当，它可以比主要竞争对手（归并排序和堆排序）快两到三倍。
     * <p>
     * 其核心的思路是取第一个元素（或者最后一个元素）作为分界点，把整个数组分成左右两侧，左边的元素小于或者等于分界点元素，
     * 而右边的元素大于分界点元素，然后把分界点移到中间位置，对左右子数组分别进行递归，最后就能得到一个排序完成的数组。
     * 当子数组只有一个或者没有元素的时候就结束这个递归过程。
     * 其中最重要的是将整个数组根据分界点元素划分成左右两侧的逻辑，目前有两种算法
     *
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 小于分界点元素的最右侧的指针
        int lo = left + 1;
        // 大于分界点元素的最左侧的指针
        int hi = right;
        while (lo <= hi) {
            // 交换元素确保左侧指针指向元素小于分界点元素
            if (nums[lo] > nums[left]) {
                swap(nums, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }
        // 回到小于分界点元素数组的最右侧
        lo--;
        // 将分界点元素移到左侧数组最右侧
        swap(nums, left, lo);
        quickSort1(nums, left, lo - 1);
        quickSort1(nums, lo + 1, right);
    }

    public void quickSort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 从左侧第二个元素开始
        int cur = left + 1;
        // 分界点为第一个元素
        int lo = left;
        while (cur <= right) {
            // 交换位置保证lo的左侧都是小于num[left]
            if (nums[cur] <= nums[left]) {
                swap(nums, lo + 1, cur);
                lo++;
            }
            cur++;
        }
        // 把分界点元素移动到新的分界位置
        swap(nums, left, lo);
        quickSort2(nums, left, lo - 1);
        quickSort2(nums, lo + 1, right);
    }

    /**
     * 归并排序
     * 归并排序是典型的使用分治思想（divide-and-conquer）解决问题的案例。
     * <p>
     * 在排序的过程中，把原来的数组变成左右两个数组，然后分别进行排序，当左右的子数组排序完毕之后，
     * 再合并这两个子数组形成一个新的排序数组。整个过程递归进行，当只剩下一个元素或者没有元素的时候就直接返回。
     * <p>
     * 需要左右边界确定排序范围
     *
     * @param nums
     */
    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // 先对左右子数组进行排序
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 临时数组存放合并结果
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int cur = 0;
        // 开始合并数组
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[cur] = nums[i++];
            } else {
                temp[cur] = nums[j++];
            }
            cur++;
        }
        while (i <= mid) {
            temp[cur++] = nums[i++];
        }
        while (j <= right) {
            temp[cur++] = nums[j++];
        }
        // 合并数组完成，拷贝到原来的数组中
        for (int k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }

    /**
     * 堆排序是一个效率要高得多的选择排序，首先把整个数组变成一个最大堆，然后每次从堆顶取出最大的元素，
     * 这样依次取出的最大元素就形成了一个排序的数组。堆排序的核心分成两个部分，第一个是新建一个堆，第二个是弹出堆顶元素后重建堆。
     * <p>
     * 新建堆不需要额外的空间，而是使用原来的数组，一个数组在另一个维度上可以当作一个完全二叉树
     * （除了最后一层之外其他的每一层都被完全填充，并且所有的节点都向左对齐），对于下标为i的元素，
     * 他的子节点是2*i+1和2*i+2（前提是没有超出边界）。在新建堆的时候从左向右开始遍历，当遍历到一个元素的时候，
     * 重新排列从这个元素节点到根节点的所有元素，保证满足最大堆的要求（父节点比子节点要大）。
     * 遍历完整个数组的时候，这个最大堆就完成了。
     * <p>
     * 在弹出根节点之后（把根节点的元素和树的最底层最右侧的元素互换），堆被破坏，需要重建。
     * 从根节点开始和两个子节点比较，如果父节点比最大的子节点小，那么就互换父节点和最大的子节点，
     * 然后把互换后在子节点位置的父节点当作新的父节点，和它的子节点比较，如此往复直到最后一层，这样最大堆就重建完毕了。
     *
     * @param nums
     */
    private void heapSort(int[] nums) {
        // 新建一个最大堆
        heapify(nums);
        for (int i = nums.length - 1; i >= 1; i--) {
            // 弹出最大堆的堆顶放在最后
            swap(nums, 0, i);
            // 重建最大堆
            rebuildHeap(nums, 0, i - 1);
        }
    }

    private void heapify(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 找到父节点
            int par = (i - 1) >> 1;
            // 定义子节点
            int child = i;
            // 从子节点到根节点构建最大堆
            while (child > 0 && nums[par] < nums[child]) {
                swap(nums, par, child);
                child = par;
                par = (par - 1) >> 1;
            }
        }
    }

    private void rebuildHeap(int[] nums, int par, int last) {
        // 左子节点
        int left = 2 * par + 1;
        // 右子节点
        int right = 2 * par + 2;
        int maxIndex = left;
        // 找到最大子节点
        if (right <= last && nums[right] > nums[left]) {
            maxIndex = right;
        }
        // 和最大子节点比较
        if (left <= last && nums[par] < nums[maxIndex]) {
            // 互换到最大子节点
            swap(nums, par, maxIndex);
            // 重建最大子节点代表的子树
            rebuildHeap(nums, maxIndex, last);
        }
    }

    /**
     * 桶排序
     * 桶排序是将所有的元素分布到一系列的区间（也可以称之为桶）里面，
     * 然后对每个桶里面的所有元素分别进行排序的算法。
     * <p>
     * 首先新建一个桶的数组，每个桶的规则需要提前制定好，
     * 比如元素在0~9为一个桶、10~19为一个桶。然后遍历整个待排序的数组，把元素分配到对应的桶里面。
     * 接下来单独对每个桶里面的元素进行排序，排序算法可以选择比较排序或者非比较排序，得到排序后的数组。
     * 最后把所有的桶内的元素还原到原数组里面得到最后的排序数组。
     *
     * @param nums
     */
    private void bucketSort(int[] nums) {
        // 定义桶的大小
        int INTERVAL = 100;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 找到数组元素的范围
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // 计算出桶的数量
        int count = (max - min + 1);
        int bucketSize = (count % INTERVAL == 0) ? (count / INTERVAL) : (count / INTERVAL + 1);
        List<Integer>[] buckets = new List[bucketSize];
        // 把所有元素放入对应的桶里面
        for (int num : nums) {
            int quotient = (num - min) / INTERVAL;
            if (buckets[quotient] == null) {
                buckets[quotient] = new ArrayList<>();
            }
            buckets[quotient].add(num);
        }
        int cur = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket != null) {
                // 对每个桶进行排序
                bucket.sort(null);
                // 还原桶里面的元素到原数组
                for (Integer integer : bucket) {
                    nums[cur++] = integer;
                }
            }
        }
    }

    /**
     * 计数排序
     * <p>
     * 计数排序是一个最基本的非比较排序，能够将时间复杂度提高到O(n)O(n)的水平，但是使用上比较有局限性，
     * 通常只能应用在键的变化范围比较小的情况下，如果键的变化范围特别大，建议使用基数排序。
     * <p>
     * 计数排序的过程是创建一个长度为数组中最小和最大元素之差的数组，分别对应数组中的每个元素，
     * 然后用这个新的数组来统计每个元素出现的频率，然后遍历新的数组，
     * 根据每个元素出现的频率把元素放回到老的数组中，得到已经排好序的数组。
     *
     * @param nums
     */
    public void countSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 找到最大最小值
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // 建立新数组
        int[] count = new int[max - min + 1];
        // 统计每个元素出现频率
        for (int num : nums) {
            count[num - min]++;
        }
        int cur = 0;
        // 根据出现频率把计数数组中的元素放回到旧数组中
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[cur++] = i + min;
                count[i]--;
            }
        }
    }

    /**
     * 基数排序
     * <p>
     * 基数排序和桶排序有点相似，基数排序中需要把元素送入对应的桶中，
     * 不过规则是根据所有数字的某一位上面的数字来分类。
     * <p>
     * 假设当前数组的所有元素都是正数，桶的数量就固定在了10个，然后计算出最大元素的位数。
     * 首先根据每个元素的最低位进行分组，比如1就放入1这个桶，13就放入3这个桶，111也放入1这个桶，
     * 然后把所有的数字根据桶的顺序取出来，依次还原到原数组里面。
     * 在第二轮从第二位开始分组，比如1（看作01）放入0这个桶，13放入1这个桶，111也放入1这个桶，
     * 再把所有的元素从桶里面依次取出放入原数组。
     * 经过最大元素位数次的这样的操作之后，还原得到的数组就是一个已经排好序的数组。
     *
     * @param nums
     */
    public void radixSort(int[] nums) {
        int max = -1;
        int min = 1;
        // 计算最大最小值
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 求得绝对值最大的值
        max = Math.max(max, -min);
        int digits = 0;
        // 计算绝对值最大的值的位数
        while (max > 0) {
            max /= 10;
            digits++;
        }
        // 建一个包含所有位数的数组
        List<Integer>[] buckets = new List[19];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        int pos;
        int cur;
        // 对十进制每一位进行基数排序
        for (int i = 0, mod = 1; i < digits; i++, mod *= 10) {
            // 扫描数组将值放入对应的桶
            for (int num : nums) {
                pos = (num / mod) % 10;
                buckets[pos + 9].add(num);
            }
            cur = 0;
            // 将桶内元素放回到数组里面
            for (List<Integer> bucket : buckets) {
                if (bucket != null) {
                    for (Integer integer : bucket) {
                        nums[cur++] = integer;
                    }
                    // 将桶清空
                    bucket.clear();
                }
            }
        }
    }

    /**
     * 二叉树排序
     * <p>
     * 二叉树搜索排序用数组内的所有元素构建一个搜索二叉树，
     * 然后用中序遍历重新将所有的元素填充回原来的数组中。
     * 因为搜索二叉树不能用数组来表示，所以必须使用额外的数据结构来构建二叉树。
     */
    private int[] bstSort(int[] nums) {
        // 构建根节点
        TreeNode root = new TreeNode(nums[0]);
        // 将所有的元素插入到二叉搜索树中
        for (int i = 1; i < nums.length; i++) {
            buildTree(root, nums[i]);
        }
        // 中序遍历获取二叉树中的所有节点
        inorderTraversal(root, nums, new int[1]);
        return nums;
    }

    private void inorderTraversal(TreeNode node, int[] nums, int[] pos) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nums, pos);
        nums[pos[0]++] = node.val;
        inorderTraversal(node.right, nums, pos);
    }

    private void buildTree(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        // 插入到右子树中
        if (num >= node.val) {
            if (node.right == null) {
                node.right = new TreeNode(num);
            } else {
                buildTree(node.right, num);
            }
        } else {
            // 插入到左子树中
            if (node.left == null) {
                node.left = new TreeNode(num);
            } else {
                buildTree(node.left, num);
            }
        }
    }

    /**
     * Timsort是由Tim Peters在2002年实现的，自Python 2.3以来，它一直是Python的标准排序算法。
     * Java在JDK中使用Timsort对非基本类型进行排序。
     * Android平台和GNU Octave还将其用作默认排序算法。
     * <p>
     * Timsort是一种稳定的混合排序算法，同时应用了二分插入排序和归并排序的思想，
     * 在时间上击败了其他所有排序算法。
     * 它在最坏情况下的时间复杂度为O(nlogn)O(nlogn)优于快速排序；最佳情况的时间复杂度为O(n)O(n)，优于归并排序和堆排序。
     * <p>
     * 由于使用了归并排序，使用额外的空间保存数据，TimSort空间复杂度是O(n)O(n)
     *
     * @param nums
     */
    public void timSort(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * 辅助函数 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

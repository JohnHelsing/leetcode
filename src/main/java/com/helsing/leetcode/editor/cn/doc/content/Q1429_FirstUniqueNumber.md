<p>给定一系列整数，插入一个队列中，找出队列中第一个唯一整数。</p>

<p>实现 <code>FirstUnique</code> 类：</p>

<ul>
	<li><code>FirstUnique(int[] nums)</code> 用数组里的数字初始化队列。</li>
	<li><code>int showFirstUnique()</code> 返回队列中的<strong> 第一个唯一 </strong>整数的值。如果没有唯一整数，返回 -1。（译者注：此方法不移除队列中的任何元素）</li>
	<li><code>void add(int value)</code> 将 value 插入队列中。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>
["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]
<strong>输出：</strong>
[null,2,null,2,null,3,null,-1]
<strong>解释：</strong>
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // 返回 2
firstUnique.add(5);            // 此时队列为 [2,3,5,5]
firstUnique.showFirstUnique(); // 返回 2
firstUnique.add(2);            // 此时队列为 [2,3,5,5,2]
firstUnique.showFirstUnique(); // 返回 3
firstUnique.add(3);            // 此时队列为 [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // 返回 -1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>
["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
<strong>输出：</strong>
[null,-1,null,null,null,null,null,17]
<strong>解释：</strong>
FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
firstUnique.showFirstUnique(); // 返回 -1
firstUnique.add(7);            // 此时队列为 [7,7,7,7,7,7,7]
firstUnique.add(3);            // 此时队列为 [7,7,7,7,7,7,7,3]
firstUnique.add(3);            // 此时队列为 [7,7,7,7,7,7,7,3,3]
firstUnique.add(7);            // 此时队列为 [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17);           // 此时队列为 [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique(); // 返回 17
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>
["FirstUnique","showFirstUnique","add","showFirstUnique"]
[[[809]],[],[809],[]]
<strong>输出：</strong>
[null,809,null,-1]
<strong>解释：</strong>
FirstUnique firstUnique = new FirstUnique([809]);
firstUnique.showFirstUnique(); // 返回 809
firstUnique.add(809);          // 此时队列为 [809,809]
firstUnique.showFirstUnique(); // 返回 -1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10^5</code></li>
	<li><code>1 <= nums[i] <= 10^8</code></li>
	<li><code>1 <= value <= 10^8</code></li>
	<li>最多调用 <code>5000</code> 次 <code>showFirstUnique</code> 和 <code>add</code> 。</li>
</ul>
<div><div>Related Topics</div><div><li>设计</li><li>队列</li><li>数组</li><li>哈希表</li><li>数据流</li></div></div><br><div><li>👍 15</li><li>👎 0</li></div>
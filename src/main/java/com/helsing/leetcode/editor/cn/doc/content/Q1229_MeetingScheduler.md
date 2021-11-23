<p>你是一名行政助理，手里有两位客户的空闲时间表：<code>slots1</code> 和 <code>slots2</code>，以及会议的预计持续时间&nbsp;<code>duration</code>，请你为他们安排合适的会议时间。</p>

<p>「会议时间」是两位客户都有空参加，并且持续时间能够满足预计时间&nbsp;<code>duration</code> 的 <strong>最早的时间间隔</strong>。</p>

<p>如果没有满足要求的会议时间，就请返回一个 <strong>空数组</strong>。</p>

<p>&nbsp;</p>

<p>「空闲时间」的格式是&nbsp;<code>[start, end]</code>，由开始时间&nbsp;<code>start</code>&nbsp;和结束时间&nbsp;<code>end</code>&nbsp;组成，表示从&nbsp;<code>start</code>&nbsp;开始，到 <code>end</code>&nbsp;结束。&nbsp;</p>

<p>题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说，对于同一个人的两个空闲时间&nbsp;<code>[start1, end1]</code>&nbsp;和&nbsp;<code>[start2, end2]</code>，要么&nbsp;<code>start1 &gt; end2</code>，要么&nbsp;<code>start2 &gt; end1</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
<strong>输出：</strong>[60,68]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= slots1.length, slots2.length &lt;= 10^4</code></li>
	<li><code>slots1[i].length, slots2[i].length == 2</code></li>
	<li><code>slots1[i][0] &lt; slots1[i][1]</code></li>
	<li><code>slots2[i][0] &lt; slots2[i][1]</code></li>
	<li><code>0 &lt;= slots1[i][j], slots2[i][j] &lt;= 10^9</code></li>
	<li><code>1 &lt;= duration &lt;= 10^6&nbsp;</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 44</li><li>👎 0</li></div>
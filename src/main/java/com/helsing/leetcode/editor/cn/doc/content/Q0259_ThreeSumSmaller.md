<p>给定一个长度为 <em>n</em> 的整数数组和一个目标值<em> target</em>，寻找能够使条件&nbsp;<code>nums[i] + nums[j] + nums[k] &lt; target</code>&nbsp;成立的三元组&nbsp; <code>i, j, k</code>&nbsp;个数（<code>0 &lt;= i &lt; j &lt; k &lt; n</code>）。</p>

<p><strong>示例：</strong></p>

<pre><strong>输入: </strong><em>nums</em> = <code>[-2,0,1,3]</code>, <em>target</em> = 2
<strong>输出: </strong>2 
<strong>解释: </strong>因为一共有两个三元组满足累加和小于 2:
&nbsp;    [-2,0,1]
     [-2,0,3]
</pre>

<p><strong>进阶：</strong>是否能在&nbsp;<em>O</em>(<em>n</em><sup>2</sup>) 的时间复杂度内解决？</p>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 97</li><li>👎 0</li></div>
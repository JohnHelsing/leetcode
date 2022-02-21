<p>给你一种规律&nbsp;<code>pattern</code>&nbsp;和一个字符串&nbsp;<code>s</code>，请你判断&nbsp;<code>s</code>&nbsp;是否和<em>&nbsp;</em><code>pattern</code>&nbsp;的规律<strong>相匹配</strong>。</p>

<p>如果存在单个字符到字符串的 <strong>双射映射</strong> ，那么字符串<meta charset="UTF-8" />&nbsp;<code>s</code>&nbsp;匹配<meta charset="UTF-8" />&nbsp;<code>pattern</code>&nbsp;，即：如果<meta charset="UTF-8" /><code>pattern</code>&nbsp;中的每个字符都被它映射到的字符串替换，那么最终的字符串则为 <code>s</code> 。<strong>双射</strong> 意味着映射双方一一对应，不会存在两个字符映射到同一个字符串，也不会存在一个字符分别映射到两个不同的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>pattern = "abab", s = "redblueredblue"
<strong>输出：</strong>true
<strong>解释：</strong>一种可能的映射如下：
'a' -&gt; "red"
'b' -&gt; "blue"</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>pattern = "aaaa", s = "asdasdasdasd"
<strong>输出：</strong>true
<strong>解释：</strong>一种可能的映射如下：
'a' -&gt; "asd"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>pattern = "aabb", s = "xyzabcxzyabc"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= pattern.length, s.length &lt;= 20</code></li>
	<li><code>pattern</code> 和 <code>s</code> 由小写英文字母组成</li>
</ul>
<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 71</li><li>👎 0</li></div>
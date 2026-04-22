<h2><a href="https://www.geeksforgeeks.org/problems/range-sum-queries2353/1">Range Sum Queries</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">You are given an array <strong>arr</strong>[] of size <strong>N&nbsp;</strong>and<strong>&nbsp;Q</strong>&nbsp;queries.&nbsp;</span><br><span style="font-size: 18px;"><strong>getSum(L,R):&nbsp;</strong>&nbsp;return the sum of range [L,R]<br><strong>updateValue(index,value):</strong>&nbsp;update arr[index] to value.<br><br>You need to calculate the answer for Type-1 queries and do the update in the segment tree for Type-2 queries.</span></p>
<p><span style="font-size: 18px;"><strong>Note:</strong> 0-based indexing is used.</span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong>N = 6, Q = 3
arr[] = {1,3,5,7,9,11}
Queries = getSum(0,2)
          updateValue(3,17)
          getSum(0,5)
<strong>Output:
</strong>9
46</span><span style="font-size: 18px;"><strong>
Explanation: </strong>There are 3 queries:&nbsp;
Query 1:&nbsp;1 + 3 + 5 = 9
Query 2:&nbsp;7 changes to 17
Query 3:&nbsp;1 + 3 + 5 + 17 + 9 + 11= 46</span>
</pre>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>Complete the <strong>updateValue()</strong> and <strong>getSum()</strong> function. The formed segment tree is already provided&nbsp;in both the function as a function argument.<br><strong>updateValue()&nbsp;</strong>processes Type-2 query and does the required update in the segment tree.<br><strong>getSum()&nbsp;</strong>returns the answer for Type-1 query.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(Q*Log(N)).<br><strong>Expected Auxiliary Space:&nbsp;</strong>O(1).</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Segment-Tree</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Advanced Data Structure</code>&nbsp;
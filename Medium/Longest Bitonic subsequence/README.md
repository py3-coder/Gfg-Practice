<h2><a href="https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1">Longest Bitonic subsequence</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array of positive integers. Find&nbsp;the maximum length of Bitonic subsequence.&nbsp;<br>A subsequence of array&nbsp;is called Bitonic if it is first strictly increasing, then strictly decreasing.</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: <br></strong>n = 5<strong><br></strong>nums = [1, 2, 5, 3, 2]
<strong>Output: <br></strong>5
<strong>Explanation: <br></strong>The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.
</span></pre>
<p><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: <br></strong>n = 8<br>nums = [1, 11, 2, 10, 4, 5, 2, 1]
<strong>Output: <br></strong>6
<strong>Explanation: <br></strong>The bitonic sequence 
{1, 2, 10, 4, 2, 1} has length 6.
</span></pre>
<p>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>You don't need to read or print anything. Your task is to complete the function&nbsp;<strong>LongestBitonicSequence()&nbsp;</strong>which takes the array nums[] as input parameter and returns the maximum length of bitonic subsequence.</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(n<sup>2</sup>)<br><strong>Expected Space Complexity:&nbsp;</strong>O(n)</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤&nbsp;length of array ≤ 10<sup>3</sup><br>1 ≤ arr[i] ≤ 10<sup>4</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<code>Cisco</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;
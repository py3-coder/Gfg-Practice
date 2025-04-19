<h2><a href="https://www.geeksforgeeks.org/problems/sum-of-query-ii5310/1">Sum of Query II</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">You are given an array <strong>arr[]</strong> of <strong>n</strong> integers and <strong>q</strong> queries in an array <strong>queries[]</strong> of length <strong>2*q </strong>containing <strong>l</strong>, <strong>r</strong> pair for all q queries. You need to compute the following sum over q queries.</span></p>
<p><span style="font-size: 18px;">&nbsp;<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/705010/Web/Other/blobid0_1717675141.png" width="131" height="66"></span></p>
<p><span style="font-size: 18px;">Note : Array is 1-Indexed.</span></p>
<p><strong><span style="font-size: 18px;">Examples :<br></span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> n = 4, arr = {1, 2, 3, 4}, q = 2, queries = {1, 4, 2, 3}
<strong>Output:</strong> 10 5
<strong>Explaination:</strong> In the first query we need sum from 1 to 4 which is 1+2+3+4 = 10. In the second query we need sum from 2 to 3 which is 2 + 3 = 5.<br></span></pre>
<pre><strong>Input:</strong> n = 5, arr = {26, 30, 48, 29, 8}, q = 2, queries = {4, 4, 2, 3}
<strong>Output:</strong> 29 78
<strong>Explaination:</strong> In the first query we need sum from 4 to 4 which is 29. In the second query we need sum from 2 to 3 which is 30 + 48 = 78.</pre>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>You don't need to read input or print anything. Your task is to complete the function <strong>querySum()</strong> which takes n, arr, q and queries as input parameters and returns the answer for all the queries.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(n+q)<br><strong>Expected Auxiliary Space:</strong> O(n)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ n, q ≤ 10<sup>5</sup><br>1 ≤ arr<sub>i</sub> ≤ 10<sup>3</sup><br>1 ≤ l ≤ r ≤ n</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Mathematical</code>&nbsp;<code>Algorithms</code>&nbsp;<code>prefix-sum</code>&nbsp;
# TWOPATH

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Two Paths

You are given a grid with $N$ rows and $M$ columns. The cell in the $i$-th row from the top and $j$-th column from the left is denoted $(i, j)$, and has the integer $A_{i, j}$ written on it. Each $A_{i, j}$ is either $0, 1,$ or $2$.

A  *right-down path*  in this grid is a sequence of $N+M-1$ cells $(x_1, y_1), (x_2, y_2), \ldots, (x_{N+M-1}, y_{N+M-1})$ such that:

- $(x_1, y_1) = (1, 1)$
- $(x_{N+M-1}, y_{N+M-1}) = (N, M)$
- For each $1 \le i \lt N+M-1$, exactly one of the following two conditions holds: $x_{i+1} = x_{i}$ and $y_{i+1} = y_i + 1$, or $x_{i+1} = x_{i} + 1$ and $y_{i+1} = y_i$

The grid is called  *good*  if there exist  **two**  right-down paths such that:

- The paths are different, i.e. each path contains a cell not in the other; and
- For every cell $(i, j)$ in the grid, at most $A_{i, j}$ of the two paths contain this cell.

You would like to make the given grid  *good*.
So, you can do the following:

- Choose a row or a column of the grid, change every instance of $1$ in the chosen row/column to $2$.

Find the minimum number of moves needed to make the given grid  *good*.
If it's not possible to make the grid  *good*  no matter what, print $-1$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line of each test case contains two space-separated integers $N$ and $M$ — the grid dimensions. The next $N$ lines describe the grid. The $i$-th of these $N$ lines contains $M$ space-separated integers $A_{i, 1}, A_{i, 2}, \ldots, A_{i, M}$.
### Output Format

For each test case, output on a new line the minimum number of operations needed to make the grid  *good*, or $-1$ if it's impossible to do so.

### Constraints
- $1 \leq T \leq 10^5$
- $1 \leq N, M \leq 2\cdot 10^5$
- $1 \le NM \le 2\cdot 10^5$
- $A_{i, j} \in \{0, 1, 2\}$
- The sum of $NM$ over all test cases won't exceed $2\cdot 10^5$.
### Sample 1:
Input
Output

```
6
2 2
1 1
1 1
2 4
1 0 0 0
2 1 2 1
3 5
2 1 0 0 0
1 1 1 1 1
0 0 1 1 2
4 3
2 0 2
0 0 0
2 0 2
2 0 2
4 5
1 1 0 0 0
1 1 1 0 0
0 0 1 1 0
0 0 0 1 1
2 6
2 2 2 2 2 2
2 2 2 2 2 2

```

```
2
-1
1
-1
4
0

```

### Explanation:

 **Test case $1$:**  We have a $2\times 2$ grid. The only way to have two different paths from $(1, 1)$ to $(2, 2)$ is for us to use $(1, 1) \to (1, 2) \to (2, 2)$ and $(1, 1) \to (2, 1) \to (2, 2)$.
These paths can both be valid only if $A_{1, 1}$ and $A_{2, 2}$ are both $2$ (and the other cells are at least $1$, which they are).

We need to increment both $A_{1, 1}$ and $A_{2, 2}$, which requires two moves - it cannot be done in $1$.

 **Test case $2$:**  Since the cells $(1, 2), (1, 3), (1, 4)$ are not usable, only a single unique path can exist from $(1, 1)$ to $(2, 4)$, so the answer is $-1$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-23T16:22:38.909Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/TWOPATH)
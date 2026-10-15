# COMPRESSVD - Rating 940

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Compress the Video

Chef recorded a video explaining his favorite recipe. However, the size of the video is too large to upload on the internet. He wants to compress the video so that it has the minimum size possible.

Chef's video has $N$ frames initially. The value of the $i^{th}$ frame is $A_i$. Chef can do the following type of operation  **any**  number of times:

- Choose an index $i$ $(1\le i \le N)$ such that the value of the $i^{th}$ frame is equal to the value of either of its neighbors and remove the $i^{th}$ frame.

Find the  **minimum**  number of frames Chef can achieve.

### Input Format
- First line will contain $T$, the number of test cases. Then the test cases follow.
- The first line of each test case contains a single integer $N$ - the number of frames initially.
- The second line contains $N$ space-separated integers, $A_1, A_2, \ldots, A_N$ - the values of the frames.
### Output Format

For each test case, output in a single line the  **minimum**  number of frames Chef can achieve.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq N \leq 10^5$
- $1 \leq A_i \leq 10^6$
- Sum of $N$ over all test cases does not exceed $2\cdot 10^5$.
### Sample 1:
Input
Output

```
4
1
5
2
1 1
3
1 2 3
4
2 1 2 2

```

```
1
1
3
3
```

### Explanation:

 **Test case $1$:**  There is only one frame with value $5$. Since there are no neighbors, Chef won't remove any frame and the minimum number of frames Chef can achieve is $1$.

 **Test case $2$:**  There are two frames where both frames have value $1$. Chef can remove the first frame as the value of the first frame is equal to that of the second frame. The remaining frames have values $[1]$. The minimum number of frames Chef can achieve is $1$.

 **Test case $3$:**  There are $3$ frames. All frames have distinct values. Thus, the minimum number of frames Chef can achieve is $3$.

 **Test case $4$:**  Chef can remove the fourth frame as the value of the fourth frame is equal to that of the third frame. The remaining frames have values $[2, 1, 2]$. Thus, the minimum number of frames Chef can achieve is $3$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:57:36.573Z  

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            // Read N
            while (st == null || !st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            int N = Integer.parseInt(st.nextToken());

            // Read the array of frames
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    line = br.readLine();
                    if (line == null) break;
                    st = new StringTokenizer(line);
                }
                A[i] = Integer.parseInt(st.nextToken());
            }

            // Count the minimum frames
            int count = 0;
            if (N > 0) {
                count = 1;
                for (int i = 1; i < N; i++) {
                    if (A[i] != A[i - 1]) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/COMPRESSVD)
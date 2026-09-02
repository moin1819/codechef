# Minimum Moves to Clean the Classroom

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` grid `classroom` where a student volunteer is tasked with cleaning up litter scattered around the room. Each cell in the grid is one of the following:

- 'S': Starting position of the student
- 'L': Litter that must be collected (once collected, the cell becomes empty)
- 'R': Reset area that restores the student's energy to full capacity, regardless of their current energy level (can be used multiple times)
- 'X': Obstacle the student cannot pass through
- '.': Empty space

You are also given an integer `energy`, representing the student's maximum energy capacity. The student starts with this energy from the starting position `'S'`.

Each move to an adjacent cell (up, down, left, or right) costs 1 unit of energy. If the energy reaches 0, the student can only continue if they are on a reset area `'R'`, which resets the energy to its  **maximum**  capacity `energy`.

Return the  **minimum**  number of moves required to collect all litter items, or `-1` if it's impossible.

 

 **Example 1:** 

 **Input:**  classroom = ["S.", "XL"], energy = 2

 **Output:**  2

 **Explanation:** 

- The student starts at cell (0, 0) with 2 units of energy.
- Since cell (1, 0) contains an obstacle 'X', the student cannot move directly downward.
- A valid sequence of moves to collect all litter is as follows: Move 1: From (0, 0) → (0, 1) with 1 unit of energy and 1 unit remaining. Move 2: From (0, 1) → (1, 1) to collect the litter 'L'.
- The student collects all the litter using 2 moves. Thus, the output is 2.

 **Example 2:** 

 **Input:**  classroom = ["LS", "RL"], energy = 4

 **Output:**  3

 **Explanation:** 

- The student starts at cell (0, 1) with 4 units of energy.
- A valid sequence of moves to collect all litter is as follows: Move 1: From (0, 1) → (0, 0) to collect the first litter 'L' with 1 unit of energy used and 3 units remaining. Move 2: From (0, 0) → (1, 0) to 'R' to reset and restore energy back to 4. Move 3: From (1, 0) → (1, 1) to collect the second litter 'L'.
- The student collects all the litter using 3 moves. Thus, the output is 3.

 **Example 3:** 

 **Input:**  classroom = ["L.S", "RXL"], energy = 3

 **Output:**  -1

 **Explanation:** 

No valid path collects all `'L'`.

 

 **Constraints:** 

- 1 <= m == classroom.length <= 20
- 1 <= n == classroom[i].length <= 20
- classroom[i][j] is one of 'S', 'L', 'R', 'X', or '.'
- 1 <= energy <= 50
- There is exactly one 'S' in the grid.
- There are at most 10 'L' cells in the grid.

## Solution

**Language:** Java  
**Runtime:** 114 ms (beats 92.86%)  
**Memory:** 58.7 MB (beats 92.86%)  
**Submitted:** 2026-09-01T15:58:35.582Z  

```java
import java.util.*;

public class Solution {
    
    private static class State {
        int r, c, energy, mask, steps;

        State(int r, int c, int energy, int mask, int steps) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litters.add(new int[]{r, c});
                }
            }
        }

        int k = litters.size();
        if (k == 0) return 0; 

        int[][] litterIdx = new int[m][n];
        for (int r = 0; r < m; r++) Arrays.fill(litterIdx[r], -1);
        for (int i = 0; i < k; i++) {
            litterIdx[litters.get(i)[0]][litters.get(i)[1]] = i;
        }

        int targetMask = (1 << k) - 1;

        int initialMask = 0;
        if (classroom[startR].charAt(startC) == 'L') {
            initialMask |= (1 << litterIdx[startR][startC]);
        }
        if (initialMask == targetMask) return 0;

        int[][][] maxEnergy = new int[m][n][1 << k];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                Arrays.fill(maxEnergy[r][c], -1);
            }
        }

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startR, startC, energy, initialMask, 0));
        maxEnergy[startR][startC][initialMask] = energy;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.energy < maxEnergy[curr.r][curr.c][curr.mask]) {
                continue;
            }

            for (int[] dir : directions) {
                int nr = curr.r + dir[0];
                int nc = curr.c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                    int newEnergy = curr.energy - 1;

                    if (newEnergy < 0) continue; 

                    char cellType = classroom[nr].charAt(nc);
                    int newMask = curr.mask;

                    if (cellType == 'R') {
                        newEnergy = energy;
                    } 
                    else if (cellType == 'L') {
                        int idx = litterIdx[nr][nc];
                        if (idx != -1) {
                            newMask |= (1 << idx);
                        }
                    }

                    if (newMask == targetMask) {
                        return curr.steps + 1;
                    }

                    if (newEnergy > maxEnergy[nr][nc][newMask]) {
                        maxEnergy[nr][nc][newMask] = newEnergy;
                        queue.add(new State(nr, nc, newEnergy, newMask, curr.steps + 1));
                    }
                }
            }
        }

        return -1; 
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/)
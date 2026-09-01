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
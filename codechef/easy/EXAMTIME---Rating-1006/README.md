# EXAMTIME - Rating 1006

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### TCS Examination

Two friends, Dragon and Sloth, are writing a computer science examination series. There are three subjects in this series: $\text{DSA}$, $\text{TOC}$, and $\text{DM}$. Each subject carries $100$ marks.

You know the individual scores of both Dragon and Sloth in all $3$ subjects. You have to determine who got a better rank.

The rank is decided as follows:

- The person with a bigger total score gets a better rank
- If the total scores are tied, the person who scored higher in $\text{DSA}$ gets a better rank
- If the total score and the $\text{DSA}$ score are tied, the person who scored higher in $\text{TOC}$ gets a better rank
- If everything is tied, they get the same rank.
### Input Format
- The first line of input contains a single integer $T$, denoting the number of test cases. The description of $T$ test cases follows.
- The first line of each test case contains three space-separated integers denoting the scores of Dragon in $\text{DSA}$, $\text{TOC}$ and $\text{DM}$ respectively.
- The second line of each test case contains three space-separated integers denoting the scores of Sloth in $\text{DSA}$, $\text{TOC}$ and $\text{DM}$ respectively.
### Output Format
- For each test case, if Dragon got a better rank then output "Dragon", else if Sloth got a better rank then output "Sloth". If there was a tie then output "Tie". Note that the string you output should not contain quotes.
- The output is case insensitive. For example, If the output is "Tie" then "TiE", "tiE", "tie", etc are also considered correct.
### Constraints
- $1 \leq T \leq 1000$
- Each score of both Dragon and Sloth lies between $0$ and $100$.
### Subtasks

 **Subtask #1 (100 points):**  Original constraints

### Sample 1:
Input
Output

```
4
10 20 30
30 20 10
5 23 87
5 23 87
0 15 100
100 5 5
50 50 50
50 49 51

```

```
SLOTH
TIE
DRAGON
DRAGON
```

### Explanation:
- For the first test case, Sloth and Dragon have the same total score but Sloth gets a better rank because he has a higher score in $\text{DSA}$.
- For the second test case, Sloth and Dragon have the same rank because they have the same score among all subjects.
- For the third test case, Dragon gets a better rank because he has a greater total score.
- For the fourth test case, Sloth and Dragon have the same total score and same $\text{DSA}$ score. Dragon gets a better rank because he has a greater $\text{TOC}$ score.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-24T12:23:59.526Z  

```py
import sys

def solve():
    input = sys.stdin.read
    data = input().split()
    if not data:
        return
    
    T = int(data[0])
    idx = 1
    
    for _ in range(T):
        dsa1, toc1, dm1 = int(data[idx]), int(data[idx+1]), int(data[idx+2])
        dsa2, toc2, dm2 = int(data[idx+3]), int(data[idx+4]), int(data[idx+5])
        idx += 6
        
        total1 = dsa1 + toc1 + dm1
        total2 = dsa2 + toc2 + dm2
        
        if total1 > total2:
            print("DRAGON")
        elif total2 > total1:
            print("SLOTH")
        elif dsa1 > dsa2:
            print("DRAGON")
        elif dsa2 > dsa1:
            print("SLOTH")
        elif toc1 > toc2:
            print("DRAGON")
        elif toc2 > toc1:
            print("SLOTH")
        else:
            print("TIE")

if __name__ == "__main__":
    solve()
```

---

[View on CodeChef](https://www.codechef.com/problems/EXAMTIME)
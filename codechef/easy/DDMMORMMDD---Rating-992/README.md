# DDMMORMMDD - Rating 992

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### DDMM or MMDD

Chef is confused by all the different formats dates can be written in. Here's a simple problem Chef wants you to solve.

You are given a date string $S$. The date follows the Gregorian calendar, the one used in most parts of the world.

Identify whether it is of the form `DD/MM/YYYY` or `MM/DD/YYYY`, or if it can be of both forms. Here `DD` denotes the 2-digit day, `MM` denotes the 2-digit month and `YYYY` denotes the 4-digit year.

It is guaranteed that $S$ is a valid date taking at least one of these forms.

For example,

- 21/05/2001 is of the form DD/MM/YYYY and not MM/DD/YYYY.
- 10/15/2069 is of the form MM/DD/YYYY and not DD/MM/YYYY.
- 05/11/1999 can be of both forms.
### Input Format
- The first line contains a single integer $T$ — the number of test cases. Then the test cases follow.
- Each test case consists of a single line containing a string of $10$ characters $S$ — the date string $S$, which is of the form DD/MM/YYYY or MM/DD/YYYY. It is guaranteed that $S$ is a valid date taking at least one of these forms.
### Output Format

For each test case, output "`BOTH`" if the date string satisfies both forms. Otherwise output "`DD/MM/YYYY`" if it is of the form `DD/MM/YYYY`, else "`MM/DD/YYYY`". Note that the output may be case-insensitive. So "`DD/MM/YYYY`", "`dd/mm/yyyy`" and so on will be considered the same.

### Constraints
- $1 \leq T \leq 2023$
- $S$ is of the form DD/MM/YYYY or MM/DD/YYYY
### Sample 1:
Input
Output

```
4
21/05/2001
10/15/2069
05/11/1999
29/02/2024

```

```
DD/MM/YYYY
MM/DD/YYYY
BOTH
DD/MM/YYYY

```

### Explanation:

Fun fact: `29/02/2024` (read as `DD/MM/YYYY`) is a leap year day.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-15T11:43:22.303Z  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            while (t-- > 0) {
                String s = sc.next();
                
                // Get the first two digits and second two digits
                int a = Integer.parseInt(s.substring(0, 2));
                int b = Integer.parseInt(s.substring(3, 5));
                
                // Months can only go up to 12
                if (a > 12) {
                    System.out.println("DD/MM/YYYY");
                } else if (b > 12) {
                    System.out.println("MM/DD/YYYY");
                } else {
                    System.out.println("BOTH");
                }
            }
        }
        
        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/DDMMORMMDD)
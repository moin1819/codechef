# ALPHABET - Rating 1123

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Studying Alphabet

Not everyone probably knows that Chef has younger brother Jeff. Currently Jeff learns to read.

He knows some subset of the letter of Latin alphabet. In order to help Jeff to study, Chef gave him a book with the text consisting of  **N**  words. Jeff can read a word if it consists only of the letters he knows.

Now Chef is curious about which words his brother will be able to read, and which are not. Please help him!

### Input

The first line of the input contains a lowercase Latin letter string  **S**, consisting of the letters Jeff can read. Every letter will appear in  **S**  no more than once.

The second line of the input contains an integer  **N**  denoting the number of words in the book.

Each of the following  **N**  lines contains a single lowercase Latin letter string  **Wi**, denoting the  **i** th word in the book.

### Output

For each of the words, output "Yes" (without quotes) in case Jeff can read it, and "No" (without quotes) otherwise.

### Constraints
- 1 ≤ |S| ≤ 26
- 1 ≤ N ≤ 1000
- 1 ≤ |Wi| ≤ 12
- Each letter will appear in S no more than once.
- S, Wi consist only of lowercase Latin letters.
### Subtasks
- Subtask #1 (31 point): |S| = 1, i.e. Jeff knows only one letter.
- Subtask #2 (69 point) : no additional constraints
### Sample 1:
Input
Output

```
act
2
cat
dog
```

```
Yes
No
```

### Explanation:

The first word can be read.

The second word contains the letters d, o and g that aren't known by Jeff.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-16T06:21:46.938Z  

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int N = sc.nextInt();
        while (N-- > 0) {
            String word = sc.next();
            boolean canRead = true;
            for (int i = 0; i < word.length(); i++) {
                if (S.indexOf(word.charAt(i)) == -1) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/ALPHABET)
# ALPHABET - Rating 900

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Convert String to Title Case

Given a string `S` consisting of only lowercase and uppercase English letters and spaces, your task is to convert it into title case. In title case, the first letter of each word is capitalized while the rest are in lowercase, except for words that are entirely in uppercase (considered as acronyms), which should remain unchanged.

 **Note:** 

- Words are defined as contiguous sequences of English letters separated by spaces.
- Acronyms are words that are entirely in uppercase and should remain unchanged.
- Assume the input does not contain leading, trailing, or multiple spaces between words.
### Input Format
- The first line contains a single integer T, the number of test cases.
- Each of the next T lines contains a string S.
### Output Format

For each test case, print a single line containing the string `S` converted into title case.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq |S| \leq 1000$, where $|S|$ is the length of the string.
### Sample 1:
Input
Output

```
5
hello world
this is a CODECHEF problem
WELCOME to the JUNGLE
the quick BROWN fOx
programming in PYTHON
```

```
Hello World
This Is A CODECHEF Problem
WELCOME To The JUNGLE
The Quick BROWN Fox
Programming In PYTHON
```

### Explanation:
- In the first test case, each word is capitalized as they are not acronyms.
- In the second test case, "CODECHEF" is an acronym and remains in uppercase.
- In the third test case, "WELCOME" and "JUNGLE" are considered acronyms.
- In the fourth test case, "BROWN" is an acronym, while the rest of the words follow the title case rule.
- In the fifth test case, "PYTHON" is an acronym, and the rest of the string is converted to title case.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-16T06:20:54.956Z  

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine(); // consume newline

        while (T-- > 0) {
            String s = sc.nextLine();
            String[] words = s.split(" ");

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                // Check if word is completely uppercase
                boolean isAcronym = true;

                for (int j = 0; j < word.length(); j++) {
                    if (Character.isLowerCase(word.charAt(j))) {
                        isAcronym = false;
                        break;
                    }
                }

                if (isAcronym) {
                    // Keep acronym unchanged
                    result.append(word);
                } else {
                    // First letter uppercase, remaining lowercase
                    result.append(Character.toUpperCase(word.charAt(0)));

                    for (int j = 1; j < word.length(); j++) {
                        result.append(Character.toLowerCase(word.charAt(j)));
                    }
                }

                if (i < words.length - 1) {
                    result.append(" ");
                }
            }

            System.out.println(result);
        }

        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/ALPHABET)
t = int(input())

for _ in range(t):
    n, s = map(int, input().split())

    ans = -1

    for correct in range(n + 1):
        for wrong in range(n - correct + 1):
            score = 4 * correct - wrong

            if score == s:
                attempts = correct + wrong
                if ans == -1 or attempts < ans:
                    ans = attempts

    print(ans)
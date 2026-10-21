t = int(input())

for _ in range(t):
    n = int(input())
    k = 0

    while (k + 1) * (k + 2) * (k + 3) // 6 <= n:
        k += 1

    print(k)
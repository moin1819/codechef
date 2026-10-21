t = int(input())

for _ in range(t):
    n = int(input())
    lo, hi = 1, 2000000
    ans = 0

    while lo <= hi:
        mid = (lo + hi) // 2
        total = mid * (mid + 1) * (mid + 2) // 6

        if total <= n:
            ans = mid
            lo = mid + 1
        else:
            hi = mid - 1

    print(ans)
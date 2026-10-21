t = int(input())

for _ in range(t):
    n, d = map(int, input().split())

    while str(d) in str(n):
        n += 1

    print(n)
def solve():
    A, B, X = map(int, input().split())
    diff = abs(A - B)
    
    if diff % (2 * X) == 0:
        print("YES")
    else:
        print("NO")

t = int(input())
for _ in range(t):
    solve()
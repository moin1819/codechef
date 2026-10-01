T = int(input())

for _ in range(T):
    X, Y, A = map(int, input().split())

    if X <= A < Y:
        print("YES")
    else:
        print("NO")
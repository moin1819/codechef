def solve():
    T = int(input())
    for _ in range(T):
        X, Y = map(int, input().split())
        if X <= Y <= X + 200:
            print("YES")
        else:
            print("NO")

if __name__ == '__main__':
    solve()
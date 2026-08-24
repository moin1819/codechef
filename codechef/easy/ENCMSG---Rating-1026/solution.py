import sys

def solve():
    input = sys.stdin.read
    data = input().split()
    if not data:
        return
    
    T = int(data[0])
    idx = 1
    
    for _ in range(T):
        N = int(data[idx])
        X = int(data[idx + 1])
        idx += 2
        
        # If N and X have the same parity, or if N is even, it's always possible
        if N % 2 == X % 2 or N % 2 == 0:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    solve()
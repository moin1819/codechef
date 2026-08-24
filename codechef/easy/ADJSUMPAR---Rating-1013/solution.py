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
        idx += 1
        
        sum_B = 0
        for _ in range(N):
            sum_B += int(data[idx])
            idx += 1
            
        if sum_B % 2 == 0:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    solve()
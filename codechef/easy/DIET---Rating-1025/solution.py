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
        K = int(data[idx + 1])
        idx += 2
        
        stored = 0
        failed_day = -1
        
        for i in range(1, N + 1):
            bought = int(data[idx])
            idx += 1
            stored += bought
            
            if stored < K and failed_day == -1:
                failed_day = i
            else:
                stored -= K
                
        if failed_day == -1:
            print("YES")
        else:
            print(f"NO {failed_day}")

if __name__ == "__main__":
    solve()
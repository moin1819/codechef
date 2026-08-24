import sys
from collections import Counter

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
        
        freq = Counter()
        possible = True
        
        for _ in range(2 * N):
            x = int(data[idx])
            idx += 1
            freq[x] += 1
            if freq[x] > 2:
                possible = False
                
        if possible:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    solve()
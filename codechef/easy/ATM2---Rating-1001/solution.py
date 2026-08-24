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
        
        result = []
        for _ in range(N):
            amount = int(data[idx])
            idx += 1
            if amount <= K:
                result.append('1')
                K -= amount
            else:
                result.append('0')
                
        print("".join(result))

if __name__ == "__main__":
    solve()
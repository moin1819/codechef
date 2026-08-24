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
        S = list(data[idx + 1])
        idx += 2
        
        # Step 1: Swap adjacent pairs
        for i in range(0, N - 1, 2):
            S[i], S[i + 1] = S[i + 1], S[i]
            
        # Step 2: Mirror alphabet transformation
        for i in range(N):
            S[i] = chr(ord('z') - (ord(S[i]) - ord('a')))
            
        print("".join(S))

if __name__ == "__main__":
    solve()
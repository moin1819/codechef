import sys

def solve():
    input = sys.stdin.read
    data = input().split()
    if not data:
        return
    
    T = int(data[0])
    idx = 1
    
    for _ in range(T):
        dsa1, toc1, dm1 = int(data[idx]), int(data[idx+1]), int(data[idx+2])
        dsa2, toc2, dm2 = int(data[idx+3]), int(data[idx+4]), int(data[idx+5])
        idx += 6
        
        total1 = dsa1 + toc1 + dm1
        total2 = dsa2 + toc2 + dm2
        
        if total1 > total2:
            print("DRAGON")
        elif total2 > total1:
            print("SLOTH")
        elif dsa1 > dsa2:
            print("DRAGON")
        elif dsa2 > dsa1:
            print("SLOTH")
        elif toc1 > toc2:
            print("DRAGON")
        elif toc2 > toc1:
            print("SLOTH")
        else:
            print("TIE")

if __name__ == "__main__":
    solve()
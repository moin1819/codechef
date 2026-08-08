import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    T = int(input_data[0])
    idx = 1
    
    for _ in range(T):
        X = int(input_data[idx])
        Y = int(input_data[idx + 1])
        idx += 2
        
        # Check if the sum is strictly greater than 6
        if X + Y > 6:
            print("YES")
        else:
            print("NO")

if __name__ == '__main__':
    main()
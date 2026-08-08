import sys

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    T = int(input_data[0])
    
    for i in range(1, T + 1):
        X = int(input_data[i])
        
        # Check if Chef drank at least 2000 ml
        if X >= 2000:
            print("YES")
        else:
            print("NO")

if __name__ == '__main__':
    main()
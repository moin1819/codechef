import sys

def main():
    # Read all inputs from standard input
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    # First token is the number of test cases T
    T = int(input_data[0])
    
    idx = 1
    for _ in range(T):
        A = int(input_data[idx])
        B = int(input_data[idx + 1])
        print(A + B)
        idx += 2

if __name__ == '__main__':
    main()
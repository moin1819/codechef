import sys

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    T = int(input_data[0])
    results = []
    
    # Translation table to swap '>' and '<'
    trans_table = str.maketrans({'>': '<', '<': '>'})
    
    for i in range(1, T + 1):
        s = input_data[i]
        # Transform the string
        s_trans = s.translate(trans_table)
        # Count how many '><' pairs exist
        count = s_trans.count('><')
        results.append(str(count))
        
    print('\n'.join(results))

if __name__ == '__main__':
    solve()
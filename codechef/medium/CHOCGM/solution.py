# cook your dish here
def solve():
    N = int(input())
    A = list(map(int, input().split()))
    
    total_sum = sum(A)
    
    # If the sum is odd, Bob takes everything
    if total_sum % 2 != 0:
        print(0)
        return
    
    # If the sum is even, Alice takes all even components + 1 extra
    alice_chocolates = 0
    for x in A:
        # Subtract 1 if x is odd to get the maximum even component
        alice_chocolates += x - (x % 2)
        
    alice_chocolates += 1
    print(alice_chocolates)

T = int(input())
for _ in range(T):
    solve()
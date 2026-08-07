
n = int(input())

factorial = 1
current = n

while current > 1:
    factorial *= current
    current -= 1
print(factorial)
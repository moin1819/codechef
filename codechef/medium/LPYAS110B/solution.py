# Read input string
s = input()

vowels = {'a', 'e', 'i', 'o', 'u'}

count = 0
index = 0

while index < len(s):
    if s[index] in vowels:
        count += 1
    index += 1
print(count)
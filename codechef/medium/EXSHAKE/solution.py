t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))

    a.sort()
    people = 0
    groups = 0

    for x in a:
        total = people + x
        handshakes = total * (total - 1) // 2

        if handshakes <= m:
            people = total
            groups += 1
        else:
            break

    print(groups)
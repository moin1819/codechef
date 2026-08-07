def print_squares():
    N = int(input())
    i = 1
    squares = []
    while i <= N:
        squares.append(str(i * i))
        i += 1
    print(" ".join(squares))
if __name__ == "__main__":
    print_squares()
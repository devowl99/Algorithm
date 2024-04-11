import sys
input = sys.stdin.readline

n = int(input())
if n < 100:
    hansu = n
else:
    hansu = 99
    for i in range(100, n+1):
        n100 = i // 100
        i %= 100
        n10 = i // 10
        n1 = i % 10

        gap1_10 = n1 - n10
        gap10_100 = n10 - n100

        if gap1_10 == gap10_100:
            hansu += 1

print(hansu)
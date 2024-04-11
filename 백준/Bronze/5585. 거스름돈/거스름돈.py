import sys
input = sys.stdin.readline

cost = int(input())
change = 1000 - cost
case = [500, 100, 50, 10, 5, 1]
coin = 0

for i in case:
    coin += (change // i)
    change %= i

print(coin)
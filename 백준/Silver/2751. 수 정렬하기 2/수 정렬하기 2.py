import sys
input = sys.stdin.readline

n = int(input())
nl = []

for i in range(n):
    nl.append(int(input()))

nl.sort()

for i in nl:
    print(i)
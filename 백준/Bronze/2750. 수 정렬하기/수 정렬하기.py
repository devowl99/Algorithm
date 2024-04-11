import sys
input = sys.stdin.readline

n = int(input())
nl = list()

for i in range(n):
    nl.append(int(input()))

nl.sort()

for i in range(n):
    print(nl[i])
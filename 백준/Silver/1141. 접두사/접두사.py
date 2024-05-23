import sys
input = sys.stdin.readline
n = int(input())
s = []

for _ in range(n):
    s.append(input().strip())

s.sort(key=len)
count = 0
for i in range(n):
    check = True
    for j in range(i+1, n):
        if s[i] == s[j][:len(s[i])]:
            check = False
            break
    if check:
        count += 1

print(count)
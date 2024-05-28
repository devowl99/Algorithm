import sys
input = sys.stdin.readline

n, m = map(int, input().split())

word = set()
count = 0
for _ in range(n):
    word.add(input().strip())
for _ in range(m):
    if input().strip() in word:
        count += 1

print(count)
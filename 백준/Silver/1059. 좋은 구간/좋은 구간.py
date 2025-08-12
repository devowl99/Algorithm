from itertools import combinations

L = int(input())
S = list(map(int, input().split()))
n = int(input())
S.append(0)
S.append(1001)
S.sort()
good = []
count = 0
for i in range(len(S)-1):
    if S[i] < n < S[i+1]:
        for s in range(S[i]+1, S[i+1]):
            good.append(s)
        break

for comb in combinations(good, 2):
    if comb[0] <= n <= comb[1]:
        count += 1

print(count)
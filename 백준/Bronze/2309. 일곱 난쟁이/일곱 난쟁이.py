from itertools import combinations

height = [int(input()) for _ in range(9)]
for comb in combinations(height, 7):
    if sum(comb) == 100:
        comb = sorted(comb)
        for i in comb:
            print(i)
        break
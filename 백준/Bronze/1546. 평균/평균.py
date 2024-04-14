n = int(input())
score = list(map(int, input().split()))
score.sort()
m = score[-1]
sum = 0

for i in score:
    sum += i/m*100

print(sum/n)
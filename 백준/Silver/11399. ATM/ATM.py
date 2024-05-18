n = int(input())
p = sorted(list(map(int, input().split())))
sum = 0
total = 0

for i in p:
    sum += i
    total += sum

print(total)
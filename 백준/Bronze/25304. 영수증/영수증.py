X = int(input())
N = int(input())

price = 0
for _ in range(N):
    a, b = map(int, input().split())
    price += a*b

if X == price:
    print('Yes')
else:
    print('No')
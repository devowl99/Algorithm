import sys
input = sys.stdin.readline
n, m = map(int, input().split())

tree = list(map(int, input().split()))

start = 0
end = max(tree)
while start <= end:
    H = (start + end)//2
    sum = 0
    for th in tree:
        if th > H:
            sum += (th - H)
    if sum >= m:
        start = H+1
    else:
        end = H-1

print(end)
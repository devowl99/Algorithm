import sys
input = sys.stdin.readline

n = int(input())
nl = list((map(int, input().split())))
m = int(input())
ml = list((map(int, input().split())))

nl.sort()

for i in ml:
    left = 0
    right = len(nl) - 1
    same = False

    while left <= right:
        mid = (left + right) // 2
        if i < nl[mid]:
            right = mid - 1
        elif i > nl[mid]:
            left = mid + 1
        else:
            same = True
            break

    if same:
        print(1)
    else:
        print(0)
n = int(input())
card = list(map(int, input().split()))
m = int(input())
check = list(map(int, input().split()))

card.sort()
for i in check:
    first = 0
    last = n-1
    exist = False
    while first <= last:
        mid = (first + last) // 2
        if i == card[mid]:
            exist = True
            break
        elif i > card[mid]:
            first = mid+1
        else:
            last = mid-1
    if exist:
        print(1, end=' ')
    else:
        print(0, end=' ')
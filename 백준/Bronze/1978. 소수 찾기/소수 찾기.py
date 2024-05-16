n = int(input())
num = list(map(int, input().split()))
count = 0

for i in num:
    pn = True
    for j in range(2,i):
        if i % j  == 0:
            pn = False
            break
    if i != 1 and pn:
        count += 1
    
print(count)
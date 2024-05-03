s = int(input())
num = []
i = 1

while s >= i:
    num.append(i)
    s -= i
    i += 1

print(len(num))
n = int(input())
word = []
gw = 0

for _ in range(n):
    word.append(input())

for i in word:
    gwlist = []
    ilen = len(i)
    is_gw = True
    for j in range(ilen):
        if i[j] in gwlist and i[j] != gwlist[-1]:
            is_gw = False
            gwlist.append(i[j])
            continue
        elif i[j] in gwlist and i[j] == gwlist[-1]:
            continue
        elif i[j] not in gwlist:
            gwlist.append(i[j])
        else:
            gwlist.append('0')
    if is_gw or len(set(i)) == 1:
        gw += 1

print(gw)
t = int(input())
r = []
s = []
for _ in range(t):
    ri, si = map(str, input().split())
    r.append(int(ri))
    s.append(si)

for tn in range(t):
    for i in s[tn]:
        for _ in range(r[tn]):
            print(i, end='')
    print()
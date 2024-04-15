x, y, m, h = map(int, input().split())
x2 = m-x
y2 = h-y
comp=[x, x2, y, y2]
comp.sort()
print(comp[0])
h, m = map(int, input().split())
cooktime = int(input())
totalm = m+cooktime
hour = 0

while totalm >= 60:    
    totalm -= 60
    hour += 1
for _ in range(hour):
    h += 1

if h == 24:
    h = 0
elif h > 24:
    h -= 24
    
print('%d %d' %(h, totalm))
word = input().upper()
al = list(set(word))
max = 0
many = False

for i in al:
    n = word.count(i)
    if max < n:
        many = False
        max = n
        maxal = i
    elif max == n:
        many = True

if many:
    print('?')
else:
    print(maxal)
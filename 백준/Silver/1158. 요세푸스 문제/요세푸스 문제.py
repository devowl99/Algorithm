n, k = map(int, input().split())

people = list(range(1, n+1))
target = 0

print('<', end='')
while people:
    target = (target + k - 1) % len(people)
    
    print(people.pop(target), end = '')
    
    if people:
        print(',', end=' ')
    else:
        break
print('>')
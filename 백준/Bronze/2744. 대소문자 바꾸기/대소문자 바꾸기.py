word = input()
change = []

for i in word:
    if i >= 'a' and i <= 'z':
        change.append(i.upper())
    else:
        change.append(i.lower())

print(''.join(change))
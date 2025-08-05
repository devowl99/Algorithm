word = list(input())
word_set = sorted(set(word))
word_count = []
for sw in word_set:
    word_count.append(word.count(sw))

mid = ''
pal = True
if len(word) % 2 == 0:
    for wc in word_count:
        if wc % 2 == 1:
            pal = False
            break
elif len(word) % 2 == 1:
    count = 0
    for i in range(len(word_count)):
        if word_count[i] % 2 == 1:
            if count == 0:
                count += 1
                mid = word_set[i]
            elif count == 1:
                pal = False
                break

if pal:
    front = ''
    for i in range(len(word_set)):
        front += word_set[i] * (word_count[i] // 2)
    print(front + mid + front[::-1])
else:
    print("I'm Sorry Hansoo")
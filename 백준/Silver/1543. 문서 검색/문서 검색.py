doc = input()
word = input()
doc_len = len(doc)
word_len = len(word)

i = 0
count = 0
while True:
    increase = False
    if i+word_len > doc_len:
        break
    if doc[i] == word[0]:
        if doc[i:i+word_len] == word:
            count += 1
            i += word_len
            increase = True
    if not increase:
        i += 1

print(count)
a = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
s = input()

for i in a:
    inc = False
    num = 0
    for j in s:
        if i == j:
            inc = True
            break
        num += 1
    
    if inc:
        print(num, end=' ')
    else:
        print(-1, end=' ')
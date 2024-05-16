import sys
n = int(input())

if n % 5 == 0:
    print(n//5)
    sys.exit()

if n > 5:
    bag = 0
    i = 0
    while True:
        nd5 = n % 5 + (5*i)
        bag = n // 5 - 1*i

        if nd5 % 3 == 0:
            bag += (nd5 // 3)
            print(bag)
            break
        else:
            i += 1
    
        if nd5 == n:
            if n % 3 == 0:
                print(n//3)
            else:
                print(-1)
            break

elif n == 3:
    print(1)
else:
    print(-1)
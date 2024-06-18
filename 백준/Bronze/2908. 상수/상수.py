a, b = list(input().split())
ra = a[::-1]
rb = b[::-1]

if ra > rb:
    print(ra)
else:
    print(rb)
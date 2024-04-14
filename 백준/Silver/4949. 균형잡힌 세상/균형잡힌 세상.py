while True:
    txt = input()
    if txt == '.':
        break
    
    is_balanced = True
    stack = []

    for i in txt:
        if i == '(' or i == '[':
            stack.append(i)
        elif i == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(i)
        elif i == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                stack.append(i)

    if len(stack) != 0:
        is_balanced = False

    if is_balanced:
        print('yes')
    else:
        print('no')
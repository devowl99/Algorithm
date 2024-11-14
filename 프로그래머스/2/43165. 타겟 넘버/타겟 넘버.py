def solution(numbers, target):
    list = [0]

    for num in numbers:
        temp = []
        for l in list:
            temp.append(l + num)
            temp.append(l - num)
        list = temp

    return list.count(target)
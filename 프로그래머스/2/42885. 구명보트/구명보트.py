def solution(people, limit):
    people.sort()
    boat = 0
    left = 0
    right = len(people) - 1
    
    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1
        right -= 1
        boat += 1

    return boat
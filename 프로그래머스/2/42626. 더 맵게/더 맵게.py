import heapq

def solution(scoville, K):
    count= 0
    heapq.heapify(scoville)

    while len(scoville) > 1 and scoville[0] < K:
        first = heapq.heappop(scoville) # scoville의 최솟값 도출
        second = heapq.heappop(scoville)

        new_taste= first+(second*2)
        heapq.heappush(scoville, new_taste)

        count+=1

    if scoville[0] >= K:
        return count
    else: return -1
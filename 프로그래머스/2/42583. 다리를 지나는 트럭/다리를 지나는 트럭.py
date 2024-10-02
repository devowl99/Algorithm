def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = [0] * bridge_length
    weightsum = 0
    
    while bridge or truck_weights:
        time += 1
        
        weightsum -= bridge.pop(0)
        
        if truck_weights:
            if weightsum + truck_weights[0] <= weight:
                new_truck = truck_weights.pop(0)
                bridge.append(new_truck)
                weightsum += new_truck
            else:
                bridge.append(0)
    
    return time
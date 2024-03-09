N, K = map(int,input().split())
array=list(map(int,input().split()))

def selection_sort(arr,K):
    countk=0
    
    for i in range(len(arr)-1,0,-1):
        max_idx = i
        
        for j in range(i-1,-1,-1):
            if arr[j] > arr[max_idx]:
                max_idx = j
        
        if max_idx != i:
            arr[i], arr[max_idx] = arr[max_idx], arr[i]
            countk+=1
        
        if countk == K:
            return countk
    return -1


answer = selection_sort(array,K)

if answer==-1:
    print(answer)
else:
    for i in range(N):
        print(array[i], end=" ")


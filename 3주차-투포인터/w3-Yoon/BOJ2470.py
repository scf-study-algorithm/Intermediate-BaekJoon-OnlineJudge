import sys 
input = sys.stdin.readline 
n = int(input()) 
arr = sorted(list(map(int, input().split()))) 
start = 0 
end = n-1 
czero = abs(arr[start]+arr[end]) 
cstart = start 
cend = end 

while start<end: 
    tmp = arr[start]+arr[end] 
    if abs(tmp) < czero: 
        cstart = start 
        cend = end 
        czero = abs(tmp) 
        if czero == 0: 
            break 
    if tmp > 0: 
        end -= 1 
    else: 
        start += 1 
        
print(arr[cstart], arr[cend])
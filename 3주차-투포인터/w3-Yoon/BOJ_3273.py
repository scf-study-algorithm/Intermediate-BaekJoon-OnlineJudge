import sys

read = sys.stdin.readline()

n=int(read())

arr=list(map(int, read(),split()))

x=int(read())

arr.sort()

start=0

end=n-1

cnt=0



while start < end:

​    sum = arr[start]+arr[end]

​    if sum == x:

​        cnt+=1

​    if sum < x:

​        start+=1

​    else:

​        end-=1



print(cnt)
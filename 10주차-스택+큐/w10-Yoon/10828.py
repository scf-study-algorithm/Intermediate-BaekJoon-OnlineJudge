import sys

n = int(sys.std.readline())
stack=[]

for i in range(n):
    stn = sys.stdin.readline().split()
    order = stn[0]

    if order == "push":
        value = stn[1]
        stack.append(int(value))

    elif order == "pop":
        if len(stack)==0:
            print(-1)
        else:
            print(stack.pop())

    elif order == "size":
        print(len(stack))

    elif order == "empty":
        if len(stack)==0:
            print(1)
        else:
            print(0)
    
    elif order == "top":
        if len(stack)==0:
            print(-1)
        else:
            print(stack[-1])


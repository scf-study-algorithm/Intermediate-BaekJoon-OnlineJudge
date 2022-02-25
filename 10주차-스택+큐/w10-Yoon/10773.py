import sys

k = int(sys.std.readline())
stack = []

for i in range(k):
    input = int(sys.std.readline())
    if input ==0:
        stack.pop()
    else:
        stack.append(input)

print(sum(stack))
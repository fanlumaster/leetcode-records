from queue import Queue

q = Queue()

for i in range(3, 0, -1):
    q.put(i)

q.put(5)
print('test', q.qsize())
q.put(2)
q.put(3)
q.put(4)

while not q.empty():
    print(q.get())

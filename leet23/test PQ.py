from queue import PriorityQueue

pq = PriorityQueue()

for i in range(3, 0, -1):
    pq.put(i)

pq.put(5)
pq.put(2)
pq.put(3)
pq.put(4)

while not pq.empty():
    print(pq.get())

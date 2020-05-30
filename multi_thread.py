import threading
import time

def descend(arr):
    a = []
    a.extend(arr)
    for i in range(len(a)):
        for j in range(len(a)-i-1):
            if a[j] < a[j+1]:
                a[j],a[j+1] = a[j+1],a[j]
        print(a)
        time.sleep(0.02)
    print("finaldsc: ",a)

def ascend(arr):
    ar = []
    ar.extend(arr)
    for i in range(len(ar)):
        for j in range(len(ar)-i-1):
            if ar[j] > ar[j+1]:
                ar[j],ar[j+1] = ar[j+1],ar[j]
        print(ar)
        time.sleep(0.01)
    print("finalasc: ",ar)


arr = [int(x) for x in input("Enter the list of numbers: ").split()]


if __name__ == "__main__":
    t1 = threading.Thread(target=ascend, args=(arr,))
    t2 = threading.Thread(target=descend, args=(arr,))
    t1.start()
    t2.start()
    t1.join()
    t2.join()





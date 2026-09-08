import time
comparisons = 0
exchanges = 0

## Insertion Sort
def insertionSort(Array):
    global comparisons, exchanges

    for i in range(1, len(Array)):
        key = Array[i]
        j = i - 1

        while j >= 0:
            comparisons += 1

            if key < Array[j]:
                comparisons += 1
                Array[j + 1] = Array[j]
                exchanges += 1
                j -= 1
            else:
                comparisons += 1
                break

        Array[j + 1] = key
        exchanges += 1

    return Array          

def insertionSortCSV(Array):
    global comparisons, exchanges
    comparisons = 0
    exchanges = 0
    start = time.perf_counter()
    insertionSort(Array)
    end = time.perf_counter()
    with open("Insertion.csv", "a") as f:
        print(f"{end - start:.6f},{comparisons},{exchanges}", file=f)



## Quick Sort
def quickSort(Array):
    global comparisons, exchanges

    if len(Array) <= 1:
        return Array

    pivot = Array[len(Array) // 2]
    left = []
    right = []

    for i, x in enumerate(Array):
        if i == len(Array) // 2:
            continue

        comparisons += 1

        if x < pivot:
            left.append(x)
            exchanges += 1
        else:
            right.append(x)
            exchanges += 1

    return quickSort(left) + [pivot] + quickSort(right)

def quickSortCSV(Array):
    global comparisons, exchanges
    comparisons = 0
    exchanges = 0
    start = time.perf_counter()
    quickSort(Array)
    end = time.perf_counter()
    with open("quick.csv", "a") as f:
        print(f"{end - start:.6f},{comparisons},{exchanges}", file=f)



## Merge Sort
def mergeSort(Array):
    global comparisons, exchanges

    if len(Array) > 1:
        mid = len(Array) // 2
        left = Array[:mid]
        right = Array[mid:]

        mergeSort(left)
        mergeSort(right)

        i = j = k = 0

        while i < len(left) and j < len(right):
            comparisons += 1

            if left[i] < right[j]:
                Array[k] = left[i]
                exchanges += 1
                i += 1
            else:
                Array[k] = right[j]
                exchanges += 1
                j += 1

            k += 1

        while i < len(left):
            Array[k] = left[i]
            exchanges += 1
            i += 1
            k += 1

        while j < len(right):
            Array[k] = right[j]
            exchanges += 1
            j += 1
            k += 1

    return Array

def mergeSortCSV(Array):
    global comparisons, exchanges
    comparisons = 0
    exchanges = 0
    start = time.perf_counter()
    mergeSort(Array)
    end = time.perf_counter()
    with open("merge.csv", "a") as f:
        print(f"{end - start:.6f},{comparisons},{exchanges}", file=f)



def main():
    # Array = list(range(0,21)) ## 0 - 20
    # Array2 = list(range(20,-1,-1)) ## 20 - 0
    # Array3 = [5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5]
    # Array4 = list(range(1,1001)) 
    # Array5 = list(range(1000,0,-1)) 
    Array6 = [i*i for i in range(1,101)]  ## Squares up to 100
    Array7 = [64,12,45,3,22,78,1,56,34,90,11,67,2,88,23,5,
              49,31,77,6,18,92,41,27,59,14,73,8,36,99,4,61,
              20,84,9,52,39,71,16,28,95,7,63,25,47,10,82,33,
              68,13,54,21,87,15,44,30,97,19,70,26,58,32,91,24]
    # for i in range(1000):
    #     # quickSortCSV(Array.copy())
    #     # quickSortCSV(Array2.copy())
    #     # quickSortCSV(Array3.copy())
    #     # quickSortCSV(Array4.copy())
    #     # quickSortCSV(Array5.copy())
    quickSortCSV(Array6.copy())
    #quickSortCSV(Array7.copy())
    # for i in range(1000):
    #     # insertionSortCSV(Array.copy())
    #     # insertionSortCSV(Array2.copy())
    #     # insertionSortCSV(Array3.copy())
    #     # insertionSortCSV(Array4.copy())
    #     # insertionSortCSV(Array5.copy())
    insertionSortCSV(Array6.copy())
    #insertionSortCSV(Array7.copy())
    # for i in range(1000):
    #     # mergeSortCSV(Array.copy())
    #     # mergeSortCSV(Array2.copy())
    #     # mergeSortCSV(Array3.copy())
    #     # mergeSortCSV(Array4.copy())
    #     # mergeSortCSV(Array5.copy())
    mergeSortCSV(Array6.copy())
    #mergeSortCSV(Array7.copy())




if __name__ == "__main__":
    main()
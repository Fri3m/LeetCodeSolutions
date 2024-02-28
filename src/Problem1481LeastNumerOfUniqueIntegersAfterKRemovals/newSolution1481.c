#include <stdio.h>
#include <stdlib.h>

// Define the structure for the heap node
typedef struct {
    int value;
    int count;
} HeapNode;

// Define the structure for the min-heap
typedef struct {
    HeapNode *array;
    int capacity;
    int size;
} MinHeap;

// Function to create a new heap node
HeapNode createHeapNode(int value) {
    HeapNode newNode;
    newNode.value = value;
    newNode.count = 1;
    return newNode;
}

// Function to initialize a new min-heap
MinHeap* createMinHeap(int capacity) {
    MinHeap* minHeap = (MinHeap*)malloc(sizeof(MinHeap));
    minHeap->array = (HeapNode*)malloc(capacity * sizeof(HeapNode));
    minHeap->capacity = capacity;
    minHeap->size = 0;
    return minHeap;
}

// Function to swap two heap nodes
void swap(HeapNode* a, HeapNode* b) {
    HeapNode temp = *a;
    *a = *b;
    *b = temp;
}

// Function to heapify the heap (maintain the heap property)
void heapify(MinHeap* minHeap, int idx) {
    int smallest = idx;
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;

    if (left < minHeap->size && minHeap->array[left].count < minHeap->array[smallest].count)
        smallest = left;

    if (right < minHeap->size && minHeap->array[right].count < minHeap->array[smallest].count)
        smallest = right;

    if (smallest != idx) {
        swap(&minHeap->array[idx], &minHeap->array[smallest]);
        heapify(minHeap, smallest);
    }
}

// Function to add a new element to the heap
void add(MinHeap* minHeap, int value) {
    // Check if the value already exists in the heap
    for (int i = 0; i < minHeap->size; i++) {
        if (minHeap->array[i].value == value) {
            // Increment count and heapify
            minHeap->array[i].count++;
            heapify(minHeap, i);
            return;
        }
    }

    // Check if the heap is full
    if (minHeap->size == minHeap->capacity) {
        printf("Heap is full. Cannot add more elements.\n");
        return;
    }

    // Add a new node with count 1
    minHeap->array[minHeap->size] = createHeapNode(value);
    minHeap->size++;

    // Heapify bottom-up
    int i = minHeap->size - 1;
    while (i > 0 && minHeap->array[(i - 1) / 2].count > minHeap->array[i].count) {
        swap(&minHeap->array[i], &minHeap->array[(i - 1) / 2]);
        i = (i - 1) / 2;
    }
}

// Function to remove an element from the heap
void removeMin(MinHeap* minHeap) {
    if (minHeap->size == 0) {
        printf("Heap is empty. Cannot remove element.\n");
        return;
    }

    // Decrement count of the root
    minHeap->array[0].count--;

    // If count becomes 0, remove the root and rearrange the heap
    if (minHeap->array[0].count == 0) {
        minHeap->array[0] = minHeap->array[minHeap->size - 1];
        minHeap->size--;
        heapify(minHeap, 0);
    }
}

// Function to free memory allocated for the heap
void freeMinHeap(MinHeap* minHeap) {
    free(minHeap->array);
    free(minHeap);
}

void sortSwap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int partition (int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            sortSwap(&arr[i], &arr[j]);
        }
    }
    sortSwap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int findLeastNumOfUniqueInts(int* arr, int arrSize, int k) {
    // Sort the array before adding it to the heap
    quickSort(arr, 0, arrSize - 1);

    MinHeap* minHeap = createMinHeap(arrSize);

    for (int i = 0; i < arrSize; i++) {
        add(minHeap, arr[i]);
    }

    for (int i = 0; i < k; i++) {
        removeMin(minHeap);
    }

    int result = minHeap->size;
    freeMinHeap(minHeap);
    return result;
}


int main() {
    // Example usage
    int arr[] = {2, 1, 1, 3, 3, 3,4};
    int k = 3;
    int arrSize = sizeof(arr) / sizeof(arr[0]);
    return findLeastNumOfUniqueInts(arr, arrSize, k);
}

#include <stdio.h>
#include <mshtmlc.h>

struct LinkedListNode {
    int val;
    int count;
    struct LinkedListNode *next;
};

void add(int val, struct LinkedListNode **head) {
    short isAdded = 0;
    struct LinkedListNode *temp = (struct LinkedListNode*) malloc(sizeof(struct LinkedListNode));
    struct LinkedListNode *current = *head;
    while (current != NULL) {
        if (current->val == val) {
            printf("%d-a ", val);
            isAdded = 1;
            current->count++;
            if(current->next !=NULL && current->count > current->next->count) {
                struct LinkedListNode *nextNode = current->next;
                current->next = nextNode->next;
                nextNode->next = current;
                if(temp != NULL) {
                    temp->next = nextNode;
                } else {
                    *head = nextNode;
                }
            }
            break;
        }
        temp = current;
        current = current->next;
    }
    if (isAdded == 0) {
        printf("%d-b ", val);
        struct LinkedListNode *newNode = (struct LinkedListNode *)malloc(sizeof(struct LinkedListNode));
        newNode->val = val;
        newNode->count = 1;
        newNode->next = *head;
        *head = newNode;
    }
}
void removeKItem(int k,struct LinkedListNode** head){
    struct LinkedListNode *current = *head;
    int i;
    printf("\n");
    for(i=0; i<k; i++){
        if(current == NULL){
            break;
        }
        else if((current->count)>0) {
            printf("val is %d count is %d\n", current->val, current->count);
            current->count--;
            if(current->count == 0){
                current = current->next;
            }
        }
    }
    *head = current;
}


int findLeastNumOfUniqueInts(int *arr, int arrSize, int k) {
    struct LinkedListNode* head = NULL;
    int i;

    // Adding elements to the linked list
    for (i = 0; i < arrSize; i++) {
        add(arr[i], &head);
    }


    removeKItem(k, &head);

    struct LinkedListNode* current = head;  // Use a temporary variable
    int result=0;
    while (current != NULL) {
        result++;
        printf("val:%d count:%d ", current->val, current->count);  // Add space and format specifier
        current = current->next;
    }


    return result;  // Change this to the count of unique integers
}

int main() {
    int arr[] = {2,1,1,3,3,3};
    return findLeastNumOfUniqueInts(arr, 6, 3);
}


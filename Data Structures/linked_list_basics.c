#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
    int val;
    struct Node* next;
} Node;

typedef struct {
    Node* head;
    int size;
} MyLinkedList;

MyLinkedList* myLinkedListCreate() {
    MyLinkedList* obj = (MyLinkedList*)malloc(sizeof(MyLinkedList));
    obj->head=NULL;
    obj->size=0;
    return obj;
}

int myLinkedListGet(MyLinkedList* obj, int index) {
    if(index<0||index>=obj->size) return -1;
    Node* curr=obj->head;
    for(int i=0; i<index; i++){
        curr=curr->next;
    }
    return curr->val;
    
}

void myLinkedListAddAtHead(MyLinkedList* obj, int val) {
    Node* new=(Node*)malloc(sizeof(Node));
    new->val=val;
    new->next=obj->head;
    obj->head=new;
    obj->size++;
}

void myLinkedListAddAtTail(MyLinkedList* obj, int val) {
    if(obj->size==0){
        myLinkedListAddAtHead(obj, val);
        return;
    }
    Node* curr= obj->head;
    while(curr->next!=NULL){
        curr=curr->next;
    }
    Node* new=(Node*)malloc(sizeof(Node));
    new->val=val;
    new->next=NULL;
    curr->next=new;
    obj->size++;    

    //curr is the pointer or the finger that moves
}

void myLinkedListAddAtIndex(MyLinkedList* obj, int index, int val) {
    if (index < 0 || index > obj->size) return;
    if (index == 0) {
        myLinkedListAddAtHead(obj, val);
    } 
    else if (index == obj->size) {
        myLinkedListAddAtTail(obj, val);
    } 
    else {
        Node* curr=obj->head;
        for(int i=0; i<index-1; i++){
            curr=curr->next;
        }
        Node* new=(Node*)malloc(sizeof(Node));
        new->val=val;
        new->next=curr->next;
        curr->next=new;
        obj->size++;

    }
    
}

void myLinkedListDeleteAtIndex(MyLinkedList* obj, int index) {
    if(index<0||index >= obj->size) return;
    
    Node* del;
    if(index<=0){
        del=obj->head;
        obj->head=obj->head->next;
    } else {
        Node* curr=obj->head;
        for(int i=0; i<index-1; i++){
            curr=curr->next;
        }
        del = curr->next;
        curr->next = del->next;
    }
    free(del); 
    obj->size--;
}

void myLinkedListFree(MyLinkedList* obj) {
    Node* curr = obj->head;
    while (curr != NULL) {
        Node* next = curr->next;
        free(curr);
        curr = next;
    }
    free(obj);
}
/**
 * Your MyLinkedList struct will be instantiated and called as such:
 * MyLinkedList* obj = myLinkedListCreate();
 * int param_1 = myLinkedListGet(obj, index);
 
 * myLinkedListAddAtHead(obj, val);
 
 * myLinkedListAddAtTail(obj, val);
 
 * myLinkedListAddAtIndex(obj, index, val);
 
 * myLinkedListDeleteAtIndex(obj, index);
 
 * myLinkedListFree(obj);
*/
#include<stdlib.h>
#include<stdio.h>
  
typedef int item; 
struct Node
{
     item key;
     Node *Left, *Right;
};
typedef Node *Tree;  
  
int insertNode(Tree &T, item x) 
{
    if (T != NULL)
    {
        if (T->key == x) return -1;  
        if (T->key > x) return insertNode(T->Left, x); 
        else if (T->key < x) return insertNode(T->Right, x);   
    }
    T = (Node *) malloc(sizeof(Node));
    if (T == NULL) return 0;  
    T->key = x;
    T->Left = T->Right = NULL;
    return 1;  
}
void CreateTree(Tree &T)       
{
    int x;
    while (1)
    {
        printf("Nhap vao Node: ");
        scanf("%d", &x);
        if (x == 0) break;  
        int check = insertNode(T, x);
        if (check == -1) printf("Node da ton tai!");
        else if (check == 0) printf("Khong du bo nho");
  
    }
}
  
void LNR(Tree T)
{
     if(T!=NULL)
     {
      LNR(T->Left);
      printf("%d   ",T->key);
      LNR(T->Right);
     }
}
  
Node* searchKey(Tree T, item x)     
{
    if (T!=NULL)
    {
        if (T->key == x) { Node *P = T; return P;}
        if (T->key > x) return searchKey(T->Left, x);
        if (T->key < x) return searchKey(T->Right, x);
    }
    return NULL;
}
  
int delKey(Tree &T, item x)   
{
    if (T==NULL) return 0;
    else if (T->key > x) return delKey(T->Left, x);
    else if (T->key < x) return delKey(T->Right, x);
    else 
    {
        if (T->Left == NULL) T = T->Right;    
        else if (T->Right == NULL) T = T->Left;  
        else 
        {
            Node *Q = T->Left;
            while (Q->Right != NULL)
            {
                Q = Q->Right;
            }
            T->key = Q->key;
            delKey(T->Left, Q->key);
        }
    }
    return 1;
}
int main()
{
    Tree T;
    T=NULL; 
  
    CreateTree(T); 
    printf("Duyet cay theo LNR: \n");
    LNR(T);
    printf("\n");
  
    Node *P;
    item x;
    printf("Nhap vao key can tim: ");
    scanf("%d", &x);
    P = searchKey(T, x);
    if (P != NULL) printf("Tim thay key %d\n", P->key);
    else printf("Key %d khong co trong cay\n", x);
  
    if (delKey(T, x)) printf("Xoa thanh cong\n");
    else printf("Khong tim thay key %d can xoan", x);
    printf("Duyet cay theo LNR: \n");
    LNR(T);
    printf("\n");
    return 0;
}
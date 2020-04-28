package leetcode;

public class L2B {
    Node *queue[maxlen];
    int front = 0;
    int rear = 0;

    int count = 0;

    queue[(++rear)%maxlen] = pTree;
    int last = 1;
    while(front != rear){
        Node *tmp = queue[(++front)%maxlen];

        if(tmp->leftChild == NULL && tmp->rightChild == NULL){
            count += tmp->key;
            while(front != last){
                tmp = queue[(++front)%maxlen];
                if(tmp->leftChild == NULL && tmp->rightChild == NULL){
                    count += tmp->key;
                }
            }
            return count;
        }
        if(tmp->leftChild){
            queue[(++rear)%maxlen] = tmp->leftChild;
        }
        if(tmp->rightChild){
            queue[(++rear)%maxlen] = tmp->rightChild;
        }

        if(front == last){
            last = rear;
        }
    }
    return count;

}

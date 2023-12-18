package StackAndQueue;

public class QueueImp {
    public static void main(String[] args) {
        QueueImp obj = new QueueImp();
        obj.push(12);
        obj.push(16);
        obj.push(18);
        System.out.println("initially "+obj.topEle());
        System.out.println("pop "+obj.pop());
        System.out.println("topp "+obj.topEle());
        System.out.println("sizeeee "+obj.sizee());
    }
    int front = 0;
    int rear = -1;
    int count =0;
    int n=3;
    int[] queue = new int[n];
    void push(int x){
        if(n ==count) {
            System.out.println("queue is full");
            return;
        }
            rear++;
            queue[(rear%n)]=x;
            count++;
            System.out.println("The element pushed is " + x);
    }

      int pop(){
        if(count==0){
            System.out.println("no elements to pop");
            return -1;
        }
            int ele = queue[front];
            front = (front+1)%n;
            count--;
            return ele;
    }
    int topEle(){
        if(count==0){
            System.out.println("no elements to showw");
            System.exit(1);
        }
        return queue[front];
    }
    int sizee(){
        return count;
    }
}

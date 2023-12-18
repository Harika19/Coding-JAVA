package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackImpUsingQueue {
    public static void main(String[] args) {
        StackImpUsingQueue obj = new StackImpUsingQueue();
        obj.push(2);
        obj.push(3);
        System.out.println("topp "+obj.top());
        obj.push(4);
        obj.push(5);
        System.out.println("topp "+obj.top());
        System.out.println("popp "+obj.pop());
        System.out.println("topp "+obj.top());
        System.out.println("sizeee "+obj.size());
    }
    Queue<Integer> q= new LinkedList<Integer>();
    void push(int x){
        q.add(x);
        for (int i=0;i<q.size()-1;i++){
            q.add(q.remove());
        }
    }
    int pop(){
        return q.remove();
    }

    int top(){
        return q.peek();
    }
    int size(){
        return  q.size();
    }


}

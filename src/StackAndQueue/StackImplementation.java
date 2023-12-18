package StackAndQueue;

public class StackImplementation {
    public static void main(String[] args) {
        StackImplementation obj = new StackImplementation();
        obj.push(12);
        obj.push(16);
        obj.push(18);
        System.out.println("initially "+obj.topEle());
        System.out.println("pop "+obj.pop());
        System.out.println("topp "+obj.topEle());
        System.out.println("sizeeee "+obj.sizee());
    }
    int top = -1;
    int[] stack = new int[1000];
    void push(int x){
        top++;
        stack[top]=x;
    }
    int pop(){
        int x = stack[top];
        top--;
        return x;
    }
    int topEle(){
        return stack[top];
    }
    int sizee(){
        return top+1;
    }
}

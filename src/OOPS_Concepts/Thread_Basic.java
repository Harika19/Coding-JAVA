package OOPS_Concepts;

class A6 extends Thread{
    public void run(){ // name should be run only , when start is called it will execute run method
        for(int i=0;i<10;i++){
            System.out.println("1111");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class B6 extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("3333");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class Thread_Basic {
    public static void main(String[] args) {
        A6 obj1 = new A6();
        obj1.start(); // new thread
        B6 obj2 = new B6();
        obj2.start(); // new thread
    }

}

package OOPS_Concepts;


class Student{
    String name;
    int roll_no;
    static String section;



    public void show(){
        System.out.println("non-static");;
    }

    public static void show1(){
        System.out.println("static");;
    }

    private int no; //  only way to access private var is to use methods'
    public void set(int a){ // binding data to methods
        no = a;
    }
    public Integer get(){
        return no;
    }
}

public class Array_of_objs {

    public static void main(String[] args) {
        Student obj = new Student();
        obj.name = "harika";
        obj.roll_no = 1;
        Student.section="A";
       //  obj.no = "4"; // cannot access private var
        obj.set(11);
        System.out.println(obj.get());

        Student obj2 = new Student();
        obj2.name = "harika2";
        obj2.roll_no = 1;
        Student.section="A";

        Student obj3 = new Student();
        obj3.name = "harika3";
        obj3.roll_no = 1;
        Student.section="A"; //static

        Student Students[] = new Student[3];
        Students[0]=obj;
        Students[1]=obj2;
        Students[2]=obj3;

        // Student.show();  errr
        Student.show1(); // cant access non-static var in static method

        for(int i=0;i<3;i++){
            System.out.println(Students[i].name+"... "+"......" + Student.section); // static var can be shared by all objs
        }
    }
}



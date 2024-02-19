package SOLID;


1. Single Responsibility Principle (SRP)
Definition: A class should have only one reason to change, meaning it should have only one job or responsibility.

Without SRP Example:
A class that handles both user data management and user interface rendering violates SRP.


public class UserManagement {
    public void addUser(String user) {
        // Add user to the database
    }

    public void displayUser(String user) {
        // Display user details on the screen
    }
}

With SRP Example:
Splitting the responsibilities into separate classes aligns with SRP.

=========================================================================================================

public class UserDataManager {
    public void addUser(String user) {
        // Add user to the database
    }
}

public class UserDisplay {
    public void displayUser(String user) {
        // Display user details on the screen
    }
}
=========================================================================================================

2. Open/Closed Principle (OCP)
Definition: Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

Without OCP Example:
A class that requires modification to add new features violates OCP.


public class DiscountCalculator {
    public double calculateDiscount(String type) {
        if (type.equals("Standard")) {
            return 0.1;
        } else if (type.equals("Premium")) {
            return 0.2;
        }
        return 0;
    }
}
With OCP Example:
Using abstraction, new discount types can be added without modifying existing code.
=========================================================================================================

interface DiscountStrategy {
    double calculateDiscount();
}

class StandardDiscount implements DiscountStrategy {
    public double calculateDiscount() {
        return 0.1;
    }
}

class PremiumDiscount implements DiscountStrategy {
    public double calculateDiscount() {
        return 0.2;
    }
}

public class DiscountCalculator {
    public double calculateDiscount(DiscountStrategy discountStrategy) {
        return discountStrategy.calculateDiscount();
    }
}
=========================================================================================================


3. Liskov Substitution Principle (LSP)
Definition: Objects of a superclass shall be replaceable with objects of its subclasses without affecting the correctness of the program.

Without LSP Example:
Subclass Square cannot be used interchangeably with its superclass Rectangle without altering the behavior of Rectangle.


public class Rectangle {
    protected int width, height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

public class Square extends Rectangle {
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
With LSP Example:
Refactor by decoupling Square and Rectangle into separate classes that do not inherit from each other but adhere to a common interface.

=========================================================================================================
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}

=========================================================================================================

4. Interface Segregation Principle (ISP)
Definition: Clients should not be forced to depend upon interfaces they do not use.

Without ISP Example:
A bulky interface that requires implementers to use methods they don't need violates ISP.


interface Worker {
    void work();
    void eat();
}

class HumanWorker implements Worker {
    public void work() {
        // working
    }

    public void eat() {
        // taking a lunch break
    }
}

class RobotWorker implements Worker {
    public void work() {
        // working
    }

    public void eat() {
        // Robots don't eat, so this method is unnecessary
    }
}
With ISP Example:
Splitting the interface so that implementers only need to use what they require aligns with ISP.

=========================================================================================================
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    public void work() {
        // working
    }

    public void eat
=========================================================================================================
5. Dependency Inversion Principle (DIP)
   Definition: The Dependency Inversion Principle (DIP) states two essential things:

High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).
Abstractions should not depend upon details. Details (concrete implementations) should depend upon abstractions.
DIP aims to reduce the direct coupling between software modules, making it easier to change and maintain the software. By depending on abstractions rather than concrete classes, software components become more reusable and flexible.

Example without Dependency Inversion Principle:
In this example, a high-level module (FileContentProcessor) directly depends on a low-level module (FileReader). This makes FileContentProcessor difficult to test, modify, or extend because it is tightly coupled to FileReader.


class FileReader {
String read(String path) {
// Reads content from the file
return "Content of the file";
}
}

class FileContentProcessor {
private FileReader reader = new FileReader();

    void process(String path) {
        String content = reader.read(path);
        // Process the content
    }
}


Example with Dependency Inversion Principle:
To adhere to DIP, we introduce an abstraction (IReader) that both the high-level module and low-level module depend on. Now, FileContentProcessor depends on an abstraction rather than a concrete class, making it more flexible and easier to test or extend.
=========================================================================================================
public class Main {

    public static void main(String[] args) {
        // Example usage
        IReader fileReader = new FileReader();
        FileContentProcessor contentProcessor = new FileContentProcessor(fileReader);

        // Provide the path to the file you want to process
        String filePath = "path/to/your/file.txt";
        contentProcessor.process(filePath);
    }
}

interface IReader {
String read(String path);
}

class FileReader implements IReader {
public String read(String path) {
// Reads content from the file
return "Content of the file";
}
}

class FileContentProcessor {
private IReader reader;

    public FileContentProcessor(IReader reader) {
        this.reader = reader;
    }

    void process(String path) {
        String content = reader.read(path);
        // Process the content
        System.out.println("Processed content: " + content);
    }
}

=========================================================================================================
In this improved example, FileContentProcessor can work with any implementation of IReader, not just FileReader. This makes it easy to introduce new ways of reading data (e.g., from a network, in-memory source, etc.) without changing the FileContentProcessor class. We can also easily mock or stub IReader in tests, which makes testing FileContentProcessor simpler and more reliable.

Benefits of Dependency Inversion Principle
Decoupling: High-level modules are decoupled from low-level modules, leading to a system that is easier to refactor, change, or upgrade.
Flexibility: It's easy to switch between different implementations of the abstractions without changing the high-level modules.
Testability: By depending on abstractions, it becomes much easier to create mock implementations for testing.
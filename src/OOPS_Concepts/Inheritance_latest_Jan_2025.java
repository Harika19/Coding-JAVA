public class Main
{

	static class Base {
		Base() {
			System.out.println(
			    "Base Class Constructor Called ");
		}

		public void hello() {
			System.out.println("Hello Base");
		}
	}

	static class Derived extends Base {
		Derived() {
			super();
			System.out.println(
			    "Derived Class Constructor Called ");
		}

		@Override
		public void hello() {
			System.out.println("Hello Derived");
		}
	}


	public static void main(String[] args) {

		System.out.println("\n-- Derived calling Derived class --\n");

		Derived derived = new Derived();
		derived.hello();

		System.out.println("\n-- Base calling Derived class --\n");

		Base baseDerived = new Derived();
		baseDerived.hello();

		System.out.println("\n-- Base calling Base class --\n");

		Base base = new Base();
		base.hello();
	}
}

/*

Output:

-- Derived calling Derived class --

Base Class Constructor Called 
Derived Class Constructor Called 
Hello Derived

-- Base calling Derived class --

Base Class Constructor Called 
Derived Class Constructor Called 
Hello Derived

-- Base calling Base class --

Base Class Constructor Called 
Hello Base

*/

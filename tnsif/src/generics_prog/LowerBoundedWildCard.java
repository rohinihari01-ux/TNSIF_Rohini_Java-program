package generics_prog;

import java.util.List;

public class LowerBoundedWildCard {
	
	public static void main(String[] args) 
	{
		GenericMethod obj = new GenericMethod();
		Integer[] intarray = { 10, 20, 30, 40 };
		String[] str = { "java", "programming", "learning" };
		Person p[]=new Person[] {new Person("Nitin", "Pune"), new Person("Manoj", "Mumbai"),new Person("Mayur", "Delhi")};
		
		//Display Integer Array 
		obj.displayArrayElements(intarray);
		
		//Display String Array
		obj.displayArrayElements(str);
		
		//Display Person Array
		obj.displayArrayElements(p);
	}

	public static void displayNumbers(List<Integer> intList) {
		// TODO Auto-generated method stub
		
	}

	public static void displayNumber(List<Number> numberList) {
		// TODO Auto-generated method stub
		
	}

}
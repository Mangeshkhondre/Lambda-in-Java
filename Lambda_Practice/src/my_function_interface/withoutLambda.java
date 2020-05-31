package my_function_interface;

public class withoutLambda implements HelloInterface 
{
	public void greet()
	{
		System.out.println("Good Morning");
	}
	
	public static void main(String... args)
	{
		System.out.println("Without using Lambda funtion..");
		withoutLambda obj1 = new withoutLambda();
		obj1.greet();
	}

}

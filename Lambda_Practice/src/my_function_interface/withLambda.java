package my_function_interface;

public class withLambda 
{
	public static void main(String...strings )
	{
		System.out.println();
		HelloInterface hiObj = () -> System.out.println("Good morning");
		hiObj.greet();
	}

}

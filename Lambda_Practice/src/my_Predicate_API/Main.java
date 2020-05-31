package my_Predicate_API;
public class Main 
{
	public static void main(String[] args) 
	{
		Predicate<String> p1 = s -> s.length() < 20 ;
		boolean b1 = p1.test("Mangesh");
		System.out.println("Is \"Mangesh\" less than 20 chars? : "+b1);
		
		
		Predicate<Integer> p2 = i -> i%2==0;
		System.out.println("\nIs 6 even? : "+ p2.test(6));
		System.out.println("Is 5 even? : "+ p2.test(5));
		
		// Chaining of predicate
		Predicate<String> p3 = s -> s.length()<10;
		Predicate<String> p4 = s -> s.length()>5;
		Predicate<String> p5 = p3.and(p4);
		System.out.println("\nis Mangesh acceptable ? : "+p5.test("Mangesh"));
		System.out.println("is HULK acceptable ? : "+p5.test("HULK"));
		
		Predicate<Integer> p6 = i -> i%3==0;
		Predicate<Integer> p7 = i -> i%5==0;
		Predicate<Integer> p8 = p6.or(p7);
		System.out.println("\n 6 divisible by 3 or 5 : "+p8.test(6));
		System.out.println(" 10 divisible by 3 or 5 : "+p8.test(10));
		System.out.println(" 7 divisible by 3 or 5 : "+p8.test(7));
		
		// static method 
		Predicate<String> p9 = Predicate.isEqualTo("NO");
		System.out.println("\n p9 on NO : "+p9.test("NO"));
		System.out.println(" p9 on OK : "+p9.test("OK"));
		
		Predicate<Integer> p10 = Predicate.isEqualTo(100);
		System.out.println("\n 100 isEqualTo(100) : "+p10.test(100));
		System.out.println(" 50  isEqualTo(100) : "+p10.test(50));
		
	}
}

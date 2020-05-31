package my_Predicate_API;

@FunctionalInterface
public interface Predicate<T> 
{
	public boolean test(T t);

	public default Predicate<T> and(Predicate<T> other)
	{
		return t -> test(t) && other.test(t);
		
	}

	public default Predicate<T> or(Predicate<T> other)
	{
		return t -> test(t) || other.test(t);
	}
	
	/* only for String comparison
	 * public static Predicate<String> isEqualTo(String other) { return s ->
	 * s.equals(other); // equals() of String }
	 */
	
	// Generic 
	public static <U> Predicate<U> isEqualTo(U u)
	{
		return s -> s.equals(u);
	}
	
	
}

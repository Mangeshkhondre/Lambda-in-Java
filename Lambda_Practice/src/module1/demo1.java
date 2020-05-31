package module1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class byRollNo implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2) 
	{		
		if(s1.getRollno()>s2.getRollno())
			return 1;
		else if(s1.getRollno()<s2.getRollno())
			return -1;
		else
			return 0;
	}
}




// first compare by name 
// if name same compare by age
class byNameAge implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		int nameComparison = s1.getName().compareToIgnoreCase(s2.getName());
		if(nameComparison != 0) // names are different 
			return nameComparison;
		else 					// name are same
		{
			int ageComparison = s1.getAge()-s2.getAge();  // sort by age
			return ageComparison;
		}
	}
}



public class demo1 
{

	public static void main(String args[]) 
	{
		Student s1 = new Student(1,"b",23);
		Student s2 = new Student(3,"a",25);
		Student s3 = new Student(2,"d",23);
		Student s4 = new Student(4,"c",20);
		Student s5 = new Student(9,"c",19);
		Student s6 = new Student(5,"d",23);
		
		ArrayList<Student> al = new ArrayList<>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		al.add(s6);
		
		System.out.println("UNSORTED = ");
		displayArrayList(al);
		
		// similar to byRollNo()
		// Anonymous Class :     byrollno=instance of anonymous class
		Comparator<Student> byrollno = new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {				
				if(s1.getRollno()>s2.getRollno())
					return 1;
				else if(s1.getRollno()<s2.getRollno())
					return -1;
				else
					return 0;
			}	
		};		
		Collections.sort(al, byrollno);
//		Collection.sort(al,new byRollNo());		
		System.out.println("Sorted by Roll No. = ");
		displayArrayList(al);
		
//		Lambda Expression 		
		Comparator<Student> compAge = ( s10, s20) -> Integer.compare(  s10.getAge(), s20.getAge() ) ;	
		Collections.sort(al,compAge);
		System.out.println("Sorted by Age = ");
		displayArrayList(al);
		
		
		Collections.sort(al,new byNameAge());
		System.out.println("Sorted by Name,Age = ");
		displayArrayList(al);
		
		
	}

	private static void displayArrayList(ArrayList<Student> al) 
	{
		System.out.println("rollno\tname\tage");
		for(Student s:al)
			System.out.println(s.getRollno()+"\t"+s.getName()+"\t"+s.getAge());
		System.out.println("------------------------------------------------");
		
		
	}

	
}

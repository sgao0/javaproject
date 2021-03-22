import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Person p = new Person(null, 0);
		String userName;
		int userAge;
		long userPhone;
		
		System.out.println("Enter name age phone");
		userName = s.nextLine();
		userAge = s.nextInt();
		userPhone = s.nextLong();
		
		p.setName(userName);
		p.setAge(userAge);
		p.setPhone(userPhone);
		
		System.out.println(p.toString());
		
		Elements e = new Elements(null, null, 0, 0.0);
		String eleName;
		String eleSym;
		int eleNum;
		double eleWeight;
		
		System.out.println("Enter element information");	
		eleName = s.next();
		eleSym = s.next();
		eleNum = s.nextInt();
		eleWeight = s.nextDouble();
			
		e.setName(eleName);
		e.setSymbol(eleSym);
		e.setNum(eleNum);
		e.setWeight(eleWeight);
			
		System.out.println(e.toString());	
	
	}
}

package reflection.metadata;

@BetaVersion
@Copyright("2015 A564571@FIL.COM")
@Author(firstName="Saurabh", lastName="Chugh")
public class MyClass {

	public static void main(String[] args) {
		boolean isBeta = MyClass.class.isAnnotationPresent(BetaVersion.class);
		System.out.println("isBeta= "+isBeta);
		
		String copyright = MyClass.class.getAnnotation(Copyright.class).value();
		System.out.println("Copyright = "+copyright);
		
		String firstName = MyClass.class.getAnnotation(Author.class).firstName();
		System.out.println("firstName is= "+firstName);
		String lastName = MyClass.class.getAnnotation(Author.class).lastName();
		System.out.println("lastName is= "+lastName);
	}

}

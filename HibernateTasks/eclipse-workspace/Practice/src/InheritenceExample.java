
public class InheritenceExample {
	int a =10;
	InheritenceExample(){
		System.out.println("Base Class");
	}
}
class ChildClass extends InheritenceExample{
	static int b=20;
	static int sum=0;
	public static void main(String args[]) {
		ChildClass cc = new ChildClass();
		System.out.println(cc.a);
	}	
}

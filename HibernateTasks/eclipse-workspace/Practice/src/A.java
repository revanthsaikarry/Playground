public class A {
	int j = 10;
	static int k = 20;
	static String str = "Static string";
	String str1 = "ABC";
	A(){
		int i=100;
		System.out.println(i+10+"Constructor"+i+10);
	}
	public static void main(String args[]) {
		A a = new A();
		A a1 = new A();
		A a2 = new A();
		System.out.println(a.str);
		System.out.println(a1.str);
		System.out.println(a2.str);
		
		a1.str = "Changed text";
		
		System.out.println(a.str);
		System.out.println(a1.str);
		System.out.println(a2.str);
		
		System.out.println(a.str1);
		System.out.println(a1.str1);
		System.out.println(a2.str1);
		
		a1.str1 = "Changed text";
		
		System.out.println(a.str1);
		System.out.println(a1.str1);
		System.out.println(a2.str1);
		
		System.out.println(a.j);
		System.out.print(k);//static variable can be called without using any object
		
	}
}

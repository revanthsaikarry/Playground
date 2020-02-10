
class UserDefineException extends Exception{
	UserDefineException(String s){
		super(s);
	}
	} 
public class ExceptionHandlingPractice {
	public static void main(String args[]) throws UserDefineException {
		int age=17;
		if(age<18) {
			throw new UserDefineException("You are Not Allowed...!");
		}
		else {
			System.out.print("You are Allowed..!");
		}
	}
}

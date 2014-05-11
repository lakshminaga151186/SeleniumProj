package corejava;

public class Welcome {
	String str;

	/*
	 * public class Sample { str = Mahesh; System.out.println("Invite"+str); }
	 * public class Sample1 { str =Suresh; }
	 */
	public void task1(){
		str ="Mahesh";
		System.out.println("Invite" +" "+str);
		
	}
	public void task2(){
		str = "Naresh";
		System.out.println("Invite" +" " +str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Welcome wl = new Welcome();
    wl.task1();
    wl.task2();
	}

}

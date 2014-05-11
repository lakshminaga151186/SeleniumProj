package TestNG;

import org.testng.annotations.Test;

public class ReverseString {
  @Test
  public void f() {
	  String str="Nagesh";
	  System.out.println(str.length()); 
	  for(int i=str.length()-1; i>=0; i--)
	  {
		  System.out.println(str.charAt(i));
	  }
	  
	  
	  
	
  }
}

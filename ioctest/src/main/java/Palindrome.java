import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original, reverse = ""; // Objects of String class
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter a string to check if it's a palindrome");
	    original = in.nextLine().toLowerCase();
	    	    
	    int length = original.length();
	    
//	    for (int i = length - 1; i >= 0; i--)
//	      reverse = reverse + original.charAt(i);
	    
	    char[] strArr = original.toCharArray();
	    
	    String temp = "";
	    
	    for(int i = strArr.length-1; i>=0; i--) {
	    	temp = temp + strArr[i];
	    }
	    
	    //System.out.println(original);//cek isi variabel original
	    //System.out.println(temp);//cek isi variabel temp
	    
	    if(original.equals(temp)) {
	    	System.out.println("Kalimat atau kata diatas adalah palindrome");
	    }else {
	    	System.out.println("Kalimat atau kata diatas bukan palindrome");
	    }
	    

//	    if (original.equals(reverse))
//	      System.out.println("The string is a palindrome.");
//	    else
//	      System.out.println("The string isn't a palindrome.");
	    
	    in.close();
	}

}

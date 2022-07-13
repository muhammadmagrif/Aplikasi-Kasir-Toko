package xa.ioctest.classes;

import java.util.Scanner;

public class Palindrome {
	private String kalimat;
	
	public void setKalimat (String kalimat) {
		this.kalimat = kalimat;
	}
	
	public String getKalimat() {
		return kalimat;
	}
	
	public void cekPalindrome() {
		
		String original = getKalimat();
		String reverse = ""; // Objects of String class
//	    Scanner in = new Scanner(System.in);
//	    System.out.println("Enter a string to check if it's a palindrome");
	    original = original.toLowerCase();
	    
	    int length = original.length();
	    
	    for (int i = length - 1; i >= 0; i--)
	    	reverse = reverse + original.charAt(i);
	    
	    if (original.equals(reverse))
	      System.out.println("The string is a palindrome.");
	    else
	      System.out.println("The string isn't a palindrome.");
	}
}

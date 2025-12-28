/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		return isPalindromeHelper(s, 0, s.length() - 1);
    }

	private static boolean isPalindromeHelper(String s , int left, int right){
		if(left >= right){
			return true;
		}
		if(s.charAt(right) != s.charAt(left)){
			return false;
		}
		return isPalindromeHelper(s, left + 1, right - 1);
	}
}
import java.util.Scanner;

public class palindrome_checker {
    public static void main(String[] args) {

        String inp_str;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a phrase or a word : ");
            inp_str = scan.nextLine();
        }

        String palindrome = "";

        for(int i=inp_str.length()-1 ; i>=0; i--){
            palindrome = inp_str.charAt(i) + palindrome;
        }

        if(palindrome.equals(inp_str)){
            System.out.println("Given String "+"\""+inp_str+"\" is a palindrome");
        }else{
            System.out.println("Given String "+"\""+inp_str+"\" is not a palindrome");
        }
    }
}

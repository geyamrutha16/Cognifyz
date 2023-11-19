package second_level;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Strength_checker{
    
        String check_My_String (String password){
        boolean low = false, upper = false, digit = false , special = false;
            int length = password.length();
            Set<Character> set = new HashSet<Character>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                          '*', '(', ')', '-', '+'));

            for(int i=0; i<password.length(); i++){
                if(Character.isLowerCase(password.charAt(i)))
                    low = true;
                if(Character.isUpperCase(password.charAt(i)))
                    upper = true;
                if(Character.isDigit(password.charAt(i)))
                    digit = true;
                if (set.contains(password.charAt(i)))
                    special = true;
            }

            if(low == true && upper == true && special == true && digit == true && (length>=8)){
                return "Strong";
            }
            else if(low == true && upper == true && special == true && digit == true){
                return "Medium --> Length of Password is not equal to 8";
            }
            else if(low == true && upper == true && special == true){
                return "Medium --> Missing Digits and Length of Password is not equal to 8";
            }
            else{
                return "Weak  --> Check the conditions to make Password Strong";
            }
    }
}

public class Password_strength_checker {
    
    public static void main(String[] args) {
        String Your_password ;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter your Password : ");
            Your_password = scan.nextLine();
        }

        Strength_checker check = new Strength_checker();
        System.out.println(check.check_My_String(Your_password));
    }
}

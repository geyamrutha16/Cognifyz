import java.lang.Math;
import java.util.Scanner;

class Generate{

    String password = "";

    void small(int length,int len){
        char[] small = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0; i<len; i++){
            int a = (int) (Math.random()*length);
            password = password + small[a];
        }
    }

    void capital(int length,int len){
        char[] capital = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i=0; i<len; i++){
            int a = (int) (Math.random()*length);
            password = password + capital[a];
            }
    }

    void digits(int length,int len){
        int[] digits = {0,1,2,3,4,5,6,7,8,9};
        for(int i=0; i<len; i++){
            int a = (int) (Math.random()*length);
            password = password + digits[a];
            }
    }

    void special_character(int length,int len){
        char[] special_character = {'!','@','#','$','%','^','&','*','/','?','(',')','-','+'};
        for(int i=0; i<len; i++){
            int a = (int) (Math.random()*length);
            password = password + special_character[a];
            }
    }
}
public class Password_generator {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter Length of your Password : ");
            int length = scan.nextInt();  

            scan.nextLine();

            System.out.println("Contents of a Password");
            System.out.println("1. Capital Letters");
            System.out.println("2. Small Letters");
            System.out.println("3. Digits");
            System.out.println("4. Special Characters");
            System.out.print("Enter your specifications space seperated: ");
            String s = scan.nextLine();
            String contents[] = s.split(" ");
            int len = contents.length;

            Generate obj = new Generate();
            for(int i=0 ; i<len; i++){
                int a = Integer.parseInt(contents[i]);
                if(a == 1)
                    obj.capital(length,(int)length/len);
                if(a == 2)
                    obj.small(length,(int)length/len);
                if(a == 3)
                    obj.digits(length,(int)length/len);
                if(a == 4)
                    obj.special_character(length,(int)length/len);
            }
            System.out.println("Password is : "+obj.password);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

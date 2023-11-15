package first_level;

import java.util.Scanner;

class Temp_Convert{

    Scanner scan = new Scanner(System.in);
    double out_temp = 0d, inp_temp = 0d;

    void celsius_to_fahrenheit(){
        System.out.print("Enter Temperature to convert : ");
        inp_temp = scan.nextDouble(); 
        out_temp = ( inp_temp + 32 ) * (9/5);
        System.out.println("Temperature in Fahrenheit : "+out_temp+" F");
    }

    void celsius_to_kelvin(){
        System.out.print("Enter Temperature to convert : ");
        inp_temp = scan.nextDouble();
        out_temp = inp_temp + 273.15;
        System.out.println("Temperature in Kelvin : "+out_temp+" K");
    }

    void fahrenheit_to_celsius(){
        System.out.print("Enter Temperature to convert : ");
        inp_temp = scan.nextDouble();
        out_temp = (5/9) * (inp_temp - 32);
        System.out.println("Temperature in Celsius : "+out_temp+" C");
    }

    void fahrenheit_to_kelvin(){
        System.out.print("Enter Temperature to convert : ");
        inp_temp = scan.nextDouble();
        out_temp = (inp_temp - 32) / 1.8 + 273.15;
        System.out.println("Temperature in Kelvin : "+out_temp+" K");
    }

    void kelvin_to_celsius(){
        System.out.print("Enter Temperature to convert : ");
        inp_temp = scan.nextDouble();
        out_temp = inp_temp - 273.15;
        System.out.println("Temperature in Celsuis : "+out_temp+" C");
    }

    void kelvin_to_fahrenheit(){
        System.out.print("Enter Temperature to convert : ");
        inp_temp = scan.nextDouble();
        out_temp = (9/5) *(inp_temp - 273.15) + 32;
        System.out.println("Temperature in Fahrenheit : "+out_temp+" F");
    }
}

public class Temperature_convertor{
    public static void main(String[] args){
        int choice;
        int i = 1;

        Temp_Convert temp = new Temp_Convert();

        while(i <= 1){
            System.out.println("Options : ");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Celsius to Kelvin");
            System.out.println("3. Fahrenheit to Celsuis");
            System.out.println("4. Fahrenheit to Kelvin");
            System.out.println("5. Kelvin to Celsius");
            System.out.println("6. Kelvin to Fahrenheit");
            try(Scanner scan = new Scanner(System.in)){
                System.out.print("Enter your Option : ");
                choice = scan.nextInt();
                switch(choice){
                    case 1:
                        temp.celsius_to_fahrenheit();
                        break;
                    case 2:
                        temp.celsius_to_kelvin();
                        break;
                    case 3:
                        temp.fahrenheit_to_celsius();
                        break;
                    case 4:
                        temp.fahrenheit_to_kelvin();
                        break;
                    case 5:
                        temp.kelvin_to_celsius();
                        break;
                    case 6:
                        temp.kelvin_to_fahrenheit();
                        break;
                    default:
                        System.out.println("Enter a valid option");
                }
            }
            i++;
        }
    }
}



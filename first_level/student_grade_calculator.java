import java.util.Scanner;

public class student_grade_calculator {
    public static void main(String[] args) {
        int no_of_grades = 0,sum = 0;
        float avg = 0f;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter number of grades : ");
            no_of_grades = scan.nextInt();

            int[] grades = new int[no_of_grades];

            for(int i=0; i<no_of_grades; i++){
                System.out.print("Enter  grade "+(i+1)+" : ");
                grades[i] = scan.nextInt();
            }
        
        for(int i=0; i<no_of_grades; i++){
               sum = sum + grades[i];
        }
        }
            avg = sum/no_of_grades;

        System.out.print("Average grade of student  : "+avg);

    }
}

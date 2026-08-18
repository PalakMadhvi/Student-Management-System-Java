import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        //scanner used for input from user
    Scanner sc = new Scanner(System.in);
    //ArrayList store multiple student objects
    ArrayList<student> students =new ArrayList<>();
    // Display menu repeatedly until the user chooses Exit
    while(true){
        System.out.println("\n====Student Management System====");
        System.out.println("1. Add student");
        System.out.println("2. View student");
        System.out.println("3. Update student");
        System.out.println("4. delete");
        System.out.println("5. exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            //Add new student
            case 1:
                System.out.println("Enter roll number: ");
                int rollNumber =sc.nextInt();
                //check whether the roll number already exists
                boolean exists=false;
                for(student s:students){
                    if(s.rollNumber==rollNumber){
                        exists=true;
                        break;
                    }
                }
                if(exists){
                    System.out.println("Roll number already exists!");
                    break;
                }
                sc.nextLine();
                System.out.println("Enter student name:  ");
                String name=sc.nextLine();
                //Validate marks between 0 and 100
                double marks;
                while(true){
                System.out.println("Enter student marks(0-100): ");
                if(sc.hasNextDouble()){
                    marks=sc.nextDouble();
                    if(marks>=0&&marks<=100){
                        break;
                }else{

                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                }
                }else{
                    System.out.println("Invalis input! Please enter a number.");
                    sc.next();
                }
            }
                // create a student object
                student s1=new student(rollNumber, name, marks);
                //Add student object to ArrayList
                students.add(s1);
                System.out.println("Student added successfully!");
            case 2:    //Display all student
                System.out.println("\n--- Student List ---");
                if(students.isEmpty()){
                    System.out.println("No student found.");
                }
                else{
                    for(student s : students){
                        s.displayStudent();
                        System.out.println("-----------------");
                    }
                }
                break;
                //update student information
            case 3:
                System.out.println("Enter roll number of student to update: ");
                int updateRoll = sc.nextInt();
                boolean found = false;
                for(student s :students){
                    if(s.rollNumber == updateRoll){
                        sc.nextLine();
                        System.out.println("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.println("Enter new marks: ");
                        double newMarks = sc.nextDouble();
                        s.name=newName;
                        s.marks = newMarks;
                        System.out.println("Student update successfully!");
                         found =true;
                         break;
                    }
                }
             if(!found){
                System.out.println("Student not found");
            }
            break;
            //Delete a student
            case 4:
                System.out.println("Enter roll number of student to delete: ");
                int deleteRoll =sc.nextInt();
                boolean deleted = false;
                for(int i=0;i<students.size();i++){
                    if(students.get(i).rollNumber == deleteRoll){
                        students.remove(i);
                        System.out.println("Student deleted succesfully!");
                        deleted= true;
                        break;
                    }
                }
                if(!deleted){
                    System.out.println("Student not found.");
                }
                // Exit the application
            case 5:
                System.out.println("Thank you for using Styudent Management System!");
                sc.close();
                return;
                // Handle invalid menu choices
                default:
                    System.out.println("Invalid choice. Please try again.");
        }
    }
}
}
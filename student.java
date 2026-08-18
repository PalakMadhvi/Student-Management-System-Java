public class student{
    int rollNumber;
    String name;
    double marks;

    //Constructor initializes student details
    student(int rollNumber,String name,double marks){
        this.rollNumber=rollNumber;
        this.name=name;
        this.marks=marks;

    }

    //Dispalay student information
    void displayStudent(){
        System.out.println("Roll Number: "+ rollNumber);
        System.out.println("Name: " +name);
        System.out.println("Marks: " +marks);
    }
    
}
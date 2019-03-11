import java.io.*;
import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

//Student class to store data of a student
class Student{

  String name;
  Double cgpa;
  Integer token;

  //Constructor of Student class
  Student(String name, double cgpa, int token){
    this.name=name;
    this.cgpa=cgpa;
    this.token=token;
  }
  //Compare function to compare two classes
  int compareTo(Student s){

    if(cgpa.compareTo(s.cgpa)!=0)
      return -(cgpa.compareTo(s.cgpa)); //Sort in descending order according to cgpa

    else{

      // if cgpa of both student is same
      if(name.compareTo(s.name)!=0)
        return (name.compareTo(s.name)); //sort in ascending order according to name

      else{
        // if name of both sudents are same
        return (token.compareTo(s.token)); //sort in ascending order according to token
      }

    }

  }

}
//Customised comparator function for Priority Queue
class CustomComparator implements Comparator<Student> {

  //Sorts according to this method
  public int compare(Student s1, Student s2) {

    //uses compare method of student class to commpare students
    return s1.compareTo(s2);

  }
}

public class StudentQueue{

  public static void main(String args[]){

    Scanner in=new Scanner(System.in);

    // queue to store students in queue according to given priority rules
    PriorityQueue<Student> queue =
        new PriorityQueue<Student>(new CustomComparator());

    int i,n=in.nextInt(); // n->number of instructions

    for(i=1;i<=n;i++){

      String task=in.next(); // instruction(ENTER|SERVED) given

      if(task.equals("ENTER")){

        String name=in.next();
        double cgpa=in.nextDouble();
        int token=in.nextInt();
        enter(queue,name,cgpa,token); // method to execute ENTER instruction

      }

      else
        served(queue); //method to execute SERVED instruction

    }

    result(queue); // result method to print the final result

  }

  public static void enter(PriorityQueue<Student> queue,
        String name, double cgpa, int token){

    // student object is created using constructor
    Student s=new Student(name,cgpa,token);
    queue.add(s); //added to queue

  }

  public static void served(PriorityQueue<Student> queue){
    //Student having most priority is served
    queue.poll();

  }

  public static void result(PriorityQueue<Student> queue){
    // prints all the remainig students after all instructions
    for(Student s:queue){

      System.out.println(s.name);

    }

  }
}

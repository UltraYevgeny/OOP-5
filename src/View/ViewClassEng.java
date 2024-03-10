package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/**
 * @author Пинжин Евгений Иванович
 * @version 1.1
 */
public class ViewClassEng implements iGetView{
    
    public void printAllStudents(List<Student> students){
        System.out.println("--------------------List of Students-------------------");
        for(Student s: students)
        {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }
    
    public String prompt(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The command: ");
        return in.nextLine();
    }

    public String enterDeleteNumber(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student number to be deleted: ");
        return in.nextLine();
    }
}

package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

public class FileModelClass implements iGetModel {

    private String fileName;

    public FileModelClass(String fileName) {
        System.out.println(" FileModelClass is initialized");
        this.fileName = fileName;
        
        try(FileWriter fw = new FileWriter(fileName, true)){
            fw.flush();    
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAllStudentToFile(List<Student> students)
    {
        // в (fileName, true) убрал true чтобы файл заново писался
        try(FileWriter fw = new FileWriter(fileName))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students  = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while(line!=null){
                String[] param = line.split(" ");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line = reader.readLine();
            }
            reader.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return students;
    }
    
    
    public void deletStudent(Integer number){
        List<Student> students  = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null){
                String[] param = line.split(" ");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line = reader.readLine();
            }
            reader.close();
            //System.out.println(students);
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        students.remove(number-1);
        saveAllStudentToFile(students);
    }
}

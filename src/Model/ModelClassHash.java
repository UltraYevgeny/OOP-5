package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;


/**
 * @author Пинжин Евгений Иванович
 * @version 1.1
 */
public class ModelClassHash implements iGetModel{
     private HashMap<Integer, Student> students = new HashMap<>();

    /**
     * @param studentsList
     * @apiNote Внутри класса конструктор создает на основании List'а коллекцию HashMap
     */
    public ModelClassHash(List<Student> studentsList) {
        System.out.println(" ModelClassHash is initialized");
        setAllStudents(studentsList);
    }

    /**
     * @param studentsList
     * @apiNote создает HashMap заново
     */
    private void setAllStudents(List<Student> studentsList) {
        Integer number = 1;
        students.clear();
        for (Student student : studentsList) {
            this.students.put(number, student);
            number++;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            studentsList.add(students.get(i+1));
        }
        return studentsList;
    }

    public void deletStudent(Integer number){
        List<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            studentsList.add(students.get(i+1));
        }
        studentsList.remove(number-1);
        setAllStudents(studentsList);

    }
}

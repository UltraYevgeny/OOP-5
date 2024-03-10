package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

public interface iGetView {
    public void printAllStudents(List<Student> students);
    public String prompt();

    /**
     * @apiNote метод для введения номера удоляемого студента из списка
     */
    public String enterDeleteNumber();
}

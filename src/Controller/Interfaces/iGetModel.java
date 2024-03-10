package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

public interface iGetModel {
    public List<Student> getAllStudents();

    /**
     * @param number
     * @apiNote метод для удоления студента из списка
     */
    public void deletStudent(Integer number);
}

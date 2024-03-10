package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClass;
import Model.Domain.Student;
import View.ViewClass;
import View.ViewClassEng;

public class ControllerClass {

    private iGetModel model;
    private iGetView view;
    private List<Student> bufferStudentList = new ArrayList<Student>();

    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    private boolean testData(List<Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() {
        // MVC
        // view.printAllStudent(model.getStudents());

        // MVP
        bufferStudentList = model.getAllStudents();
        if (testData(bufferStudentList)) {
            view.printAllStudents(bufferStudentList);
        } else {
            System.out.println("Список студентов пуст!");
        }

    }

    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        //iGetModel model;

        while (getNewIteration) {
                String command = view.prompt();
                com = Command.valueOf(command.toUpperCase());

            switch (com) {
                case EXIT:
                    getNewIteration = false;
                        System.out.println("Exit the Program!");

                    break;
                case LIST:
                    view.printAllStudents(model.getAllStudents());
                    break;
                //DELETE - данный кейз - для удоления студента
                case DELETE:
                String number = view.enterDeleteNumber();
                Integer numInt;
                numInt = Integer.parseInt(number);
                //проверка правильности ввода номера студента
                
                if (model.getAllStudents().size() < numInt
                            || numInt < 1){
                    System.out.println("Number Error!");
                    break;
                }
                
                //удаление студента из списка
                model.deletStudent(numInt);
                    break;
            }
        }
    }

}

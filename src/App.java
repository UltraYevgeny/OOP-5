import java.util.ArrayList;
import java.util.List;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.FileModelClass;
import Model.ModelClass;
import Model.ModelClassHash;
import Model.Domain.Student;
import View.ViewClass;
import View.ViewClassEng;

public class App {
    public static void main(String[] args) throws Exception {
       
        Student student1 = new Student("IvaN", 21);
        Student student2 = new Student("Anna", 25);
        Student student3 = new Student("Vasya", 22);
        Student student4 = new Student("Nastya", 27);
        Student student5 = new Student("VasilisA", 26);
        Student student6 = new Student("Karina", 25);
        Student student7 = new Student("Andrey", 22);
        Student student8 = new Student("Masha", 27);
        Student student9 = new Student("Irina", 28);
        Student student10 = new Student("NikolaY", 30);

        List<Student> studList1 = new ArrayList<>();
        studList1.add(student1);
        studList1.add(student2);
        studList1.add(student3);

        List<Student> studList2 = new ArrayList<>();
        studList2.add(student4);
        studList2.add(student5);

        List<Student> studList3 = new ArrayList<>();
        studList3.add(student6);
        studList3.add(student7);
        studList3.add(student8);
        studList3.add(student9);
        studList3.add(student10);
        

        //System.out.println(studList);

        ModelClassHash mcHash = new ModelClassHash(studList1);
        FileModelClass fmClass = new FileModelClass("StudentDB.csv");
        ModelClass mClass = new ModelClass(studList2);
        
        //содает заново список в файле
        fmClass.saveAllStudentToFile(studList3);

        String rus = "rus";
        String eng = "eng";

        // Переключатели языка и модели
        String language = eng;
        iGetModel model = mcHash;

        // запуск программы на английском языке
        if (language == "eng") {
            iGetView view = new ViewClassEng();
            ControllerClass controller = new ControllerClass(model, view);
            controller.run();
        }
        // запуск программы на русском языке
        else{
            iGetView view = new ViewClass();
            ControllerClass controller = new ControllerClass(model, view);
            controller.run();
        }


        //iGetModel model = new ModelClass(studList);

        //controller.update();

    }
}

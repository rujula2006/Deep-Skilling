public class Main {

    public static void main(String[] args) {

        Student model =
                new Student(
                        "Rujula",
                        101,
                        "A");

        StudentView view =
                new StudentView();

        StudentController controller =
                new StudentController(
                        model,
                        view);

        controller.updateView();

        System.out.println();

        controller.setStudentName(
                "Rujula B");

        controller.updateView();
    }
}

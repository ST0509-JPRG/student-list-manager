public class App {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        new MainFrame(studentManager).show();
    }
}

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame {
    JFrame frame;
    AddStudentPanel addStudentPanel;
    StudentListPanel studentListPanel;
    SavePanel savePanel;

    public MainFrame(StudentManager studentManager) {
        this.frame = new JFrame();
        this.frame.setSize(400, 400);
        this.frame.setLayout(new GridLayout(3, 1));

        this.addStudentPanel = new AddStudentPanel(studentManager);
        this.frame.add(this.addStudentPanel.getPanel());

        this.studentListPanel = new StudentListPanel(studentManager);
        this.frame.add(this.studentListPanel.getPanel());

        this.savePanel = new SavePanel(studentManager);
        this.frame.add(savePanel.getPanel());
    }

    public void show() {
        SwingUtilities.invokeLater(() -> {
            this.frame.setVisible(true);
        });
    }

}

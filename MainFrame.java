import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame {
    JFrame frame;
    AddStudentPanel addStudentPanel;
    StudentListPanel studentListPanel;

    public MainFrame(StudentManager studentManager) {
        this.frame = new JFrame();
        this.frame.setSize(400, 400);
        this.frame.setLayout(new GridLayout(2, 2));

        this.addStudentPanel = new AddStudentPanel(studentManager);
        this.frame.add(this.addStudentPanel.getPanel());

        this.studentListPanel = new StudentListPanel(studentManager);
        this.frame.add(this.studentListPanel.getPanel());
    }

    public void show() {
        SwingUtilities.invokeLater(() -> {
            this.frame.setVisible(true);
        });
    }

}

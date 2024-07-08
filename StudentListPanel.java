import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentListPanel {
    private StudentManager studentManager;
    private JPanel panel;
    private JPanel contentPanel;
    private JButton refreshButton;

    public StudentListPanel(StudentManager studentManager) {
        this.studentManager = studentManager;
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.panel.setBorder(BorderFactory.createTitledBorder("List"));

        this.contentPanel = new JPanel();
        this.contentPanel.setLayout(new BoxLayout(this.contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(this.contentPanel);

        this.refreshButton = new JButton("Refresh");
        this.refreshButton.addActionListener((e) -> {
            this.refresh();
        });

        this.panel.add(this.refreshButton);
        this.panel.add(scrollPane);

        this.refresh();
    }

    public JPanel getPanel() {
        return panel;
    }

    public void refresh() {
        this.contentPanel.removeAll();

        Student[] students = studentManager.getStudents();
        System.out.println(students.length);
        for (Student student : students) {
            this.contentPanel.add(new JLabel(student.toString()));
        }

        this.contentPanel.revalidate();
        this.contentPanel.repaint();
    }

}

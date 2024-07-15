import javax.swing.JButton;
import javax.swing.JPanel;

public class SavePanel {
    JPanel panel;

    public SavePanel(StudentManager studentManager) {
        this.panel = new JPanel();
        JButton saveButton = new JButton("Save");
        this.panel.add(saveButton);
        saveButton.addActionListener((e) -> {
            Serializer.serialize(studentManager.getStudents(), StudentManager.filepath);
        });
    }

    public JPanel getPanel() {
        return panel;
    }

}

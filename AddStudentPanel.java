import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddStudentPanel {
    private JPanel panel;
    private StudentManager studentManager;

    private LabelledInputPanel idInput;
    private LabelledInputPanel nameInput;
    private LabelledInputPanel classInput;

    private JButton addStudentButton;
    private JButton clearInputButton;

    public AddStudentPanel(StudentManager studentManager) {
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.panel.setBorder(BorderFactory.createTitledBorder("Student"));

        JPanel inputPanel = new JPanel();
        inputPanel.setMaximumSize(new Dimension(200, 200));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        this.idInput = new LabelledInputPanel("Student Id");
        this.nameInput = new LabelledInputPanel("Name");
        this.classInput = new LabelledInputPanel("Class");
        inputPanel.add(this.idInput.getPanel());
        inputPanel.add(this.nameInput.getPanel());
        inputPanel.add(this.classInput.getPanel());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setMaximumSize(new Dimension(200, 200));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        addStudentButton = new JButton("Add");
        addStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearInputButton = new JButton("Clear");
        clearInputButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel.add(addStudentButton);
        buttonsPanel.add(clearInputButton);

        this.panel.add(inputPanel);
        this.panel.add(buttonsPanel);

        clearInputButton.addActionListener((e) -> {
            clearInput();
        });

        addStudentButton.addActionListener((e) -> {
            String id = this.idInput.getText();
            String name = this.nameInput.getText();
            String className = this.classInput.getText();
            studentManager.addStudent(id, name, className);
            JOptionPane.showMessageDialog(null, String.format("Student %s (%s) added!", id, name));
        });
    }

    private void clearInput() {
        idInput.setText("");
        nameInput.setText("");
    }

    public JPanel getPanel() {
        return panel;
    }

}
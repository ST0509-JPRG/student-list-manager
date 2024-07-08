import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LabelledInputPanel {
    private JPanel panel;

    private JLabel label;
    private JTextField input;

    public LabelledInputPanel(String label) {
        this.panel = new JPanel();

        Dimension dimension = new Dimension(200, 30);
        this.panel.setMaximumSize(dimension);
        this.panel.setLayout(new BorderLayout());

        this.label = new JLabel(label);

        this.input = new JTextField();
        this.input.setColumns(10);

        this.panel.add(this.label, BorderLayout.WEST);
        this.panel.add(this.input, BorderLayout.EAST);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setText(String text) {
        this.input.setText(text);
    }

    public String getText() {
        return this.input.getText();
    }
}

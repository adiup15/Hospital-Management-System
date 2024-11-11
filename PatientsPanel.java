import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class PatientsPanel extends JPanel {
    public PatientsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add title
        JLabel title = new JLabel("Patients Management");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Add main content
        JPanel content = new JPanel(new BorderLayout(0, 20));
        content.setBackground(Color.WHITE);

        // Add buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Add Patient");
        buttonPanel.add(addButton);
        content.add(buttonPanel, BorderLayout.NORTH);

        // Add table
        String[] columns = {"ID", "Name", "Age", "Gender", "Phone", "Address"};
        Object[][] data = {
            {"P001", "anant", "23", "Male", "555-0123", "haryana"},
            {"P002", "robin", "19", "male", "555-0124", "haryana"},
            {"P003", "aditya kumar", "23", "Male", "555-0125", "bihar"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        content.add(scrollPane, BorderLayout.CENTER);

        add(content, BorderLayout.CENTER);
    }
}
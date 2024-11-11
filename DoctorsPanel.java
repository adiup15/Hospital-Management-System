import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class DoctorsPanel extends JPanel {
    public DoctorsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add title
        JLabel title = new JLabel("Doctors Management");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Add main content
        JPanel content = new JPanel(new BorderLayout(0, 20));
        content.setBackground(Color.WHITE);

        // Add buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Add Doctor");
        buttonPanel.add(addButton);
        content.add(buttonPanel, BorderLayout.NORTH);

        // Add table
        String[] columns = {"ID", "Name", "Specialization", "Experience", "Phone", "Email"};
        Object[][] data = {
            {"D001", "Dr. Smith", "Cardiology", "15 years", "555-0101", "smith@hospital.com"},
            {"D002", "Dr. Johnson", "Pediatrics", "10 years", "555-0102", "johnson@hospital.com"},
            {"D003", "Dr. Williams", "Neurology", "12 years", "555-0103", "williams@hospital.com"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        content.add(scrollPane, BorderLayout.CENTER);

        add(content, BorderLayout.CENTER);
    }
}
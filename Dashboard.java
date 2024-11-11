import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Dashboard extends JPanel {
    public Dashboard() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Add header
        add(createHeader(), BorderLayout.NORTH);
        
        // Add main content
        add(createMainContent(), BorderLayout.CENTER);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Search bar
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
        header.add(searchField, BorderLayout.WEST);

        // User profile
        JPanel userProfile = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userProfile.setBackground(Color.WHITE);
        JLabel userLabel = new JLabel("Admin");
        userProfile.add(userLabel);
        header.add(userProfile, BorderLayout.EAST);

        return header;
    }

    private JPanel createMainContent() {
        JPanel mainContent = new JPanel(new BorderLayout(20, 20));
        mainContent.setBackground(new Color(245, 245, 245));
        mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Stats panel
        JPanel statsPanel = new JPanel(new GridLayout(1, 4, 15, 0));
        statsPanel.setBackground(new Color(245, 245, 245));
        
        statsPanel.add(createStatCard("Total Patients", "1,234"));
        statsPanel.add(createStatCard("Doctors", "45"));
        statsPanel.add(createStatCard("Appointments", "89"));
        statsPanel.add(createStatCard("Revenue", "Rs.105000.00"));

        mainContent.add(statsPanel, BorderLayout.NORTH);
        mainContent.add(createRecentActivityPanel(), BorderLayout.CENTER);

        return mainContent;
    }

    private JPanel createStatCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.GRAY);
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valueLabel.setForeground(new Color(41, 128, 185));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createRecentActivityPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel title = new JLabel("Recent Activity");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(title, BorderLayout.NORTH);

        // Table
        String[] columns = {"Patient", "Doctor", "Date", "Status"};
        Object[][] data = {
            {"Anant", "Dr. Smith", "2024-01-20", "Completed"},
            {"Robin", "Dr. Johnson", "2024-01-20", "Pending"},
            {"Aditya kumar", "Dr. Williams", "2024-01-19", "Cancelled"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}
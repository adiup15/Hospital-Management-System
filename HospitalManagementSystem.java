import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalManagementSystem extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Dashboard dashboard;
    private PatientsPanel patientsPanel;
    private DoctorsPanel doctorsPanel;

    public HospitalManagementSystem() {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        // Initialize components
        initComponents();
        
        // Set visible
        setVisible(true);
    }

    private void initComponents() {
        // Create main container with BorderLayout
        setLayout(new BorderLayout());

        // Create sidebar
        JPanel sidebar = createSidebar();
        add(sidebar, BorderLayout.WEST);

        // Create main content area with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Initialize panels
        dashboard = new Dashboard();
        patientsPanel = new PatientsPanel();
        doctorsPanel = new DoctorsPanel();

        // Add panels to main content
        mainPanel.add(dashboard, "Dashboard");
        mainPanel.add(patientsPanel, "Patients");
        mainPanel.add(doctorsPanel, "Doctors");

        add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.setBackground(new Color(41, 128, 185));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // Add logo
        JLabel logo = new JLabel("HMS");
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(30));

        // Add navigation buttons
        String[] menuItems = {"Dashboard", "Patients", "Doctors", "Appointments", "Pharmacy", "Settings"};
        for (String item : menuItems) {
            JButton button = createMenuButton(item);
            sidebar.add(button);
            sidebar.add(Box.createVerticalStrut(10));
        }

        return sidebar;
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(180, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusPainted(false);
        button.setBackground(new Color(41, 128, 185));
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 14));

        button.addActionListener(e -> cardLayout.show(mainPanel, text));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(52, 152, 219));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(41, 128, 185));
            }
        });

        return button;
    }
}
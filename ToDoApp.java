import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoApp() {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        JPanel panel = new JPanel();
        panel.add(taskInput);
        panel.add(addButton);
        panel.add(deleteButton);
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SortedListGUI
{
    private SortedList sortedList;
    private JTextArea displayArea;
    private JTextField inputField;

    public SortedListGUI()
    {
        sortedList = new SortedList();
        JFrame frame = new JFrame("SortedList Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        inputField = new JTextField(10);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        addButton.addActionListener(this::addString);
        searchButton.addActionListener(this::searchString);

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        panel.add(inputPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void addString(ActionEvent e)
    {
        String text = inputField.getText().trim();
        if (!text.isEmpty())
        {
            sortedList.add(text);
            updateDisplay();
            inputField.setText("");
        }
    }

    private void searchString(ActionEvent e)
    {
        String text = inputField.getText().trim();
        if (!text.isEmpty())
        {
            int index = sortedList.search(text);
            boolean found = index < sortedList.getList().size() && sortedList.getList().get(index).equals(text);
            displayArea.append("\nSearch: " + text + " → " + (found ? "Found at index " + index : "Would be at index " + index));
        }
    }

    private void updateDisplay()
    {
        displayArea.setText("Sorted List:\n" + String.join("\n", sortedList.getList()));
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(SortedListGUI::new);
    }
}
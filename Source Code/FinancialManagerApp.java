import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FinancialManagerApp {
    private JFrame frame;
    private JPanel panel;
    private JButton btnAddTransaction, btnViewTransactions;
    private List<Transaction> transactions = new ArrayList<>();

    public FinancialManagerApp() {
        prepareGUI();
    }

    public static void main(String[] args){
        FinancialManagerApp financialManagerApp = new FinancialManagerApp();  
        financialManagerApp.showEventDemo();       
    }

    private void prepareGUI(){
        frame = new JFrame("Personal Financial Manager");
        frame.setSize(600,600);
        frame.setLayout(new GridLayout(5, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        btnAddTransaction = new JButton("Tambah");
        btnViewTransactions = new JButton("Lihat");

        panel.add(btnAddTransaction);
        panel.add(btnViewTransactions);

        frame.add(panel);
        frame.setVisible(true);  
    }

    private void showEventDemo(){
        btnAddTransaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                addTransaction();
            }
        });

        btnViewTransactions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                viewTransactions();
            }
        });
    }
    private void addTransaction() {
        JTextField fieldNominal = new JTextField();
        JTextField fieldDate = new JTextField();
        JTextField fieldCategory = new JTextField();
        JTextField fieldNotes = new JTextField();
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nominal:"));
        panel.add(fieldNominal);
        panel.add(Box.createVerticalStrut(15)); 
        panel.add(new JLabel("Date:"));
        panel.add(fieldDate);
        panel.add(Box.createVerticalStrut(15)); 
        panel.add(new JLabel("Kategori:"));
        panel.add(fieldCategory);
        panel.add(Box.createVerticalStrut(15)); 
        panel.add(new JLabel("Notes:"));
        panel.add(fieldNotes);
    
        int result = JOptionPane.showConfirmDialog(null, panel, 
                   "Masukkan detail transaksi", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String date = fieldDate.getText();
            String category = fieldCategory.getText();
            double nominal = Double.parseDouble(fieldNominal.getText());
            String notes = fieldNotes.getText();
    
            Transaction transaction = new Transaction(date, category, nominal, notes);
            transactions.add(transaction);
        }
    }
    

    private void viewTransactions() {
        String[] columnNames = {"Date", "Category", "Nominal", "Notes"};

        String[][] data = new String[transactions.size()][4];
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            data[i][0] = transaction.getDate();
            data[i][1] = transaction.getCategory();
            data[i][2] = Double.toString(transaction.getNominal());
            data[i][3] = transaction.getNotes();
        }

        JTable table = new JTable(data, columnNames);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }
}

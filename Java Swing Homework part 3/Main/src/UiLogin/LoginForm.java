package UiLogin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.Label;

public class LoginForm extends JFrame implements ActionListener {

    private JLabel title, id, First_Name, Second_Name, Gender, bod, Phone, Address, Enter_To_search;
    private JTextField txtid, txtFname, txtLname, txtPhone, txtEnter_To_search;
    private JComboBox<String> cbgender, cbDay, cbMonth, cbYear;
    private JButton btnAddStudents, btnRemoveStudents, btnEditStudents, btnSearch;
    private JTable table;
    private DefaultTableModel model;
    private JTextArea txtAddress;

    public LoginForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 750);
        this.getContentPane().setBackground(new Color(102, 153, 255));
        this.setLayout(null);

        title = new JLabel("Manage Students");
        title.setBounds(250, 20, 500, 50);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        id = new JLabel("ID:");
        id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        id.setBounds(130, 80, 45, 45);

        First_Name = new JLabel("First Name:");
        First_Name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        First_Name.setBounds(60, 110, 100, 45);

        Second_Name = new JLabel("Last Name:");
        Second_Name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Second_Name.setBounds(60, 140, 100, 45);

        Gender = new JLabel("Gender:");
        Gender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Gender.setBounds(90, 170, 150, 45);

        bod = new JLabel("Day of Birth:");
        bod.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        bod.setBounds(50, 200, 150, 45);

        Phone = new JLabel("Phone:");
        Phone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Phone.setBounds(100, 230, 150, 45);

        Address = new JLabel("Address:");
        Address.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Address.setBounds(85, 260, 150, 45);

        Enter_To_search = new JLabel("Enter Value for Search: ");
        Enter_To_search.setBounds(600, 80, 200, 45);
        Enter_To_search.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        txtid = new JTextField();
        txtid.setBounds(170, 85, 400, 25);

        txtFname = new JTextField();
        txtFname.setBounds(170, 115, 400, 25);

        txtLname = new JTextField();
        txtLname.setBounds(170, 145, 400, 25);

        txtPhone = new JTextField();
        txtPhone.setBounds(170, 235, 400, 25);

        txtEnter_To_search = new JTextField();
        txtEnter_To_search.setBounds(800, 85, 350, 25);

        String[] genders = {"", "Man", "Woman", "Other"};
        cbgender = new JComboBox<>(genders);
        cbgender.setBounds(170, 175, 400, 25);

        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        cbDay = new JComboBox<>(days);
        cbDay.setBounds(170, 205, 60, 25);

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        cbMonth = new JComboBox<>(months);
        cbMonth.setBounds(240, 205, 100, 25);

        String[] years = new String[126];
        for (int i = 1900, j = 0; i <= 2025; i++, j++) years[j] = String.valueOf(i);
        cbYear = new JComboBox<>(years);
        cbYear.setBounds(350, 205, 80, 25);

        txtAddress = new JTextArea();
        txtAddress.setLineWrap(true);
        txtAddress.setWrapStyleWord(true);
        txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        JScrollPane scrollAddress = new JScrollPane(txtAddress);
        scrollAddress.setBounds(170, 270, 400, 100);

        String[] columns = {"Id", "First Name", "Last Name", "Sex", "BirthDate", "Phone", "Address"};
        model = new DefaultTableModel(null, columns);
        table = new JTable(model);

        JScrollPane datashow = new JScrollPane(table);
        datashow.setBounds(600, 125, 550, 400);

        btnAddStudents = new JButton("ADD");
        btnAddStudents.setBounds(85, 470, 150, 45);
        btnAddStudents.addActionListener(this);

        btnEditStudents = new JButton("EDIT");
        btnEditStudents.setBounds(245, 470, 150, 45);
        btnEditStudents.addActionListener(this);

        btnRemoveStudents = new JButton("REMOVE");
        btnRemoveStudents.setBounds(415, 470, 150, 45);
        btnRemoveStudents.addActionListener(this);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(245, 530, 150, 45);
        btnSearch.addActionListener(this);

        this.add(title);
        this.add(id);
        this.add(First_Name);
        this.add(Second_Name);
        this.add(Gender);
        this.add(bod);
        this.add(Phone);
        this.add(Address);
        this.add(Enter_To_search);
        this.add(txtid);
        this.add(txtFname);
        this.add(txtLname);
        this.add(cbgender);
        this.add(cbDay);
        this.add(cbMonth);
        this.add(cbYear);
        this.add(txtPhone);
        this.add(scrollAddress);
        this.add(txtEnter_To_search);
        this.add(datashow);
        this.add(btnAddStudents);
        this.add(btnEditStudents);
        this.add(btnRemoveStudents);
        this.add(btnSearch);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddStudents) {
            String id = txtid.getText();
            String fname = txtFname.getText();
            String lname = txtLname.getText();
            String gender = cbgender.getSelectedItem().toString();
            String dob = cbDay.getSelectedItem() + " " + cbMonth.getSelectedItem() + " " + cbYear.getSelectedItem();
            String phone = txtPhone.getText();
            String address = txtAddress.getText();
            model.addRow(new Object[]{id, fname, lname, gender, dob, phone, address});

            txtid.setText("");
            txtFname.setText("");
            txtLname.setText("");
            cbgender.setSelectedIndex(0);
            cbDay.setSelectedIndex(0);
            cbMonth.setSelectedIndex(0);
            cbYear.setSelectedIndex(0);
            txtPhone.setText("");
            txtAddress.setText("");
        } else if (e.getSource() == btnEditStudents) {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                txtid.setText(model.getValueAt(selected, 0).toString());
                txtFname.setText(model.getValueAt(selected, 1).toString());
                txtLname.setText(model.getValueAt(selected, 2).toString());
                cbgender.setSelectedItem(model.getValueAt(selected, 3).toString());

                String[] dobParts = model.getValueAt(selected, 4).toString().split(" ");
                if (dobParts.length == 3) {
                    cbDay.setSelectedItem(dobParts[0]);
                    cbMonth.setSelectedItem(dobParts[1]);
                    cbYear.setSelectedItem(dobParts[2]);
                }

                txtPhone.setText(model.getValueAt(selected, 5).toString());
                txtAddress.setText(model.getValueAt(selected, 6).toString());
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to load for editing");
            }
        } else if (e.getSource() == btnRemoveStudents) {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to remove");
            }
        } else if (e.getSource() == btnSearch) {
            String keyword = txtEnter_To_search.getText().toLowerCase();
            for (int i = 0; i < table.getRowCount(); i++) {
                String idValue = table.getValueAt(i, 0).toString().toLowerCase();
                if (idValue.contains(keyword)) {
                    table.setRowSelectionInterval(i, i);
                    table.setSelectionBackground(Color.BLACK);
                    table.setSelectionForeground(Color.WHITE);
                    break;
                }
            }
        }
    }
}

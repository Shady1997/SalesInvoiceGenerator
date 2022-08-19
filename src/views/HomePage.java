package views;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.InvoiceController;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class HomePage extends JFrame {

	// invoices table headers
	String[] header = { "NO.", "Date", "Customer", "Total" };
	// invoice details header
	String[] headerDetais = { "NO.", "Item Name", "Item Price", "Count", "Item Total" };
	// home page view elements
	private JPanel contentPane;
	public JTable table;
	public JTable table_1;
	public JButton btnNewButton;
	public DefaultTableModel daDefaultTableModel;
	public DefaultTableModel daDefaultTableModel1;
	public JLabel textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JLabel textField_3;
	public JMenu menu;
	public JMenuItem i1, i2;
	public JMenuBar mb;

	// TODO: define controller
	InvoiceController controller = new InvoiceController(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// TODO: Handle Frame view
					HomePage frame = new HomePage();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = frame.getSize().width;
					int h = frame.getSize().height;
					int x = (dim.width - w) / 2;
					int y = (dim.height - h) / 2;
					frame.setBounds(x, y, w, h);
					frame.setResizable(false);
					frame.getContentPane().setBackground(Color.lightGray);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setTitle("Sales Invoice Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Left panel handler
		JLabel leftPanel = new JLabel("");
		leftPanel.setForeground(new Color(0, 0, 0));
		leftPanel.setBackground(Color.RED);
		leftPanel.setBounds(10, 32, 500, 544);
		leftPanel.add(new JScrollPane(table));
		contentPane.add(leftPanel);

		// right panel handler
		JLabel rightPanel = new JLabel("");
		rightPanel.setBackground(Color.GREEN);
		rightPanel.setBounds(515, 32, 500, 544);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(rightPanel);

		// invoice table
		table = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		daDefaultTableModel = new DefaultTableModel(0, 0);
		daDefaultTableModel.setColumnIdentifiers(header);
		controller.showInvoiceData(System.getProperty("user.dir") + "\\resources\\InvoiceHeader.csv");
		controller.addTableMouseListener();
		table.setModel(daDefaultTableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
		scrollPane.setBounds(10, 38, 414, 430);

		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setBounds(15, 35, 400, 400);
		contentPane.add(scrollPane);

		// invoices table label header
		JLabel txtpnInvoicesTable = new JLabel();
		txtpnInvoicesTable.setText("Invoices Table");
		txtpnInvoicesTable.setBounds(10, 18, 194, 20);
		contentPane.add(txtpnInvoicesTable);

		// create invoice button
		JButton btnCreateInvoice = new JButton("Create New Invoice");
		btnCreateInvoice.setBounds(71, 506, 150, 23);
		btnCreateInvoice.setHorizontalTextPosition(JButton.CENTER);
		btnCreateInvoice.setActionCommand("btnCreateInvoice");
		btnCreateInvoice.addActionListener(controller);
		// Round the button with radius = 15
		btnCreateInvoice.setBorder(new RoundBtn(15));
		contentPane.add(btnCreateInvoice);

		// delete invoice button
		JButton btnNewButton_1 = new JButton("Delete Invoice");
		btnNewButton_1.setBounds(248, 506, 150, 23);
		btnNewButton_1.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton_1.setActionCommand("deleteInvoice");
		btnNewButton_1.addActionListener(controller);
		// Round the button with radius = 15
		btnNewButton_1.setBorder(new RoundBtn(15));

		contentPane.add(btnNewButton_1);

		// save button
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(738, 506, 80, 23);
		btnNewButton_2.setActionCommand("save");
		btnNewButton_2.addActionListener(controller);
		contentPane.add(btnNewButton_2);

		// cancel button
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.setBounds(830, 506, 80, 23);
		btnNewButton_3.setActionCommand("cancel");
		btnNewButton_3.addActionListener(controller);
		contentPane.add(btnNewButton_3);

		// invoice details table
		table_1 = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		daDefaultTableModel1 = new DefaultTableModel(0, 0);
		daDefaultTableModel1.setColumnIdentifiers(headerDetais);
		table_1.setModel(daDefaultTableModel1);
		JScrollPane scrollPane1 = new JScrollPane(table_1);
		scrollPane1.setBounds(520, 268, 473, 200);

		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setRowSelectionAllowed(true);
		table_1.setBounds(520, 268, 400, 200);
		contentPane.add(scrollPane1);

		// invoice items label
		JLabel lblNewLabel = new JLabel("Invoice Items");
		lblNewLabel.setBounds(520, 243, 98, 14);
		contentPane.add(lblNewLabel);

		// invoice number label
		JLabel lblNewLabel_1 = new JLabel("Invoice Number:");
		lblNewLabel_1.setBounds(520, 46, 98, 14);
		contentPane.add(lblNewLabel_1);

		// invoice date label
		JLabel lblNewLabel_2 = new JLabel("Invoice Date:");
		lblNewLabel_2.setBounds(520, 80, 98, 14);
		contentPane.add(lblNewLabel_2);

		// invoice customer name label
		JLabel lblNewLabel_3 = new JLabel("Customer:");
		lblNewLabel_3.setBounds(520, 114, 98, 14);
		contentPane.add(lblNewLabel_3);

		// invoice total label
		JLabel lblNewLabel_4 = new JLabel("Invoice Total:");
		lblNewLabel_4.setBounds(520, 148, 98, 14);
		contentPane.add(lblNewLabel_4);

		// display invoice number (not editable)
		textField = new JLabel();
		textField.setBounds(629, 43, 96, 20);
		contentPane.add(textField);

		// display invoice date (editable)
		textField_1 = new JTextField();
		textField_1.setBounds(629, 77, 291, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		// display invoice customer name (editable)
		textField_2 = new JTextField();
		textField_2.setBounds(629, 111, 291, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		// display invoice total (not editable)
		textField_3 = new JLabel();
		textField_3.setBounds(628, 145, 96, 20);
		contentPane.add(textField_3);

		// add menu bar to handle load file and save file
		menu = new JMenu("File");
		mb = new JMenuBar();
		i1 = new JMenuItem("Load File");
		i1.setActionCommand("loadfile");
		i1.addActionListener(controller);
		i2 = new JMenuItem("Save File");
		i2.setActionCommand("savefile");
		i2.addActionListener(controller);
		menu.add(i1);
		menu.add(i2);
		mb.add(menu);
		mb.setBounds(0, 0, 1023, 22);
		contentPane.add(mb);
		// add invoice item
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(648, 506, 80, 23);
		btnNewButton.setActionCommand("add");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(controller);
		contentPane.add(btnNewButton);
	}

	// internal class to handle buttons shape
	class RoundBtn implements Border {
		private int r;

		RoundBtn(int r) {
			this.r = r;
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
		}

		public boolean isBorderOpaque() {
			return true;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width - 1, height - 1, r, r);
		}
	}
}
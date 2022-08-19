package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileOperations {

	// create array list for invoice header
	public static ArrayList<InvoiceHeader> invoices = new ArrayList<>();
	public static ArrayList<InvoiceLine> invoiceLine = new ArrayList<>();

	public static void readHeaderFile(String path) {
		String line = "";
		String splitBy = ",";
		String[] invoiceDetails = null;
		try {
			// parsing a CSV file into BufferedReader class constructor
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				invoiceDetails = line.split(splitBy); // use comma as separator
				InvoiceHeader invoiceData = new InvoiceHeader();
				invoiceData.setInvoiceNo(invoiceDetails[0]);
				invoiceData.setInvoiceDate(invoiceDetails[1]);
				invoiceData.setCustomerName(invoiceDetails[2]);
				invoices.add(invoiceData);
			}
			readInvoiceLine();
		} catch (IOException e) {
			e.printStackTrace();
			// print error message in console
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		// test reading header data from csv file
		testReadingFromCSV(invoices);
	}

	private static void readInvoiceLine() {
		String line = "";
		String splitBy = ",";
		String[] invoiceDetails = null;
		try {
			// parsing a CSV file into BufferedReader class constructor
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
					new FileReader(System.getProperty("user.dir") + "\\resources\\InvoiceLine.csv"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				invoiceDetails = line.split(splitBy); // use comma as separator
				InvoiceLine invoiceDetail = new InvoiceLine();
				invoiceDetail.setInvoiceNo(invoiceDetails[0]);
				invoiceDetail.setItemName(invoiceDetails[1]);
				invoiceDetail.setItemPrice(invoiceDetails[2]);
				invoiceDetail.setItemCount(invoiceDetails[3]);
				invoiceLine.add(invoiceDetail);
			}
		} catch (IOException e) {
			e.printStackTrace();
			// print error message in console
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void writeFile(ArrayList<InvoiceHeader> invoices) {

	}

	public static void testReadingFromCSV(ArrayList<InvoiceHeader> invoices) {
		for (int i = 0; i < invoices.size(); i++) {
			System.out.println("Invoice " + invoices.get(i).getInvoiceNo() + "\n" + "{" + "\n"
					+ invoices.get(i).getInvoiceDate() + ", " + invoices.get(i).getCustomerName());
			for (int j = 0; j < invoiceLine.size(); j++) {
				if (invoiceLine.get(j).getInvoiceNo().equals(invoices.get(i).getInvoiceNo()))
					System.out.println(invoiceLine.get(j).getItemName() + ", " + invoiceLine.get(j).getItemPrice()
							+ ", " + invoiceLine.get(j).getItemCount());
			}
			System.out.println("}");
		}
	}

	public static void main(String[] args) {
		readHeaderFile(System.getProperty("user.dir") + "\\resources\\InvoiceHeader.csv");
	}

}

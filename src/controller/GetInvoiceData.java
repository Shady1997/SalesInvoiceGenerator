package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.InvoiceHeader;

public class GetInvoiceData {

	public ArrayList<InvoiceHeader> invoices = new ArrayList<>();

	public GetInvoiceData(String path) {
		getInvoicesDetails(path);
	}

	public void getInvoicesDetails(String path) {
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
		} catch (IOException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

}

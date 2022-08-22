package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.InvoiceLine;

public class getInvoiceDetails {

	public ArrayList<InvoiceLine> invoices = new ArrayList<>();
	private int detailsTableRow;

	public getInvoiceDetails(int detailsTableRow, String path) {
		this.detailsTableRow = detailsTableRow;
		getInvoicesDetails(path);
	}

	// empty constructor
	public getInvoiceDetails() {
	}

	public void getInvoicesDetails(String path) {
		String line = "";
		String splitBy = ",";
		String[] invoiceDetails = null;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// parsing a CSV file into BufferedReader class constructor
			
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				invoiceDetails = line.split(splitBy); // use comma as separator
				InvoiceLine invoiceDetail = new InvoiceLine();
				if (Integer.parseInt(invoiceDetails[0]) != detailsTableRow)
					continue;
				else {
					invoiceDetail.setInvoiceNo(invoiceDetails[0]);
					invoiceDetail.setItemName(invoiceDetails[1]);
					invoiceDetail.setItemPrice(invoiceDetails[2]);
					invoiceDetail.setItemCount(invoiceDetails[3]);
					invoices.add(invoiceDetail);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	public void addInvoiceDetails(String invoiceNo, String itemName, String itemPrice, String itemCount) {
		InvoiceLine invoiceDetail = new InvoiceLine();
		invoiceDetail.setInvoiceNo(invoiceNo);
		invoiceDetail.setItemName(itemName);
		invoiceDetail.setItemPrice(itemPrice);
		invoiceDetail.setItemCount(itemCount);
		invoices.add(invoiceDetail);
	}

	public List<InvoiceLine> addNewInvoiceDetailsToObject(String invoiceNo, String itemName, String itemPrice,
			String itemCount) {
		// TODO Auto-generated method stub
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
				invoices.add(invoiceDetail);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		InvoiceLine invoiceDetail = new InvoiceLine();
		invoiceDetail.setInvoiceNo(invoiceNo);
		invoiceDetail.setItemName(itemName);
		invoiceDetail.setItemPrice(itemPrice);
		invoiceDetail.setItemCount(itemCount);
		invoices.add(invoiceDetail);
		return invoices;
	}
}

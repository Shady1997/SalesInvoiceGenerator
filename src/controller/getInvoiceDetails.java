package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.InvoiceDetails;

public class getInvoiceDetails {

	public List<InvoiceDetails> invoices = new ArrayList<>();
	private int detailsTableRow;

	public getInvoiceDetails() {
	}

	public getInvoiceDetails(int detailsTableRow, String path) {
		this.detailsTableRow = detailsTableRow;
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
				InvoiceDetails invoiceDetail = new InvoiceDetails();
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
			e.printStackTrace();
		}
	}

	public List<InvoiceDetails> addNewInvoiceDetailsToObject(String invoiceNo, String itemName, String itemPrice,
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
				InvoiceDetails invoiceDetail = new InvoiceDetails();
				invoiceDetail.setInvoiceNo(invoiceDetails[0]);
				invoiceDetail.setItemName(invoiceDetails[1]);
				invoiceDetail.setItemPrice(invoiceDetails[2]);
				invoiceDetail.setItemCount(invoiceDetails[3]);
				invoices.add(invoiceDetail);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		InvoiceDetails invoiceDetail = new InvoiceDetails();
		invoiceDetail.setInvoiceNo(invoiceNo);
		invoiceDetail.setItemName(itemName);
		invoiceDetail.setItemPrice(itemPrice);
		invoiceDetail.setItemCount(itemCount);
		invoices.add(invoiceDetail);
		return invoices;
	}
}

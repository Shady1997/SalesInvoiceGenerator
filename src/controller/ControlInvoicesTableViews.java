package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.InvoiceDetails;

public class ControlInvoicesTableViews {
	public String invoiceNo;
	public String invoiceTotal;
	public String invoiceDate;
	public String customerName;

	public void getInvoiceDataWithIndex(List<InvoiceDetails> invoices, String invoiceNo) {
		for (int i = 0; i < invoices.size(); i++) {
			if (invoices.get(i).getInvoiceNo() == invoiceNo) {
				invoiceNo = invoices.get(i).getInvoiceNo();
//				invoiceDate = invoices.get(i).getInvoiceDate();
//				invoiceTotal = invoices.get(i).getProductPrice();
//				customerName = invoices.get(i).getProductType();
				System.out.println(customerName);
			}
		}
	}

	public static void DeleteRecordByID(String ID) throws IOException {
		@SuppressWarnings({ "unused", "resource" })
		Scanner strInput = new Scanner(System.in);
		String record;

		File tempDB = new File(System.getProperty("user.dir") + "\\resources\\data1.csv");
		File db = new File(System.getProperty("user.dir") + "\\resources\\data.csv");

		BufferedReader br = new BufferedReader(new FileReader(db));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
		while ((record = br.readLine()) != null) {
			if (record.contains(ID))
				continue;

			bw.write(record);
			bw.flush();
			bw.newLine();
		}

		br.close();
		bw.close();
		db.delete();
		tempDB.renameTo(db);
	}

	public static void main(String[] args) throws IOException {
		DeleteRecordByID("122");
	}

}

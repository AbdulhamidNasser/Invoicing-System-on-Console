import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import InvoicingSystem.Items;

public class Invoice {
     String customerName;
     String phoneNumber;
     Date invoiceDate;
     List<InvoiceItem> items;
     double totalAmount;
     double paidAmount;
     double balance;
     String shopName;
     int fax;
     String email;
     String website;
     int noOfItem;
     int invoiceID;
    
    
    

    public Invoice(String customerName, String phoneNumber, String shopName, int fax, String email,String website, int noOfItem, int invoiceID) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = new Date();
        this.items = new ArrayList<>();
        this.totalAmount = 0;
        this.paidAmount = 0;
        this.balance = 0;
        this.shopName = shopName;
        this.fax = fax;
        this.email = email;
        this.website = website;
        this.noOfItem = noOfItem;
        this.invoiceID = invoiceID;
    }

    public void addItem(InvoiceItem item) {
        this.items.add(item);
        this.totalAmount += item.getTotalAmount();
    }

    public void processPayment(double amount) {
        this.paidAmount += amount;
        this.balance = this.totalAmount - this.paidAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getBalance() {
        return balance = totalAmount - paidAmount;
    }
    
    public String getShopName() {
        return shopName;
    }
    
    public int getFax() {
	    return fax;
	  }
    
    public String getEmail() {
	    return email;
	  }
    
    public String getWebsite() {
	    return website;
	  }
    
    public void changeItemPrice(String iName, double newUnitPrice) {
		 
		  for(InvoiceItem i : items)
		  {
			  if(iName.equalsIgnoreCase(i.itemName))
			  {
				  i.unitPrice = newUnitPrice;
			  }
		  }
		  
	  }
    
    
    public int getnoOfItem() {
	    return noOfItem;
	  }
    
    public int getinvoiceID() {
	    return invoiceID;
	  }
}
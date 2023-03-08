import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

//import InvoicingSystem.Items;

public class MenuGroceriesShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String customerName;
		String phoneNumber;
		String shopName;
		int fax;
	    String email;
	    String website;
	    int itemId;
	    String itemName;
	    double unitPrice;
	    int quantity;
	    int noOfItem;
	    int invoiceID;
	    Scanner sc = new Scanner(System.in);
		Invoice invoice = new Invoice(customerName, phoneNumber, shopName, fax, email, website, noOfItem, invoiceID);
		InvoiceItem itemN = new InvoiceItem(itemId, itemName, unitPrice, quantity);
		
	    String url = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=Solo_Project;" +
                "encrypt=true;" +
                "trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        Connection con = null;
        try {
Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
 Statement st = con.createStatement();
          
             
             String sql = "insert into Table_1 (customerName,phoneNumber,shopName,fax,email,website) " +
                          "values ('" + customerName + "'," + phoneNumber + ",'" + shopName + "'," + fax + ",'" + email + "','" + website + "')";

             Integer m = st.executeUpdate(sql);
            if (m >= 1) {
System.out.println("inserted successfully : " + sql);
} else {
System.out.println("insertion failed");
}
            String sql1 = "Select * from Table_1";
ResultSet resultSet = st.executeQuery(sql1);
             while (resultSet.next()) {
System.out.println(resultSet.getString("name"));
System.out.println(resultSet.getString("roll"));
System.out.println(resultSet.getString("cls"));
}
            con.close();
} catch (Exception ex) {
System.err.println(ex);
}

		
		
		

		Boolean as = true;
		while(as)
		{
		System.out.println("Application Main Menu : ");
		System.out.println("1-Shop Settings");
		System.out.println("2- Manage Shop Items");
		System.out.println("3- Create New Invoice");
		System.out.println("4- Report: Statistics");
		System.out.println("5- Report: All Invoices");
		System.out.println("6- Search (1) Invoice");
		System.out.println("7- Program Statistics");
		System.out.println("8- Exit");
		
		int menuCase = sc.nextInt();
		
		switch (menuCase) {
		  case 1:
			 
		    System.out.println("1. Load Data");
		    System.out.println("2. Set Shop Name");
		    System.out.println("3. Set Invoice Header ");
		    System.out.println("4. Go Back");
		    
		    Boolean dd = true;
			while(dd) {
		    switch (sc.nextInt()) {
		    case 1:
		    	System.out.println("1. Load Data");
		    	System.out.println("Your Shop Name : "+invoice.getShopName());
		    	System.out.println("Your Shop Phone Number : "+invoice.getPhoneNumber());
		    	System.out.println("Your Shop Fax Number : "+invoice.getFax());
		    	System.out.println("Your Shop Email : "+invoice.getEmail());
		    	System.out.println("Your Shop Website : "+invoice.getWebsite());
		    	System.out.println("Your Item Name : "+itemN.getItemName());
		    	System.out.println("Your Item ID : "+itemN.getItemId());
		    	System.out.println("Your Item Quantity : "+itemN.getQuantity());
		    	System.out.println("Your Item Unit Price : "+itemN.getUnitPrice());
		    	System.out.println("Your Item Quantity Amount/Price : "+itemN.getTotalAmount());
		    	System.out.println("Your Invoice Date : "+invoice.getInvoiceDate());
		    	System.out.println("Number Of Items : "+invoice.getItems());
		    	System.out.println("Total Amount : "+invoice.getTotalAmount());
		    	System.out.println("Paid Amount : "+invoice.getPaidAmount());
		    	System.out.println("Balance : "+invoice.getBalance());
		    	
		    	
		    	
		    	
		    	break;
		    case 2:
		    	System.out.println("Please Enter Your Shop Name : ");
		    	
		    	invoice.shopName = sc.next();
		    	
		    	break;
		    	
		    case 3:
		    	try{    
			         
			    	
		    	System.out.println(" Set Invoice Header ");
		    	System.out.println("Enter Shop Phone Number");
		    	invoice.phoneNumber = sc.next();
		    	System.out.println("Enter Shop Fax Number");
		    	invoice.fax = sc.nextInt();
		    	System.out.println("Enter Shop Email ");
		    	invoice.email = sc.next();
		    	System.out.println("Enter Shop Website");
		    	invoice.website = sc.next();
		    	
		    	
		    	
		    	}catch(Exception e){System.out.println(e);} 
		    	break;

		    case 4:
		    	as = true;
		    	break;
		    	
		    
		    
		}
		    }
		    
		  case 2:
			  System.out.println("1. Add Items");
			    System.out.println("2. Delete Item");
			    System.out.println("3. Change Item Price");
			    System.out.println("4. Report All Items");
			    System.out.println("5. Go Back");
			    
			    switch (sc.nextInt()) {
			    case 1:
			    	try{    
			    		         
			    
			    	FileOutputStream fout=new FileOutputStream("item.txt");    
		    		  ObjectOutputStream out=new ObjectOutputStream(fout); 
			    	System.out.println("Enter Items Name");
			    	itemN.itemName = sc.next();
			    	System.out.println("Enter Items ID");
			    	itemN.itemId = sc.nextInt();
			    	System.out.println("Enter Number of Quantity");
			    	itemN.quantity = sc.nextInt();
			    	System.out.println("Enter Unit Price");
			    	itemN.unitPrice = sc.nextDouble();
			    	
			    	invoice.items.add(itemN);
			    	
			    	 out.writeObject(itemN);    
			    	  out.flush();    
			    	      
			    	  out.close();    
			    	  System.out.println("success");    
			    	  }catch(Exception e){System.out.println(e);}
			    	break;
			    
			    	
			    case 2:
			    	System.out.println("Enter Name of Item Need to Deleted");
			    	String itemNameRemove = sc.next();
			    	invoice.items.remove(itemNameRemove);
			    	
			    	break;
			    	
			    case 3:
			    	System.out.println("Enter Item Name Need to Change Price");
			    	String iName = sc.next();
			    	System.out.println("Enter Neew Price ");
			    	double newUnitPrice = sc.nextDouble();
			    	((Invoice) invoice.items).changeItemPrice(iName,  newUnitPrice);
			    	System.out.println("3. Change Item Price");
			    	break;

			    case 4:
			    	System.out.println("4. Report All Items");
			    	break;
			    	
			    case 5:
			    	as=true;
			    	
			    	break;
			    }
			    
		  case 3:
			  /*try{ 	  
			  FileOutputStream fout=new FileOutputStream("invoice.txt");    
    		  ObjectOutputStream out=new ObjectOutputStream(fout);
			    System.out.println("");
			    System.out.println("Invoice Date");
			    //Date invoiceDate = new Date();
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			    String formattedDate = sdf.format(invoice.invoiceDate);
			    String sql = "insert into Table_1 (invoiceDate) values ('" + formattedDate + "')";
		    	System.out.println("Enter Invoice ID");
		    	invoice.invoiceID = sc.nextInt();
		    	System.out.println("Enter Number Of Items");
		    	invoice.noOfItem = sc.nextInt();
		    	System.out.println("Enter Total Amount");
		    	invoice.totalAmount = sc.nextDouble();
		    	System.out.println("Enter Paid Amount");
		    	invoice.paidAmount = sc.nextDouble();
		    	System.out.println(" Balance");
		    	invoice.getBalance();
		    	//invoice.items.add(invoice);
		    	 out.writeObject(invoice);    
		    	  out.flush();    
		    	      
		    	  out.close();    
		    	  System.out.println("success");    
		    	  }catch(Exception e){System.out.println(e);}*/
			  
			  try {
				    // Establish a connection to the database
				   // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

				    // Define a new table in the database
				    Statement stmt = con.createStatement();
				    String createTableSQL = "CREATE TABLE invoices (invoice_id INT NOT NULL, invoice_date DATETIME, no_of_item INT, total_amount DECIMAL(10,2), paid_amount DECIMAL(10,2), balance DECIMAL(10,2), PRIMARY KEY (invoice_id))";
				    stmt.executeUpdate(createTableSQL);

				    // Create a PreparedStatement to insert data into the new table
				    String insertSQL = "INSERT INTO invoices (invoice_id, invoice_date, no_of_item, total_amount, paid_amount, balance) VALUES (?, ?, ?, ?, ?, ?)";
				    PreparedStatement pstmt = con.prepareStatement(insertSQL);

				    // Set the values of the PreparedStatement to the corresponding data fields
				    pstmt.setInt(1, invoice.invoiceID);
				    pstmt.setTimestamp(2, Timestamp.valueOf(((Timestamp) invoice.invoiceDate).toLocalDateTime()));
				    pstmt.setInt(3, invoice.noOfItem);
				    pstmt.setDouble(4, invoice.totalAmount);
				    pstmt.setDouble(5, invoice.paidAmount);
				    pstmt.setDouble(6, invoice.getBalance());

				    // Execute the PreparedStatement to insert the data into the new table
				    pstmt.executeUpdate();

				    // Close the connection to the database
				    pstmt.close();
				    con.close();
				} catch (SQLException e) {
				    e.printStackTrace();
				}

			  
			    break;
			    
			  case 4:
			    System.out.println("");
		    	System.out.println("Your Item Quantity : "+itemN.getQuantity());
				
			    break;
			    
			  case 5:
				  try {
					    // Establish a connection to the database
					  //  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

					    // Define the SQL query to join the invoices and customers table
					    String sql = "SELECT i.invoice_id, i.invoice_date, c.customer_name, i.no_of_item, i.total_amount, i.balance " +
					                 "FROM invoices i " +
					                 "JOIN customers c ON i.customer_id = c.customer_id";

					    // Create a statement to execute the SQL query
					    Statement stmt = con.createStatement();

					    // Execute the query and get the result set
					    ResultSet rs = stmt.executeQuery(sql);

					    // Print the column headers
					    System.out.printf("%-12s %-20s %-20s %-10s %-10s %-10s\n",
					            "Invoice No", "Invoice Date", "Customer Name", "No of items", "baseTotal", "Balance");
					    System.out.println("------------------------------------------------------------");

					    // Iterate through the result set and print the data
					    while (rs.next()) {
					        int invoiceID1 = rs.getInt("invoice_id");
					        Timestamp invoiceDate = rs.getTimestamp("invoice_date");
					        String customerName1 = rs.getString("customer_name");
					        int noOfItems = rs.getInt("no_of_item");
					        double baseTotal = rs.getDouble("total_amount") - rs.getDouble("balance");
					        double balance = rs.getDouble("balance");

					        System.out.printf("%-12s %-20s %-20s %-10s %-10s %-10s\n",
					                invoiceID1, invoiceDate, customerName1, noOfItems, baseTotal, balance);
					    }

					    // Close the result set, statement, and connection
					    rs.close();
					    stmt.close();
					    con.close();
					} catch (SQLException e) {
					    e.printStackTrace();
					}


			    break;
			    
			  case 6:
			    System.out.println("");
			    
			    try {
			        // Establish a connection to the database
			        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

			        // Prompt the user to enter the invoice ID to search for
			        Scanner input = new Scanner(System.in);
			        System.out.print("Enter the invoice ID to search for: ");
			        int invoiceIDSearch = input.nextInt();

			        // Define the SQL query to join the invoices and invoice_items table
			        String sql = "SELECT i.invoice_id, i.invoice_date, c.customer_name, ii.item_name, ii.quantity, ii.price " +
			                     "FROM invoices i " +
			                     "JOIN customers c ON i.customer_id = c.customer_id " +
			                     "JOIN invoice_items ii ON i.invoice_id = ii.invoice_id " +
			                     "WHERE i.invoice_id = ?";

			        // Create a prepared statement with the invoice ID parameter
			        PreparedStatement pstmt = con.prepareStatement(sql);
			        pstmt.setInt(1, invoiceIDSearch);

			        // Execute the query and get the result set
			        ResultSet rs = pstmt.executeQuery();

			        // Print the invoice header
			        System.out.println("Invoice Details:");
			        System.out.println("Invoice No.: " + invoiceIDSearch);
			        System.out.println("------------------------------------------------------------");
			        System.out.printf("%-20s %-20s %-20s %-10s %-10s\n",
			                "Invoice Date", "Customer Name", "Item Name", "Quantity", "Price");
			        System.out.println("------------------------------------------------------------");

			        // Iterate through the result set and print the data
			        while (rs.next()) {
			            Timestamp invoiceDate = rs.getTimestamp("invoice_date");
			            String customerName2 = rs.getString("customer_name");
			            String itemName2 = rs.getString("item_name");
			            int quantity2 = rs.getInt("quantity");
			            double price = rs.getDouble("price");

			            System.out.printf("%-20s %-20s %-20s %-10s %-10s\n",
			                    invoiceDate, customerName2, itemName2, quantity2, price);
			        }

			        // Close the result set, prepared statement, and connection
			        rs.close();
			        pstmt.close();
			        con.close();
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			
					
			    break;
			    
			  case 7:
			    System.out.println("");
			 // Initialize a HashMap to keep track of the menu item counts
			    HashMap<String, Integer> menuCounts = new HashMap<>();

			    // Prompt the user to select a menu item until they choose to quit
			    Scanner input = new Scanner(System.in);
			    String menuItem = "";
			    while (!menuItem.equals("Quit")) {
			        // Print the main menu
			        System.out.println("Main Menu:");
			        System.out.println("1. Option 1");
			        System.out.println("2. Option 2");
			        System.out.println("3. Option 3");
			        System.out.println("4. Quit");

			        // Prompt the user to select a menu item
			        System.out.print("Select an option: ");
			        menuItem = input.nextLine();

			        // Increment the count for the selected menu item
			        if (menuCounts.containsKey(menuItem)) {
			            menuCounts.put(menuItem, menuCounts.get(menuItem) + 1);
			        } else {
			            menuCounts.put(menuItem, 1);
			        }
			    }

			    // Print the menu item counts
			    System.out.println("Menu Item Counts:");
			    for (String item : menuCounts.keySet()) {
			        int count = menuCounts.get(item);
			        System.out.println(item + ": " + count);
			    }

			    
			    break;
			    
			  case 8:
				    System.out.println("Are you sure you want to exit?  Yes Or No");
				    String exit =sc.next();
				    if(exit.equals("yes")) 
				    {
				    	return;
				    }
				    else
				    {
				    	as=true;
				    	
				    }
		
				   break;
			}
			

		}
		

	}

}

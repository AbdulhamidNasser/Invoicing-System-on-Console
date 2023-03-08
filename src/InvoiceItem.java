import java.io.Serializable;

public class InvoiceItem implements Serializable{
         int itemId;
         String itemName;
         double unitPrice;
         int quantity;

        public InvoiceItem(int itemId, String itemName, double unitPrice, int quantity) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public int getItemId() {
            return itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalAmount() {
            return unitPrice * quantity;
        }
    }

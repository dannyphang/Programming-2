public class Selection {
        // Declaration
        private Product product;
        private int quantity;
        private String addDate;
    
        // Constructor
        public Selection() {
            // selection??
        }
    
        public Selection(Product product, int quantity, String addDate) {
            this.product = product;
            this.quantity = quantity;
            this.addDate = addDate;
        }
    
        // Getter and Setter
        public Product getProduct() {
            return product;
        }
    
        public void setProduct(Product product) {
            this.product = product;
        }
    
        public int getQuantity() {
            return quantity;
        }
    
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    
        public String getAddDate() {
            return addDate;
        }
    
        public void setAddDate(String addDate) {
            this.addDate = addDate;
        }
    
}
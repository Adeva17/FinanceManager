public class Transaction {
    private String date;
    private String category;
    private double nominal;
    private String notes;

    public Transaction(String date, String category, double nominal, String notes) {
        this.date = date;
        this.category = category;
        this.nominal = nominal;
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

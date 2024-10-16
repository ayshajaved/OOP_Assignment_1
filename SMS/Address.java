public class Address {
    private String city;
    private String country;
    private int postalCode;
    Address(String city, String country, int code){
        this.city = city;
        this.country = country;
        this.postalCode = code;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String senderInfo(){
        return String.format("Sender's address: %s %d %s", getCity(), getPostalCode(), getCountry());
    }
    public String receiverInfo(){
        return String.format("Receiver's address: %s %d %s", getCity(), getPostalCode(), getCountry());
    }
}

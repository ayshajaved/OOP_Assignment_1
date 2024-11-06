public class Address {
    private String city;
    private String country;
    private int postalCode;
    Address(String city, String country, int code){
        if(city == null || country == null || city.isEmpty() || country.isEmpty()){        //Exception handling
            throw new IllegalArgumentException("City and Country cannot be null or empty");
        }
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
    //Overriden medthod toString()
    @Override
    public String toString(){
        return String.format("City: %s\nPostal Code: %d\nCountry: %s",getCity(),getPostalCode(),getCountry());
    }
}

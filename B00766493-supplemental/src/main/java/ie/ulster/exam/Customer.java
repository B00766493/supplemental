package ie.ulster.exam;

public class Customer {

    private String Destination;
    private int capacity;
    private String Features;
	private String Accessible;

    Customer() {
    }
    Customer(String Destination, int capacity, String Features, String Accessible) {

        this.Accessible = Accessible;
        this.Features = Features;
        this.capacity = capacity;
        this.Destination = Destination;
    }

    public String getDestination() {
        return Destination;
    }

    public int getCapacity() {
        return capacity;
    }
    public String getFeatures() {
        return Features;

    }
    public String getAccessible() {
        return Accessible;
    }
    public void SetDestination(String Destination) {
        this.Destination = Destination;
    }
    public void SetCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void SetFeatures(String Features) {
        this.Features = Features;
	}
    public void setAccessible(String Accessible) {
        this.Accessible = Accessible;
    }
}
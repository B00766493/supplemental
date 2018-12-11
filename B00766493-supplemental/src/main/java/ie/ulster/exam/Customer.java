package ie.ulster.exam;

public class Customer {

    private String Destination;
    private int capacity;
    private String features;
	private String Accessible;

    Customer() {
    }
    Customer(String Destination, int capacity, String Features, String Accessible) {

        this.Accessible = Accessible;
        this.features = Features;
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
        return features;

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
        this.features = Features;
	}
    public void setAccessible(String Accessible) {
        this.Accessible = Accessible;
    }
}
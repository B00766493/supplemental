package ie.ulster.exam;

public class Customer {

    private String Destination;
    private int capacity;
    private String feature;
	private String Accessible;

    Customer() {
    }
    Customer(String Destination, int capacity, String Feature, String Accessible) {

        this.Accessible = Accessible;
        this.feature = Feature;
        this.capacity = capacity;
        this.Destination = Destination;
    }

    public String getDestination() {
        return Destination;
    }

    public int getCapacity() {
        return capacity;
    }
    public String getFeature() {
        return feature;

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
    public void SetFeature(String Feature) {
        this.feature = Feature;
	}
    public void setAccessible(String Accessible) {
        this.Accessible = Accessible;
    }
}
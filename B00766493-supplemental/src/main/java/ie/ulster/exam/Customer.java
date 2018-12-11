package ie.ulster.exam;

public class Customer {

    private String Destination;
    private int rm_capacity;
    private String rm_feature;
	private String Accessible;

    Customer() {
    }
    Customer(String Destination, int capacity, String Feature, String Accessible) {

        this.Accessible = Accessible;
        this.rm_feature = Feature;
        this.rm_capacity = capacity;
        this.Destination = Destination;
    }

    public String getDestination() {
        return Destination;
    }

    public int getCapacity() {
        return rm_capacity;
    }
    public String getFeature() {
        return rm_feature;

    }
    public String getAccessible() {
        return Accessible;
    }
    public void SetDestination(String Destination) {
        this.Destination = Destination;
    }
    public void SetCapacity(int capacity) {
        this.rm_capacity = capacity;
    }
    public void SetFeature(String Feature) {
        this.rm_feature = Feature;
	}
    public void setAccessible(String Accessible) {
        this.Accessible = Accessible;
    }
}
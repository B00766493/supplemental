package ie.ulster.exam;
class Customer
{
    private String Destination;
    private String Capacity;
    private boolean Accessible;
    private String Feature;

    Customer(String Destination, String Capacity, boolean Accessible, String Feature)
    {
        this.Destination = Destination;
        this.Capacity = Capacity;
        this.Accessible = Accessible;
        this.Feature = Feature;
    }
	
	public String getDestination() {
		return Destination;
	}
	
	public void setDestination(String Destination) {
		this.Destination = Destination;
	}
	
	public String getCapacity() {
		return Capacity;
	}
	
	public void setCapacity(String Capacity) {
		this.Capacity = Capacity;
	}
	
	public boolean isAccessible() {
		return Accessible;
	}
	
	public void setAccessible(boolean Accessible) {
		this.Accessible = Accessible;
	}
	
	public String getFeature() {
		return Feature;
	}
	
	public void setFeature(String Feature) {
		this.Feature = Feature;
	}
	 
}

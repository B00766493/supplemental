package ie.ulster.exam;

public class Customer {

    private String room;
    private int rm_capacity;
    private String rm_feature;
    private String alcohol;

    Customer() {
    }

    Customer(String room, int capacity, String Feature, String Alcahol) {

        this.alcohol = Alcahol;
        this.rm_feature = Feature;
        this.rm_capacity = capacity;
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public int getCapacity() {
        return rm_capacity;
    }
    public String getFeature() {
        return rm_feature;

    }
    public String getAlcohol() {
        return alcohol;
    }
    public void SetRoom(String room) {
        this.room = room;
    }
    public void SetCapacity(int capacity) {
        this.rm_capacity = capacity;
    }
    public void SetFeature(String Feature) {
        this.rm_feature = Feature;
	}
    public void setAlcohol(String Alcahol) {
        this.alcohol = Alcahol;
    }
}
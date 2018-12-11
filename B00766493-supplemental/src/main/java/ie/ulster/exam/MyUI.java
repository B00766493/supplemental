package ie.ulster.exam;

import java.util.*;
import java.util.stream.Collectors;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.*;
import com.vaadin.ui.Grid.SelectionMode;

/**

 * This UI is the application entry point. A UI may either represent a browser

 * window (or tab) or some part of an HTML page where a Vaadin application is

 * embedded.

 * <p>

 * The UI is initialized using {@link #init(VaadinRequest)}. This method is

 * intended to be overridden to add component to the user interface and

 * initialize non-component functionality.

 */

@Theme("mytheme")

public class MyUI extends UI {
    @Override
protected void init(VaadinRequest vaadinRequest) {
         Connection connection = null;
         
        // Connect to the database in Azure by JDBC
        String connectionString =  "jdbc:sqlserver://b00766493-second.database.windows.net:1433;"+
        "database=B00766493-second-exam;"+
        "user=B00766493@b00766493-second;"+
        "password={Eoin2018*};"+
        "encrypt=true;"+
        "trustServerCertificate=false;"+
        "hostNameInCertificate=*.database.windows.net;"+
        "loginTimeout=30;";

        // User Interface design, horizontal and vertical overall
        final HorizontalLayout horizontalLayout = new HorizontalLayout();
        final VerticalLayout layout = new VerticalLayout();
        // Grid layout
        Grid<Customer> myGrid = new Grid<>();
        //myGrid.setWidth("1200px");
        myGrid.setSizeFull();
        // set the grid to the full width of the page


        // The logo in HTML
        Label logo = new Label(
        "<H1>Fun Bus Bookings</H1> <p/> <h3>Please enter the details below and click Book</h3>");
        logo.setContentMode(com.vaadin.shared.ui.ContentMode.HTML);

        // A label under the grid with student number
        Label label = new Label ("B00766493");
        
        // a textfield  
        final TextField name = new TextField();
        name.setCaption("Name of group");

        // Slider
        Slider slider = new Slider(20, 150);
        slider.setCaption("How many people attending");
        slider.setOrientation(SliderOrientation.HORIZONTAL);
        slider.setWidth("500px");// setslider width to 500 PIXELS
        slider.setValue(65.0);// Set slider value to midpoint
       
        /*
        slider.setWidth(slider.getMax()+"px");
        slider.addValueChangeListener(e ->{
            double x = slider.getValue();
            value.setValue(""+x);
        });

        value.addValueChangeListener(e ->{
            
            double x = Double.parseDouble(value.getValue());
            if (x>slider.getMax()){
                slider.setMax(x);
                slider.setWidth(x+"px");
            }
            else if (x<slider.getMin()){
                x = slider.getMin();
            }
            slider.setValue(x);
        });

*/
        // Book button
        Button button = new Button("Book");

        // label
        final Label vertvalue = new Label();

        slider.addValueChangeListener(event -> {
            int value = event.getValue().intValue();
            vertvalue.setValue(String.valueOf(value));

        });

        // Drop down selections
        ComboBox<String> comboBox = new ComboBox<>("Accessible");
        comboBox.setItems("No", "Yes");

        try {
            // Connect with JDBC driver to a database
            connection = DriverManager.getConnection(connectionString);
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM CustomerTable;");
            // Convert the resultset that comes back into a list- we need a 
            // Javaclass to represent the data (Customer.java in this case)
            List<Customer> customers = new ArrayList<Customer>();

            // While there are more records in the resultset
            while (rs.next()) {
            // Add a new customer instantiated with the fields from the record(that
            //we want, we might not want all the fields, note how I skip the ID)
                customers.add(new Customer(rs.getString("Destination"), 
                                            rs.getInt("Capacity"), 
                                            rs.getString("Feature"),
                                            rs.getString("Accessible")));

            }// Add a label to the web app and name of
            //the database we connected to 

            // Set the items (List)
            myGrid.setItems(customers);
            // Configure the order and the caption of the grid
            myGrid.addColumn(Customer::getDestination).setCaption("Destination");
            myGrid.addColumn(Customer::getCapacity).setCaption("Capacity");
            myGrid.addColumn(Customer::getFeature).setCaption("Feature");
            myGrid.addColumn(Customer::getAccessible).setCaption("Accessible");
            

        } catch (Exception e) {

            // This will show an error notyet if something went wrong
        layout.addComponent(new Label(e.getMessage()));

        }
        // create a label, initially set it to show not booked
        Label notyet = new Label();
        notyet.setValue("Your group is not booked yet");
        notyet.setContentMode(ContentMode.HTML);


        // Set the grid to be multi selectable
        myGrid.setSelectionMode(SelectionMode.MULTI);
        MultiSelect<Customer> select = myGrid.asMultiSelect();

        myGrid.addSelectionListener(event -> {
        // to returns current value of objects
        Notification.show(select.getValue().stream().map(Customer::getDestination)
        .collect(Collectors.joining(",")) + " were selected");
        });

        button.addClickListener(e -> {
        // returns the current value of the objects, a sequential stream
        // applying the given function of the elements
        String aString = select.getValue().stream().map(Customer::getAccessible).collect(Collectors.joining(","));

        int cap = select.getValue().stream().mapToInt(Customer::getCapacity).sum();

        notyet.setValue(String.valueOf(cap));
        // when all conditions have been met, the button can return "booked" etc
         String match = "true";

            // if one of the selections is incomplete, the reminders are shown
            if (myGrid.getSelectedItems().size() == 0) {
                notyet.setValue("<strong>Please select at least one bus!</strong>");

                // if name field is empty, the reminder to fill in this field will appear 
            } else if (name.isEmpty()) {
                notyet.setValue("<strong>Please enter group name.</strong>");

                // if drop down selection has not been chosed, the reminder will appear
            } else if (comboBox.isEmpty()) {
                notyet.setValue("<strong>Please confirm if your group needs an accessible bus</strong>");

                // if drop down selection is yes, display the reminder
            } else if ((comboBox.getValue() == "Yes") && (aString.equalsIgnoreCase(match))) {
                notyet.setValue(
                        "<strong>You cannot select a non-accessible bus.</strong>");

                // if slider is has chosen capacity greater than chosen Destination, display       
            } else if (slider.getValue().intValue() > cap) {
                notyet.setValue("<strong>You have selected buses with a max capacity of " + cap
                        + " which is not enough to hold </strong>" + slider.getValue().intValue());
                
                // else you are successful
            } else {
                notyet.setValue("<strong>Success! The group is booked now</strong>");
            }
        });

        // Structure 
        layout.addComponent(logo);
        horizontalLayout.addComponents(name, slider, comboBox);
        layout.addComponent(horizontalLayout);
        // sub layout
        layout.addComponent(button);
        layout.addComponent(notyet);
        layout.addComponent(myGrid);
        layout.addComponent(label);
        setContent(layout);

    }



    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)

    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)

    public static class MyUIServlet extends VaadinServlet {

    }

}
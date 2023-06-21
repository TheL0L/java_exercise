package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Agency.AgencyManager;
import Transportation.*;
import Transportation.decorators.*;
import Transportation.decorators.StatusDecorator.VehicleStatus;
import Transportation.factories.*;
import Transportation.factories.AbstractFactory.VehicleType;

/**
 * A preset JFrame extension class for adding Bicycle to the agency.
 */
public class BicycleCreationFrame extends JFrame
{
	private final String path = "src/resources/vehicles/bicycle/";
	private final String[] files = {
			"A.jpeg",
			"B.jpeg",
			"C.jpeg"
	};
	private final String[] tooltips = {
		"Image 1",
		"Image 2",
		"Image 3"
	};
	
	private GuiElement field_model;
	private GuiElement field_speed;
	private GuiElement field_seats;
	private GuiElement field_road;
	
	/**
	 * Constructor for the BicycleCreationFrame class.
	 */
	public BicycleCreationFrame()
	{
		super("Bicycle Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		

		this.add(new JLabel("Vehicle Image:"));
		
		ImagesContainer images_container = new ImagesContainer(0, 4, 100, 100, true, true);
		for (int i = 0; i < files.length; ++i)
		{
			images_container.AddImage(path + files[i], tooltips[i]);
		}
		this.add(images_container);
		
		
		field_model = new GuiElement("Vehicle model:", new JTextField(15));
		field_speed = new GuiElement("Top speed:", new DecimalTextField(15));
		field_seats = new GuiElement("Max seats:", new IntegerTextField(15));
		field_road = new GuiElement("Road type:", new RoadTypePicker());
		
		this.add(field_model);
		this.add(field_speed);
		this.add(field_seats);
		this.add(field_road);
		
		
		JButton btn_add = new JButton("Add Bicycle");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int id  = images_container.GetSelectedID();
				String model  = ((JTextField)field_model.GetComponent()).getText();
				String speed  = ((JTextField)field_speed.GetComponent()).getText();
				String seats  = ((JTextField)field_seats.GetComponent()).getText();
				int road = ((RoadTypePicker)field_road.GetComponent()).getSelectedIndex();
				
				float fspeed;
				int iseats;
				
				if (id != -1)
				{
					if ( !model.isBlank() && !speed.isBlank() && !seats.isBlank() )
					{
						fspeed = Float.parseFloat(speed);
						iseats  = Integer.parseInt(seats);
						
						if ( fspeed >= 0 && iseats >= 0 )
						{
							VehicleFactory factory = new VehicleFactory();
							BicycleBuilder builder = (BicycleBuilder) factory.Make(VehicleType.Bicycle);
							builder.SetModel(model);
							builder.SetSpeed(fspeed);
							builder.SetSeats(iseats);
							Vehicle test = new StatusDecorator(new ColorDecorator(builder.Build(), Color.BLACK), VehicleStatus.AVAILABLE);
							
							//Vehicle v = new Bicycle(model, fspeed, iseats, RoadType.values()[road]);
							AgencyManager.GetInstance().AddVehicle(test, images_container.GetSelectedImage());
							BicycleCreationFrame.this.dispose();
							return;
						}
					}
				}
				
				JOptionPane.showMessageDialog(
					BicycleCreationFrame.this,
					"Please make sure to fill all the fields, and select the necessary images.",
					"Error - Invalid Input",
					JOptionPane.ERROR_MESSAGE
				);
			}
		});
		this.add(btn_add);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

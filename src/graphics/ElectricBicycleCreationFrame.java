package graphics;

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
import Transportation.LandVehicle.RoadType;

/**
 * A preset JFrame extension class for adding ElectricBicycle to the agency.
 */
public class ElectricBicycleCreationFrame extends JFrame
{
	private final String path = "src/resources/vehicles/electric_bicycle/";
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
	private GuiElement field_fuel;
	private GuiElement field_engine;
	
	/**
	 * Constructor for the ElectricBicycleCreationFrame class.
	 */
	public ElectricBicycleCreationFrame()
	{
		super("Electric Bicycle Creation");
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
		field_fuel = new GuiElement("Fuel consumption:", new DecimalTextField(15));
		field_engine = new GuiElement("Engine life:", new DecimalTextField(15));
		
		this.add(field_model);
		this.add(field_speed);
		this.add(field_seats);
		this.add(field_road);
		this.add(field_fuel);
		this.add(field_engine);
		
		
		JButton btn_add = new JButton("Add Electric Bicycle");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int id  = images_container.GetSelectedID();
				String model  = ((JTextField)field_model.GetComponent()).getText();
				String speed  = ((JTextField)field_speed.GetComponent()).getText();
				String seats  = ((JTextField)field_seats.GetComponent()).getText();
				int road = ((RoadTypePicker)field_road.GetComponent()).getSelectedIndex();
				String fuel   = ((JTextField)field_fuel.GetComponent()).getText();
				String engine = ((JTextField)field_engine.GetComponent()).getText();
				
				float fspeed, ffuel, fengine;
				int iseats;
				
				if (id != -1)
				{
					if ( !model.isBlank() && !speed.isBlank() && !seats.isBlank() && !fuel.isBlank() && !engine.isBlank() )
					{
						fspeed = Float.parseFloat(speed);
						iseats  = Integer.parseInt(seats);
						ffuel = Float.parseFloat(fuel);
						fengine = Float.parseFloat(engine);
						
						if ( fspeed >= 0 && iseats >= 0 && ffuel >= 0 && fengine >= 0 )
						{
							Vehicle v = new ElectricBicycle(model, fspeed, iseats, RoadType.values()[road], ffuel, fengine);
							AgencyManager.GetInstance().AddVehicle(v, images_container.GetSelectedImage());
							ElectricBicycleCreationFrame.this.dispose();
							return;
						}
					}
				}
				
				JOptionPane.showMessageDialog(
					ElectricBicycleCreationFrame.this,
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

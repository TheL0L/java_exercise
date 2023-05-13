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

/**
 * A preset JFrame extension class for adding CruiseShip to the agency.
 */
public class CruiseShipCreationFrame extends JFrame
{
	private final String path = "src/resources/vehicles/cruise_ship/";
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
	private GuiElement field_fuel;
	private GuiElement field_engine;
	private GuiElement field_flag;
	
	/**
	 * Constructor for the CruiseShipCreationFrame class.
	 */
	public CruiseShipCreationFrame()
	{
		super("Cruise Ship Creation");
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
		field_fuel = new GuiElement("Fuel consumption:", new DecimalTextField(15));
		field_engine = new GuiElement("Engine life:", new DecimalTextField(15));
		field_flag = new GuiElement("Flag:", new FlagPicker(0, 7, 30, 30));
		
		this.add(field_model);
		this.add(field_speed);
		this.add(field_seats);
		this.add(field_fuel);
		this.add(field_engine);
		this.add(field_flag);
		
		
		JButton btn_add = new JButton("Add Cruise Ship");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int id  = images_container.GetSelectedID();
				int idf = ((FlagPicker)field_flag.GetComponent()).GetSelectedID();
				String model  = ((JTextField)field_model.GetComponent()).getText();
				String speed  = ((JTextField)field_speed.GetComponent()).getText();
				String seats  = ((JTextField)field_seats.GetComponent()).getText();
				String fuel    = ((JTextField)field_fuel.GetComponent()).getText();
				String engine  = ((JTextField)field_engine.GetComponent()).getText();
				
				float fspeed, ffuel, fengine;
				int iseats;
				String flag;
				
				if (id != -1 && idf != -1)
				{
					if ( !model.isBlank() && !speed.isBlank() && !seats.isBlank()
							&& !fuel.isBlank() && !engine.isBlank() )
					{
						fspeed = Float.parseFloat(speed);
						ffuel  = Float.parseFloat(fuel);
						fengine = Float.parseFloat(engine);
						iseats  = Integer.parseInt(seats);
						flag = ((FlagPicker)field_flag.GetComponent()).GetFlagName();
						
						if ( fspeed >= 0 && ffuel >= 0 && fengine >= 0 && iseats >= 0 )
						{
							Vehicle v = new CruiseShip(model, fspeed, iseats, flag, ffuel, fengine);
							AgencyManager.GetInstance().AddVehicle(v, images_container.GetSelectedImage());
							CruiseShipCreationFrame.this.dispose();
							return;
						}
					}
				}
				
				JOptionPane.showMessageDialog(
					CruiseShipCreationFrame.this,
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

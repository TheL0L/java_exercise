package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Agency.AgencyManager;
import Transportation.*;
import Transportation.decorators.ColorDecorator;
import Transportation.decorators.StatusDecorator;
import Transportation.decorators.StatusDecorator.VehicleStatus;
import Transportation.factories.JeepBuilder;
import Transportation.factories.VehicleFactory;
import Transportation.factories.AbstractFactory.VehicleType;

/**
 * A preset JFrame extension class for adding Jeep to the agency.
 */
public class JeepCreationFrame extends JFrame
{
	private final String path = "src/resources/vehicles/jeep/";
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
	private GuiElement field_fuel;
	private GuiElement field_engine;
	
	/**
	 * Constructor for the JeepCreationFrame class.
	 */
	public JeepCreationFrame()
	{
		super("Jeep Creation");
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
		field_fuel = new GuiElement("Fuel consumption:", new DecimalTextField(15));
		field_engine = new GuiElement("Engine life:", new DecimalTextField(15));
		
		this.add(field_model);
		this.add(field_speed);
		this.add(field_fuel);
		this.add(field_engine);
		
		
		JButton btn_add = new JButton("Add Jeep");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int id = images_container.GetSelectedID();
				String model  = ((JTextField)field_model.GetComponent()).getText();
				String speed  = ((JTextField)field_speed.GetComponent()).getText();
				String fuel   = ((JTextField)field_fuel.GetComponent()).getText();
				String engine = ((JTextField)field_engine.GetComponent()).getText();
				
				float fspeed, ffuel, fengine;
				
				if (id != -1)
				{
					if ( !model.isBlank() && !speed.isBlank() && !fuel.isBlank() && !engine.isBlank() )
					{
						fspeed = Float.parseFloat(speed);
						ffuel = Float.parseFloat(fuel);
						fengine = Float.parseFloat(engine);
						
						if ( fspeed >= 0 && ffuel >= 0 && fengine >= 0 )
						{
							VehicleFactory factory = new VehicleFactory();
							JeepBuilder builder = (JeepBuilder) factory.Make(VehicleType.Jeep);
							builder.SetModel(model);
							builder.SetSpeed(fspeed);
							builder.SetFuelConsumption(ffuel);
							builder.SetEngineLife(fengine);
							//Vehicle test = new StatusDecorator(new ColorDecorator(builder.Build(), Color.BLACK), VehicleStatus.AVAILABLE);
							builder.SetStatus(VehicleStatus.AVAILABLE);
							builder.SetColor(Color.BLACK);
							Vehicle test = builder.Build();
							
							//Vehicle v = new Jeep(model, ffuel, fspeed, fengine);
							AgencyManager.GetInstance().AddVehicle(test, images_container.GetSelectedImage());
							JeepCreationFrame.this.dispose();
							return;
						}
					}
				}
				
				JOptionPane.showMessageDialog(
					JeepCreationFrame.this,
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

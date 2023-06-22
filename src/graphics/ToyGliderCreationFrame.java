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
import Transportation.factories.AbstractFactory.VehicleType;
import Transportation.factories.ToyGliderBuilder;
import Transportation.factories.VehicleFactory;

/**
 * A preset JFrame extension class for adding ToyGlider to the agency.
 */
public class ToyGliderCreationFrame extends JFrame
{
	private final String path = "src/resources/vehicles/toy_glider/";
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
	
	private GuiElement field_source;
	
	/**
	 * Constructor for the ToyGliderCreationFrame class.
	 */
	public ToyGliderCreationFrame()
	{
		super("Toy Glider Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		

		this.add(new JLabel("Vehicle Image:"));
		
		ImagesContainer images_container = new ImagesContainer(0, 4, 100, 100, true, true);
		for (int i = 0; i < files.length; ++i)
		{
			images_container.AddImage(path + files[i], tooltips[i]);
		}
		this.add(images_container);
		
		
		JButton btn_add = new JButton("Add Toy Glider");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int id = images_container.GetSelectedID();
				
				if (id != -1)
				{
					VehicleFactory factory = new VehicleFactory();
					ToyGliderBuilder builder = (ToyGliderBuilder) factory.Make(VehicleType.ToyGlider);
					//iVehicle test = new StatusDecorator(new ColorDecorator(builder.Build(), Color.BLACK), VehicleStatus.AVAILABLE);
					builder.SetStatus(VehicleStatus.AVAILABLE);
					builder.SetColor(Color.BLACK);
					Vehicle test = builder.Build();
					
					//Vehicle v = new ToyGlider();
					AgencyManager.GetInstance().AddVehicle((Vehicle)test, images_container.GetSelectedImage());
					ToyGliderCreationFrame.this.dispose();
					return;
				}
				
				JOptionPane.showMessageDialog(
					ToyGliderCreationFrame.this,
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

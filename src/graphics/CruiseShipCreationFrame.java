package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Transportation.*;

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
	private final String[] flags = {
			"src/resources/flags/germany.png",
			"src/resources/flags/greece.png",
			"src/resources/flags/israel.png",
			"src/resources/flags/italy.png",
			"src/resources/flags/pirate.jpeg",
			"src/resources/flags/somalia.png",
			"src/resources/flags/usa.png"
	};
	private final String[] flags_tooltips = {
			"Germany",
			"Greece",
			"Israel",
			"Italy",
			"Pirate",
			"Somalia",
			"United States of America"
	};
	
	private GuiElement field_model;
	private GuiElement field_speed;
	private GuiElement field_seats;
	private GuiElement field_fuel;
	private GuiElement field_engine;
	private GuiElement field_flag;
	
	public CruiseShipCreationFrame()
	{
		super("Cruise Ship Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		

		ImagesContainer images_container = new ImagesContainer(0, 4, 100, 100, true);
		for (int i = 0; i < files.length; ++i)
		{
			images_container.AddImage(path + files[i], tooltips[i]);
		}
		this.add(images_container);
		
		ImagesContainer flags_container = new ImagesContainer(0, 7, 30, 30, false);
		for (int i = 0; i < flags.length; ++i)
		{
			flags_container.AddImage(flags[i], flags_tooltips[i]);
		}
		
		
		field_model = new GuiElement("Vehicle model:", new JTextField(15));
		field_speed = new GuiElement("Top speed:", new JTextField(15));
		field_seats = new GuiElement("Max seats:", new JTextField(15));
		field_fuel = new GuiElement("Fuel consumption:", new JTextField(15));
		field_engine = new GuiElement("Engine life:", new JTextField(15));
		field_flag = new GuiElement("Flag:", flags_container);
		
		this.add(field_model);
		this.add(field_speed);
		this.add(field_seats);
		this.add(field_fuel);
		this.add(field_engine);
		this.add(field_flag);
		
		
		JButton btn_add = new JButton("Add Cruise Ship");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: check if inputs are valid, then add vehicle and/or close window
				int option = JOptionPane.showConfirmDialog(
						CruiseShipCreationFrame.this,
					"Are you sure you want to close this window?",
					"Confirm Close",
					JOptionPane.YES_NO_OPTION
				);
				
		        if (option == JOptionPane.YES_OPTION) {
		            dispose(); // close the JFrame
		        }
			}
		});
		this.add(btn_add);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

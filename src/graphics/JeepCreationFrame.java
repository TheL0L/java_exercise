package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Transportation.*;

public class JeepCreationFrame extends JFrame
{
	private final String path = "src/resources/vehicles/jeep/";
	private final String[] files = {
			"A.jpeg",
			"B.jpeg",
			"C.jpeg"
	};
	private final String[] tooltips = {
		"",
		"",
		""
	};
	
	private GuiElement field_model;
	private GuiElement field_speed;
	private GuiElement field_fuel;
	private GuiElement field_engine;
	
	public JeepCreationFrame()
	{
		super("Jeep Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		

		ImagesContainer images_container = new ImagesContainer(0, 4, 100, 100, true);
		for (int i = 0; i < files.length; ++i)
		{
			images_container.AddImage(path + files[i], tooltips[i]);
		}
		this.add(images_container);
		
		
		field_model = new GuiElement("Vehicle model:", new JTextField(15));
		field_speed = new GuiElement("Top speed:", new JTextField(15));
		field_fuel = new GuiElement("Fuel consumption:", new JTextField(15));
		field_engine = new GuiElement("Engine life:", new JTextField(15));
		
		this.add(field_model);
		this.add(field_speed);
		this.add(field_fuel);
		this.add(field_engine);
		
		
		JButton btn_add = new JButton("Add Jeep");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: check if inputs are valid, then add vehicle and/or close window
				int option = JOptionPane.showConfirmDialog(
					JeepCreationFrame.this,
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

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
	
	public BicycleCreationFrame()
	{
		super("Bicycle Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		

		ImagesContainer images_container = new ImagesContainer(0, 4, 100, 100, true);
		for (int i = 0; i < files.length; ++i)
		{
			images_container.AddImage(path + files[i], tooltips[i]);
		}
		this.add(images_container);
		
		
		field_model = new GuiElement("Vehicle model:", new JTextField(15));
		field_speed = new GuiElement("Top speed:", new JTextField(15));
		field_seats = new GuiElement("Max seats:", new JTextField(15));
		field_road = new GuiElement("Road type:", new JTextField(15));
		
		this.add(field_model);
		this.add(field_speed);
		this.add(field_seats);
		this.add(field_road);
		
		
		JButton btn_add = new JButton("Add Bicycle");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: check if inputs are valid, then add vehicle and/or close window
				int option = JOptionPane.showConfirmDialog(
						BicycleCreationFrame.this,
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

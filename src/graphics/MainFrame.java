package graphics;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class MainFrame extends JFrame
{
	public MainFrame()
	{
		super("Transportation Agency");
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		String vehicle_types[] = {
				"Jeep",
				"Frigate",
				"Spy Glider",
				"Toy Glider",
				"Amphibious Vehicle",
				"Bicycle",
				"Cruise Ship"
		};
		
		JComboBox<String> cbox_types = new JComboBox<String>(vehicle_types);
		GuiElement boxlist = new GuiElement("Available types:", cbox_types);
		this.add(boxlist);
		
		GuiElement field_model = new GuiElement("Vehicle model:", new JTextField(15));
		this.add(field_model);
		
		GuiElement field_speed = new GuiElement("Top speed:", new JTextField(15));
		this.add(field_speed);
		
		GuiElement field_seats = new GuiElement("Max seats:", new JTextField(15));
		this.add(field_seats);
		
		
		JButton btn_add = new JButton("Add Vehicle");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.add(btn_add);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

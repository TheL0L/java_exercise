package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

import Transportation.*;

public class VehicleCreationFrame extends JFrame
{
	private GuiElement boxlist;
	private GuiElement field_model;
	private GuiElement field_speed;
	private GuiElement field_seats;
	private GuiElement field_fuel;
	private GuiElement field_engine;
	private GuiElement field_source;
	private GuiElement field_score;
	private GuiElement field_road;
	private GuiElement field_direction;
	private GuiElement field_flag;
	
	private final String vehicle_types[] = {
			"Jeep",
			"Frigate",
			"Spy Glider",
			"Toy Glider",
			"Bicycle",
			"Cruise Ship",
			"Amphibious Vehicle"
	};
	
	public VehicleCreationFrame()
	{
		super("Vehicle Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		
		JComboBox<String> cbox_types = new JComboBox<String>(vehicle_types);
		cbox_types.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	disable_fields();
            	enable_fields(cbox_types.getSelectedIndex());
            }
        });
		boxlist = new GuiElement("Available types:", cbox_types);
		this.add(boxlist);
		
		
		field_model = new GuiElement("Vehicle model:", new JTextField(15));
		field_speed = new GuiElement("Top speed:", new JTextField(15));
		field_seats = new GuiElement("Max seats:", new JTextField(15));
		field_fuel = new GuiElement("Fuel consumption:", new JTextField(15));
		field_engine = new GuiElement("Engine life:", new JTextField(15));
		field_source = new GuiElement("Power source:", new JTextField(15));
		field_score = new GuiElement("Power score:", new JTextField(15));
		field_road = new GuiElement("Road type:", new JTextField(15));
		field_direction = new GuiElement("Direction:", new JTextField(15));
		field_flag = new GuiElement("Flag:", new JTextField(15));
		
		this.add(boxlist);
		this.add(field_model);
		this.add(field_speed);
		this.add(field_seats);
		this.add(field_fuel);
		this.add(field_engine);
		this.add(field_source);
		this.add(field_score);
		this.add(field_road);
		this.add(field_direction);
		this.add(field_flag);
		
		disable_fields();
		enable_fields(cbox_types.getSelectedIndex());
		
		
		JButton btn_add = new JButton("Add Vehicle");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: check if inputs are valid, then add vehicle and/or close window
				int option = JOptionPane.showConfirmDialog(
					VehicleCreationFrame.this,
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
	
	private void disable_fields()
	{
		field_model.setVisible(false);
    	field_speed.setVisible(false);
    	field_seats.setVisible(false);
    	field_fuel.setVisible(false);
    	field_engine.setVisible(false);
    	field_source.setVisible(false);
    	field_score.setVisible(false);
    	field_road.setVisible(false);
    	field_direction.setVisible(false);
    	field_flag.setVisible(false);
    	
    	this.pack();
	}
	
	private void enable_fields(int selected_index)
	{
		switch (selected_index)
        {
        default:
        case 0: // jeep
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_fuel.setVisible(true);
        	field_engine.setVisible(true);
        	break;
        	
        case 1: // frigate
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_direction.setVisible(true);
        	break;
        	
        case 2: // spy
        	field_source.setVisible(true);
        	break;
        	
        case 3: // toy
        	break;
        	
        case 4: // bicycle
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_road.setVisible(true);
        	break;
        
        case 5: // cruise
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_fuel.setVisible(true);
        	field_engine.setVisible(true);
        	field_flag.setVisible(true);
        	break;
        	
        case 6: // amphibious
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_fuel.setVisible(true);
        	field_engine.setVisible(true);
        	field_source.setVisible(true);
        	field_score.setVisible(true);
        	field_road.setVisible(true);
        	field_direction.setVisible(true);
        	field_flag.setVisible(true);
        	break;
        }

    	this.pack();
	}
	
	/*
	private void create_vehicle(int selected_index)
	{
		switch (selected_index)
        {
        default:
        case 0: // jeep
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_fuel.setVisible(true);
        	field_engine.setVisible(true);
        	return new Jeep(model_name, fuel_consumption, max_speed, engine_life_expectancy);
        	
        case 1: // frigate
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_direction.setVisible(true);
        	return new Frigate(model_name, max_speed, max_seats, swimming_with_wind);
        	
        case 2: // spy
        	field_source.setVisible(true);
        	return new SpyGlider(power_source);
        	
        case 3: // toy
        	return new ToyGlider();
        	
        case 4: // bicycle
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_road.setVisible(true);
        	return new Bicycle();
        
        case 5: // cruise
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_fuel.setVisible(true);
        	field_engine.setVisible(true);
        	field_flag.setVisible(true);
        	return new CruiseShip();
        	
        case 6: // amphibious
        	field_model.setVisible(true);
        	field_speed.setVisible(true);
        	field_seats.setVisible(true);
        	field_fuel.setVisible(true);
        	field_engine.setVisible(true);
        	field_source.setVisible(true);
        	field_score.setVisible(true);
        	field_road.setVisible(true);
        	field_direction.setVisible(true);
        	field_flag.setVisible(true);
        	return new Amphibious();
        }
	}*/
	
}

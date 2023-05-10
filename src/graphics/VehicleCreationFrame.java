package graphics;

import java.awt.GridLayout;
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
	public VehicleCreationFrame()
	{
		super("Vehicle Creation");
		this.setLayout(new GridLayout(4,2));
		
		JButton jeep_add = new JButton("Add Jeep");
		jeep_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JeepCreationFrame frame = new JeepCreationFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton frigate_add = new JButton("Add Frigate");
		frigate_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrigateCreationFrame frame = new FrigateCreationFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton amphibious_add = new JButton("Add Amphibious");
		amphibious_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AmphibiousCreationFrame frame = new AmphibiousCreationFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton spyglider_add = new JButton("Add Spy Glider");
		spyglider_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SpyGliderCreationFrame frame = new SpyGliderCreationFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton toyglider_add = new JButton("Add Toy Glider");
		toyglider_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ToyGliderCreationFrame frame = new ToyGliderCreationFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton bicycle_add = new JButton("Add Bicycle");
		bicycle_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BicycleCreationFrame frame = new BicycleCreationFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		JButton cruiseship_add = new JButton("Add Cruise Ship");
		cruiseship_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CruiseShipCreationFrame frame = new CruiseShipCreationFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		
		JButton btn_add = new JButton("Exit Setup");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: check if agency size > 0
				
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
		
		
		this.add(jeep_add);
		this.add(frigate_add);
		this.add(amphibious_add);
		this.add(spyglider_add);
		this.add(toyglider_add);
		this.add(bicycle_add);
		this.add(cruiseship_add);
		this.add(btn_add);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

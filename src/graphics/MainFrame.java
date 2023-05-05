package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import Transportation.Vehicle;


public class MainFrame extends JFrame
{
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public MainFrame()
	{
		super("Transportation Agency");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JButton btn_add = new JButton("Add Vehicle");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VehicleCreationFrame creation_frame = new VehicleCreationFrame();
				creation_frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		this.add(btn_add);
		
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
}

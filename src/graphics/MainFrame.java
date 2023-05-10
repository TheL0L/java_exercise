package graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Agency.AgencyManager;

public class MainFrame extends JFrame
{
	public MainFrame()
	{
		super("Transportation Agency");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.add(new JLabel("Available Vehicles:"));
		
		
		AgencyManager agm = AgencyManager.GetInstance();
		int vehicles = agm.GetVehiclesCount();
		ImagesContainer images_container = new ImagesContainer(0, 4, 125, 125, false);
		for (int i = 0; i < vehicles; ++i)
		{
			images_container.AddImage(agm.GetVehicleImage(i), agm.GetVehicleTooltip(i));
		}
		this.add(images_container);
		
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
}

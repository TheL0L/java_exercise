package graphics;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Agency.AgencyManager;
import Transportation.Vehicle;

/**
 * A preset JFrame extension class for displaying all vehicles and allowing calling actions on them.
 */
public class MainFrame extends JFrame
{
	private ImagesContainer images_container;
	
	/**
	 * Constructor for the MainFrame class.
	 */
	public MainFrame()
	{
		super("Transportation Agency");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		AgencyManager agm = AgencyManager.GetInstance();
		
		this.add(new JLabel("Available Vehicles:"));
		images_container = new ImagesContainer(0, 4, 125, 125, false, false);
		this.add(images_container);
		
		for (Integer vehicle_id : agm.GetVehicleIDs())
		{
			images_container.AddImageButton(
				new ImageButton(agm.GetVehicleImage(vehicle_id), agm.GetVehicleTooltip(vehicle_id), 0, 0)
				{
					@Override
					protected void onLeftClick()
					{
						super.onLeftClick();
						
						VehicleActionDialog dialog = new VehicleActionDialog(
							MainFrame.this, "Select Action", agm.GetVehicleDescription(vehicle_id),
							agm.GetVehicleImage(vehicle_id), vehicle_id
						);

						if (dialog.ShowDialog() == -1)
						{
							images_container.remove(this);
						}
						
						this.setToolTipText(AgencyManager.GetInstance().GetVehicleTooltip(vehicle_id));
						images_container.repaint();
					}
					
					@Override
					public void UpdateTooltip()
					{
						this.setToolTipText(agm.GetVehicleTooltip(vehicle_id));
					}
				}
			);
		}
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
		JButton breset = new JButton("Reset travel distance (all vehicles)");
		breset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agm.ResetAllVehiclesTravelDistance();
				images_container.UpdateTooltips();
			}
		});
		JButton bexit = new JButton("Exit");
		bexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		buttons.add(breset);
		buttons.add(bexit);
		this.add(buttons);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

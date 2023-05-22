package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Agency.AgencyManager;


public class InventoryReportFrame extends JFrame
{
	private ImagesContainer images_container;
	private AgencyManager agm;
	
	/**
	 * Constructor for the InventoryReportFrame class.
	 */
	public InventoryReportFrame()
	{
		super("Inventory Report");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.agm = AgencyManager.GetInstance();
		
		this.add(new JLabel("Available Vehicles:"));

		this.UpdateInventory();
		
		// TODO: replace button with a proper actionlistener
		JButton bstock = new JButton("Update");
		bstock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InventoryReportFrame.this.UpdateInventory();
			}
		});
		this.add(bstock);
		// TODO: button ends here
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * Method for updating the contents of the images_container.
	 */
	private void UpdateInventory()
	{
		if (this.images_container != null)
		{
			this.remove(this.images_container);			
		}
		
		this.images_container = new ImagesContainer(0, 4, 125, 125, false, false);
		this.add(images_container);
		
		for (Integer vehicle_id : agm.GetVehicleIDs())
		{
			images_container.AddImageButton(
				new ImageButton(agm.GetVehicleImage(vehicle_id), agm.GetVehicleTooltip(vehicle_id), 0, 0)
				{
					@Override
					public void UpdateTooltip()
					{
						this.setToolTipText(agm.GetVehicleTooltip(vehicle_id));
					}
				}
			);
		}
		
		this.pack();
		this.repaint();
	}
}

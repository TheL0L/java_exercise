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
import Agency.Event;
import Agency.EventPerformer;
import Agency.iEventHandler;
import Transportation.Vehicle;

/**
 * A preset JFrame extension class for displaying all vehicles and allowing calling actions on them.
 */
public class MainFrame extends JFrame implements iEventHandler
{
	private ImagesContainer images_container;
	private JPanel images_panel;
	
	/**
	 * Constructor for the MainFrame class.
	 */
	public MainFrame()
	{
		super("Transportation Agency");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		AgencyManager agm = AgencyManager.GetInstance();
		agm.GetEventService().Subscribe(this);
		
		this.add(new JLabel("Available Vehicles:"));
		images_panel = new JPanel();
		CreateImagesContainer();
		this.add(images_panel);
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
		JButton breset = new JButton("Reset travel distance (all vehicles)");
		breset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agm.ResetAllVehiclesTravelDistance();
				UpdateFrame();
			}
		});
		JButton bstock = new JButton("View Inventory Report");
		bstock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InventoryReportFrame report = new InventoryReportFrame();
				report.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		buttons.add(bstock);
		buttons.add(bexit);
		this.add(buttons);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void CreateImagesContainer()
	{
		AgencyManager agm = AgencyManager.GetInstance();
		images_container = new ImagesContainer(0, 4, 125, 125, false, false);
		images_panel.add(images_container);
		
		for (Integer vehicle_id : agm.GetVehicleIDs())
		{
			images_container.AddImageButton(
				new ImageButton(agm.GetVehicleImage(vehicle_id), agm.GetVehicleTooltip(vehicle_id), 0, 0)
				{
					@Override
					protected void onLeftClick()
					{
						super.onLeftClick();
						
						VehicleActionFrame action_frame = new VehicleActionFrame(
							"Select Action", agm.GetVehicleDescription(vehicle_id),
							agm.GetVehicleImage(vehicle_id), vehicle_id
						);
					}
					
					@Override
					public void UpdateTooltip()
					{
						this.setToolTipText(agm.GetVehicleTooltip(vehicle_id));
					}
				}
			);
		}
	}
	
	private void UpdateFrame()
	{
		images_container.UpdateTooltips();
		images_container.repaint();
		this.pack();
	}

	@Override
	public synchronized void Update(int unique_id, Event event)
	{
		switch (event)
		{
		case PURCHASE:
			this.images_panel.remove(images_container);
			this.CreateImagesContainer();
			this.images_panel.repaint();
			break;
			
		case TEST_DRIVE:
		case FLAG_CHANGE:
		}
		UpdateFrame();
		System.out.println("MainFrame Update() called by event:" + event.name());
	}
}

package graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Agency.AgencyManager;
import Agency.Event;
import Agency.EventPerformer;
import Transportation.AmphibiousVehicle;
import Transportation.NavalVehicle;
import Transportation.Vehicle;

/**
 * A preset JFrame extension class for presenting available actions.
 */
public class VehicleActionFrame extends JFrame
{
	private int vehicle_id;
	private EventPerformer event_performer;
	
	/**
	 * Constructor for the VehicleActionFrame class.
	 * 
	 * @param title      string containing the VehicleActionFrame instance title.
	 * @param prompt     string containing the VehicleActionFrame instance prompt.
	 * @param image      image containing the image data to be displayed in the VehicleActionFrame instance.
	 * @param vehicle_id the unique id that is given to each vehicle during creation.
	 */
    public VehicleActionFrame(String title, String prompt, Image image, int vehicle_id)
    {
        super(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        this.vehicle_id = vehicle_id;
        this.event_performer = new EventPerformer(AgencyManager.GetInstance().GetEventService());
        
        JPanel description = new JPanel();
        JTextArea text = new JTextArea(prompt);
        text.setEditable(false);
        
        description.add(new ImageButton(image, null, 100, 100));
        description.add(text);
        add(description, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton bdrive = new JButton("Test Drive");
        JButton bflag = new JButton("Change Flag");
        JButton bbuy = new JButton("Purchase");
        
        buttons.add(bdrive);
        buttons.add(bflag);
        buttons.add(bbuy);
        add(buttons, BorderLayout.SOUTH);

        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        
        Vehicle ref = AgencyManager.GetInstance().GetVehicle(vehicle_id);
        if (!(ref instanceof NavalVehicle) && !(ref instanceof AmphibiousVehicle))
        {
        	bflag.setEnabled(false);
        }

        bdrive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	DistancePromptDialog dialog = new DistancePromptDialog(
            			null, "Enter test drive distance", vehicle_id
            			);
            	dialog.setVisible(true);
            	event_performer.NotifyService(vehicle_id, Event.TEST_DRIVE);
            	
            	AnnoyingDatabaseDelayWindow();
                dispose();
            }
        });
        bflag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	FlagPromptDialog dialog = new FlagPromptDialog(null, "Select new flag", vehicle_id);
            	dialog.setVisible(true);
            	event_performer.NotifyService(vehicle_id, Event.FLAG_CHANGE);
            	
            	AnnoyingDatabaseDelayWindow();
                dispose();
            }
        });
        bbuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	int interval = 5000 + (int)(Math.random() * 3000);
            	AnnoyingWait(interval);
            	
            	int option = JOptionPane.showConfirmDialog(
        			VehicleActionFrame.this,
					"Are you sure you want to purchase this vehicle?",
					"Confirm Purchase",
					JOptionPane.YES_NO_OPTION
				);
				
		        if (option == JOptionPane.YES_OPTION)
		        {
		        	JOptionPane.showMessageDialog(
            			VehicleActionFrame.this,
						"Thank you for your patronage!",
						"Success",
						JOptionPane.INFORMATION_MESSAGE
					);
	            	
	            	AgencyManager.GetInstance().RemoveVehicle(vehicle_id);
	            	event_performer.NotifyService(vehicle_id, Event.PURCHASE);
	                dispose();
	            	
	            	AnnoyingDatabaseDelayWindow();
		        }
            }
        });
    }
    
    public synchronized void AnnoyingWait(int interval_ms)
    {
    	try
		{
			Thread.sleep(interval_ms);
		}
    	catch (InterruptedException err)
		{
			err.printStackTrace();
		}
    }
    
    public synchronized void AnnoyingDatabaseDelayWindow()
    {
		int interval = 5000 + (int)(Math.random() * 3000);
    	
		new AnnoyingDelayWindow(
			this,
			"Updating Database",
			"Updating database, please wait [5-8] non-imaginary seconds, why? no idea...",
			interval
		);
    	
        dispose();
    }
}

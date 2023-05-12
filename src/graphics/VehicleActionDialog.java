package graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Agency.AgencyManager;
import Transportation.Vehicle;

/**
 * A preset JDialog extension class for presenting available actions.
 */
public class VehicleActionDialog extends JDialog
{
	private int return_value;
	private int vehicle_id;
	
	/**
	 * Constructor for the VehicleActionDialog class.
	 * 
	 * @param parent     reference to the parent frame.
	 * @param title      string containing the VehicleActionDialog instance title.
	 * @param prompt     string containing the VehicleActionDialog instance prompt.
	 * @param image      image containing the image data to be displayed in the VehicleActionDialog instance.
	 * @param vehicle_id the unique id that is given to each vehicle during creation.
	 */
    public VehicleActionDialog(Frame parent, String title, String prompt, Image image, int vehicle_id)
    {
        super(parent, title, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        this.return_value = 0;
        this.vehicle_id = vehicle_id;
        
        JPanel description = new JPanel();
        JTextArea text = new JTextArea(prompt);
        text.setEditable(false);
        
        description.add(new ImageButton(image, null, 100, 100));
        description.add(text);
        add(description, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton bdrive = new JButton("Test Drive");
        JButton bbuy = new JButton("Purchase");
        
        buttons.add(bdrive);
        buttons.add(bbuy);
        add(buttons, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);

        bdrive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	DistancePromptDialog dialog = new DistancePromptDialog(
            			null, "Enter test drive distance", AgencyManager.GetInstance().GetVehicle(vehicle_id)
            			);
            	dialog.setVisible(true);
                dispose();
            }
        });
        bbuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	JOptionPane.showMessageDialog(
            			VehicleActionDialog.this,
						"Thank you for your patronage!",
						"Success",
						JOptionPane.INFORMATION_MESSAGE
					);
            	
            	AgencyManager.GetInstance().RemoveVehicle(vehicle_id);
            	VehicleActionDialog.this.return_value = -1;
                dispose();
            }
        });
    }

    /**
     * Method for opening the dialog.
     * 
     * @return integer exit code, -1 for purchase.
     */
	public int ShowDialog()
	{
		this.setVisible(true);
		return this.return_value;
	}
}

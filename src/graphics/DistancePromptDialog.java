package graphics;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Agency.AgencyManager;
import Transportation.Vehicle;

/**
 * A preset JDialog extension class for performing a test drive action on a vehicle.
 */
public class DistancePromptDialog extends JDialog
{
	private int vehicle_id;

	/**
	 * Constructor for the DistancePromptDialog class.
	 * 
	 * @param parent     reference to the parent frame.
	 * @param title      string containing the DistancePromptDialog instance title.
	 * @param vehicle_id the unique id that is given to each vehicle during creation.
	 */
	public DistancePromptDialog(Frame parent, String title, int vehicle_id)
	{
        super(parent, title, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        this.vehicle_id = vehicle_id;
        
        GuiElement field_distance = new GuiElement("Test drive distance:", new DecimalTextField(15));
        add(field_distance, BorderLayout.CENTER);

        JButton button = new JButton("Confirm");
        add(button, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
        

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	String distance = ((JTextField)field_distance.GetComponent()).getText();
            	float fdistance;
            	
            	if ( !distance.isBlank() )
            	{
            		fdistance = Float.parseFloat(distance);
            		if ( fdistance > 0 )
            		{
            			Boolean result = AgencyManager.GetInstance().TestDrive(vehicle_id, fdistance);
            			if (result == false)
            			{
            				JOptionPane.showMessageDialog(
        						null,
        						"Couldn't perform a test drive, no free drivers.",
        						"Error",
        						JOptionPane.ERROR_MESSAGE
    						);
            			}
            			dispose();
            			return;
            		}
            	}
            	
            	JOptionPane.showMessageDialog(
        			DistancePromptDialog.this,
					"Test drive distance has to be a positive numerical value.",
					"Error - Invalid Input",
					JOptionPane.ERROR_MESSAGE
				);
            }
        });
    }
}

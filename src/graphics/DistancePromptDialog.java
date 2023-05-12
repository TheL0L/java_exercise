package graphics;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Transportation.Vehicle;

/**
 * A preset JDialog extension class for performing a test drive action on a vehicle.
 */
public class DistancePromptDialog extends JDialog
{
	private Vehicle vehicle_reference;

	/**
	 * Constructor for the DistancePromptDialog class.
	 * 
	 * @param parent     reference to the parent frame.
	 * @param title      string containing the VehicleActionDialog instance title.
	 * @param vehicle_id the unique id that is given to each vehicle during creation.
	 */
	public DistancePromptDialog(Frame parent, String title, Vehicle vehicle_reference)
	{
        super(parent, title, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        this.vehicle_reference = vehicle_reference;
        
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
            			vehicle_reference.Move(fdistance);
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

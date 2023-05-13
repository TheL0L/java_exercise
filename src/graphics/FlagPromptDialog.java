package graphics;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Agency.AgencyManager;
import Transportation.Vehicle;

/**
 * A preset JDialog extension class for performing a flag swap on a vehicle.
 */
public class FlagPromptDialog extends JDialog
{
	private int vehicle_id;

	/**
	 * Constructor for the FlagPromptDialog class.
	 * 
	 * @param parent     reference to the parent frame.
	 * @param title      string containing the FlagPromptDialog instance title.
	 * @param vehicle_id the unique id that is given to each vehicle during creation.
	 */
	public FlagPromptDialog(Frame parent, String title, int vehicle_id)
	{
        super(parent, title, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        this.vehicle_id = vehicle_id;
        
        GuiElement field_flag = new GuiElement("Available flags:", new FlagPicker(0, 7, 75, 75));
        add(field_flag, BorderLayout.CENTER);

        JButton button = new JButton("Confirm");
        add(button, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
        

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	int selected = ((FlagPicker)field_flag.GetComponent()).GetSelectedID();
            	
            	if ( selected != -1 )
            	{
            		String flag = ((FlagPicker)field_flag.GetComponent()).GetFlagName();
            		AgencyManager.GetInstance().ChangeVehicleFlag(vehicle_id, flag);
        			dispose();
        			return;
            	}
            	
            	JOptionPane.showMessageDialog(
        			FlagPromptDialog.this,
					"A flag has to be selected to procced.",
					"Error - Missing Input",
					JOptionPane.ERROR_MESSAGE
				);
            }
        });
    }
}

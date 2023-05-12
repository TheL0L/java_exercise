package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Agency.AgencyManager;
import Transportation.*;

/**
 * A preset JFrame extension class for adding SpyGlider to the agency.
 */
public class SpyGliderCreationFrame extends JFrame
{
	private final String path = "src/resources/vehicles/spy_glider/";
	private final String[] files = {
			"A.jpeg",
			"B.jpeg",
			"C.jpeg"
	};
	private final String[] tooltips = {
		"Image 1",
		"Image 2",
		"Image 3"
	};
	
	private GuiElement field_source;
	
	/**
	 * Constructor for the SpyGliderCreationFrame class.
	 */
	public SpyGliderCreationFrame()
	{
		super("Spy Glider Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		

		this.add(new JLabel("Vehicle Image:"));
		
		ImagesContainer images_container = new ImagesContainer(0, 4, 100, 100, true, true);
		for (int i = 0; i < files.length; ++i)
		{
			images_container.AddImage(path + files[i], tooltips[i]);
		}
		this.add(images_container);
		
		
		field_source = new GuiElement("Power source:", new JTextField(15));
		
		this.add(field_source);
		
		
		JButton btn_add = new JButton("Add Spy Glider");
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int id = images_container.GetSelectedID();
				String source  = ((JTextField)field_source.GetComponent()).getText();
				
				if (id != -1)
				{
					if ( !source.isBlank() )
					{
						Vehicle v = new SpyGlider(source);
						AgencyManager.GetInstance().AddVehicle(v, images_container.GetSelectedImage());
						SpyGliderCreationFrame.this.dispose();
						return;
					}
				}
				
				JOptionPane.showMessageDialog(
					SpyGliderCreationFrame.this,
					"Please make sure to fill all the fields, and select the necessary images.",
					"Error - Invalid Input",
					JOptionPane.ERROR_MESSAGE
				);
			}
		});
		this.add(btn_add);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

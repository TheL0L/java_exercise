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

import Transportation.*;

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
	
	public SpyGliderCreationFrame()
	{
		super("Spy Glider Creation");
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		

		this.add(new JLabel("Vehicle Image:"));
		
		ImagesContainer images_container = new ImagesContainer(0, 4, 100, 100, true);
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
			public void actionPerformed(ActionEvent e) {
				// TODO: check if inputs are valid, then add vehicle and/or close window
				int option = JOptionPane.showConfirmDialog(
						SpyGliderCreationFrame.this,
					"Are you sure you want to close this window?",
					"Confirm Close",
					JOptionPane.YES_NO_OPTION
				);
				
		        if (option == JOptionPane.YES_OPTION) {
		            dispose(); // close the JFrame
		        }
			}
		});
		this.add(btn_add);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

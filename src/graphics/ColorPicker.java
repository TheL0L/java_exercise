package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * Preset extension class from JPanel that allows picking a color.
 */
public class ColorPicker extends JPanel
{
	JPanel picker_panel;
	JButton picker_button;
	
	/**
	 * Constructor for ColorPicker class.
	 */
	public ColorPicker()
	{
		picker_panel = new JPanel();
		picker_panel.setBackground(Color.GREEN);
		
		picker_button = new JButton("Pick Color");
		picker_button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color color = JColorChooser.showDialog(null, "Pick a color", Color.GREEN);
	            if (color != null) {
	            	picker_panel.setBackground(color);
	            }
			}
		});
		
		picker_panel.add(picker_button);
		this.add(picker_panel);
	}
	
	/**
	 * Method for retrieving picked color.
	 * 
	 * @return java.awt.Color value of picked color.
	 */
	public Color GetColor()
	{
		return picker_panel.getBackground();
	}
}

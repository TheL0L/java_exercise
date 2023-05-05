package graphics;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JComponent;

public class GuiElement extends Panel
{
	private JComponent component;
	
	public GuiElement(String label_string, JComponent component)
	{
		super(new FlowLayout(FlowLayout.CENTER));
		this.component = component;
		
		this.add(new Label(label_string));
		this.add(this.component);
	}
	
	public JComponent GetComponent()
	{
		return this.component;
	}
}

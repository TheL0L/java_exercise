package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GuiElement extends JPanel
{
	private JComponent component;
	
	public GuiElement(String label_string, JComponent component)
	{
		super(new BorderLayout());
		this.component = component;
		
		this.add(new JLabel(label_string), BorderLayout.WEST);
		this.add(this.component, BorderLayout.EAST);
	}
	
	public JComponent GetComponent()
	{
		return this.component;
	}
}

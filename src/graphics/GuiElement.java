package graphics;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Class for holding label and another component next to each other,
 * while being aligned to the left and right accordingly.
 */
public class GuiElement extends JPanel
{
	private JComponent component;
	
	/**
	 * Constructor class for GuiElement.
	 * 
	 * @param label_text  string holding the text for the label, cannot be changed.
	 * @param component   any java.swing component to be held right of the label.
	 */
	public GuiElement(String label_text, JComponent component)
	{
		super(new BorderLayout());
		this.component = component;
		
		this.add(new JLabel(label_text), BorderLayout.WEST);
		this.add(this.component, BorderLayout.EAST);
	}
	
	/**
	 * Method for retrieving the component's reference.
	 * 
	 * @return the component's reference.
	 */
	public JComponent GetComponent()
	{
		return this.component;
	}
}

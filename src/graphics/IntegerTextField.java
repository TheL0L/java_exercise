package graphics;

import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;

/**
 * Preset extension class from JFormattedTextField that allows only for numerical inputs (integers).
 */
public class IntegerTextField extends JFormattedTextField
{
	/**
	 * Constructor for class IntegerTextField.
	 * 
	 * @param width integer value representing the width of the IntegerTextField in terms of characters.
	 */
	public IntegerTextField(int width)
	{
		super(new DecimalFormat("#########"));	
        
        this.setColumns(width);
	}
}

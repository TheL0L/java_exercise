package graphics;

import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;

/**
 * Preset extension class from JFormattedTextField that allows only for numerical inputs (integers and decimals).
 */
public class DecimalTextField extends JFormattedTextField
{
	/**
	 * Constructor for class DecimalTextField.
	 * 
	 * @param width integer value representing the width of the DecimalTextField in terms of characters.
	 */
	public DecimalTextField(int width)
	{
		super(new DecimalFormat("#########.#########"));

        this.setColumns(width);
	}
}

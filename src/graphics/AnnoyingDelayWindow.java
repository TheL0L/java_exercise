package graphics;

import java.awt.*;
import javax.swing.*;

public class AnnoyingDelayWindow extends JDialog
{
	public AnnoyingDelayWindow(Frame parent, String title, String prompt, int interval_ms)
	{
		super(parent, title, true);
		
		this.add( new JLabel(prompt) );
		
        pack();
        setLocationRelativeTo(parent);
        this.setVisible(true);
		
		try
		{
			Thread.sleep(interval_ms);
		}
    	catch (InterruptedException err)
		{
			err.printStackTrace();
		}
		
		dispose();
	}
}

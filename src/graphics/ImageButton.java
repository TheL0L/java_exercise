package graphics;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Class for creating a click-able image.
 */
public class ImageButton extends JPanel
{
	protected Image image;
	
	/**
	 * Constructor class for ImageButton using an image file.
	 * 
	 * @param file_path     string containing the file path to an image file.
	 * @param tooltip_text  string containing the text to be used in the tooltip.
	 * @param width         integer value for the image's width.
	 * @param height        integer value for the image's height.
	 */
	public ImageButton(String file_path, String tooltip_text, int width, int height)
	{
		this.LoadImage(file_path);
        this.SetDimentions(width, height);
		
        if ( !tooltip_text.isEmpty() )
        {
        	this.setToolTipText(tooltip_text);
        }
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event)
            {
            	if (SwingUtilities.isLeftMouseButton(event))
            	{
            		ImageButton.this.onLeftClick();
            	}
            }
        });
    }
	
	/**
	 * Constructor class for ImageButton using an image data.
	 * 
	 * @param image         image containing the image data to be used.
	 * @param tooltip_text  string containing the text to be used in the tooltip.
	 * @param width         integer value for the image's width.
	 * @param height        integer value for the image's height.
	 */
	public ImageButton(Image image, String tooltip_text, int width, int height)
	{
		this.image = image;
        this.SetDimentions(width, height);
		
        if ( !tooltip_text.isEmpty() )
        {
        	this.setToolTipText(tooltip_text);
        }
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event)
            {
            	if (SwingUtilities.isLeftMouseButton(event))
            	{
            		ImageButton.this.onLeftClick();
            	}
            }
        });
    }
	
	/**
	 * Method for setting the image's dimensions.
	 * 
	 * @param width   integer value for the image's width.
	 * @param height  integer value for the image's height.
	 */
	public void SetDimentions(int width, int height)
	{
		this.setPreferredSize(new Dimension(width, height));
	}
	
	/**
	 * Method loading image data from a file.
	 * 
	 * @param width   string containing the file path to an image file.
	 */
	protected void LoadImage(String file_path)
	{
		this.image = new ImageIcon(file_path).getImage();
	}
	
	@Override
    protected void paintComponent(Graphics gfx)
	{
        super.paintComponent(gfx);
        gfx.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
	
	/**
	 * Method that is called on a left mouse click.
	 */
	protected void onLeftClick()
	{
		if (this.getParent() instanceof ImagesContainer)
		{
			((ImagesContainer)this.getParent()).SetSelected(this);
		}
	}
}

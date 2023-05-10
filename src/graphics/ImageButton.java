package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageButton extends JPanel
{
	protected Image image;
	
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
	
	public void SetDimentions(int width, int height)
	{
		this.setPreferredSize(new Dimension(width, height));
	}
	
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
	
	protected void onLeftClick()
	{
		if (this.getParent() instanceof ImagesContainer)
		{
			((ImagesContainer)this.getParent()).SetSelected(this);
		}
	}
}

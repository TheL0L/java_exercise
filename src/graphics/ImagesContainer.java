package graphics;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

public class ImagesContainer extends JPanel
{
	private Vector<ImageButton> images;
	
	private int images_width;
	private int images_height;
	
	public ImagesContainer(int rows, int columns, int images_width, int images_height, boolean has_custom_image)
	{
        this.setLayout(new GridLayout(rows, columns, 15, 15));
        
        this.images_width = images_width;
        this.images_height = images_height;
        
        this.images = new Vector<ImageButton>();
        
        if (has_custom_image)
        {
        	this.add(new ImageButtonCustom(images_width, images_height));
        }
    }
	
	public void AddImage(String file_path, String tooltip_text)
	{
		this.images.add(new ImageButton(file_path, tooltip_text, this.images_width, this.images_height));
		this.add(this.images.lastElement());
	}
	
	public void AddImageButton(ImageButton image_button)
	{
		this.images.add(image_button);
		this.images.lastElement().SetDimentions(images_width, images_height);
		this.add(this.images.lastElement());
	}
}

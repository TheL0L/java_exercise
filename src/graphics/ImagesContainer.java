package graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagesContainer extends JPanel
{
	private Vector<ImageButton> images;
	
	private int images_width;
	private int images_height;
	
	private int selected_id;
	
	public ImagesContainer(int rows, int columns, int images_width, int images_height, boolean has_custom_image)
	{
        this.setLayout(new GridLayout(rows, columns, 15, 15));
        
        this.images_width = images_width;
        this.images_height = images_height;
        
        this.selected_id = -1;
        
        this.images = new Vector<ImageButton>();
        
        if (has_custom_image)
        {
    		this.images.add(new ImageButtonCustom(images_width, images_height));
    		this.add(this.images.lastElement());
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
	
	public int GetSelectedID()
	{
		return this.selected_id;
	}
	
	public void ClearSelection()
	{
		if (this.selected_id != -1)
		{
			this.images.get(this.selected_id).setBorder(null);
		}
		this.selected_id = -1;
	}
	
	public void SetSelected(ImageButton image_reference)
	{
		int id = this.images.indexOf(image_reference);
		
		if (id != -1)
		{
			this.ClearSelection();
			this.selected_id = id;
			this.images.get(id).setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}
	}
}

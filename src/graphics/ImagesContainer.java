package graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Class for holding click-able images in a grid, with the ability for selecting either of them.
 */
public class ImagesContainer extends JPanel
{
	private Vector<ImageButton> images;
	
	private int images_width;
	private int images_height;
	
	private int selected_id;
	
	/**
	 * Constructor class for ImagesContainer.
	 * 
	 * @param rows              integer value for the number of rows (set 0 for dynamic scaling).
	 * @param columns           integer value for the number of columns (set 0 for dynamic scaling).
	 * @param images_width      integer value for the width of all contained images.
	 * @param images_height     integer value for the height of all contained images.
	 * @param has_custom_image  boolean value dictating whether the user should be able to pick a custom image.
	 */
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
	
	/**
	 * Method for adding an image to the container.
	 * 
	 * @param file_path     string containing the file path to an image file.
	 * @param tooltip_text  string containing the text to be used in the tooltip.
	 */
	public void AddImage(String file_path, String tooltip_text)
	{
		this.images.add(new ImageButton(file_path, tooltip_text, this.images_width, this.images_height));
		this.add(this.images.lastElement());
	}
	
	/**
	 * Method for adding an image to the container.
	 * 
	 * @param image         image containing the image data to be used.
	 * @param tooltip_text  string containing the text to be used in the tooltip.
	 */
	public void AddImage(Image image, String tooltip_text)
	{
		this.images.add(new ImageButton(image, tooltip_text, this.images_width, this.images_height));
		this.add(this.images.lastElement());
	}
	
	/**
	 * Method for adding a click-able image to the container.
	 * 
	 * Used for adding pre-configured ImageButton elements with custom onClick methods.
	 * 
	 * @param image_button  the ImageButton element to be added.
	 */
	public void AddImageButton(ImageButton image_button)
	{
		this.images.add(image_button);
		this.images.lastElement().SetDimentions(images_width, images_height);
		this.add(this.images.lastElement());
	}
	
	/**
	 * Method for retrieving the selected image in the container.
	 * 
	 * @return integer value of the image's index in the container.
	 */
	public int GetSelectedID()
	{
		return this.selected_id;
	}
	
	/**
	 * Method for clearing the image selection in the container.
	 */
	public void ClearSelection()
	{
		if (this.selected_id != -1)
		{
			this.images.get(this.selected_id).setBorder(null);
		}
		this.selected_id = -1;
	}
	
	/**
	 * Method for setting the selected image in the container.
	 * 
	 * Draws a red border around the selected image.
	 * 
	 * @param image_reference the newly selected image's reference.
	 */
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

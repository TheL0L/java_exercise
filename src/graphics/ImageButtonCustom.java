package graphics;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class for creating a click-able image that allows the user to upload the image.
 */
public class ImageButtonCustom extends ImageButton
{
	/**
	 * Constructor class for ImageButtonCustom using an image file.
	 * 
	 * @param width   integer value for the image's width.
	 * @param height  integer value for the image's height.
	 */
	public ImageButtonCustom(int width, int height)
	{
		super("src/resources/use_custom_iamge.png", "Load a custom image", width, height);
    }
	
	@Override
	protected void onLeftClick()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose an image file");
		fileChooser.setMultiSelectionEnabled(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "bmp");
		fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);

		int result = fileChooser.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    
		    this.LoadImage(selectedFile.getAbsolutePath());
		    this.paintComponent(this.getGraphics());
		    
		    super.onLeftClick();
		}
	}
}

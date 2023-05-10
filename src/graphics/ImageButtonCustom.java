package graphics;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageButtonCustom extends ImageButton
{
	public ImageButtonCustom(int width, int height)
	{
		super("src/resources/use_custom_iamge.png", "Load a custom image", width, height);
    }
	
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

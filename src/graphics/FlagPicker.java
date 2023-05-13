package graphics;

/**
 * Preset extension class from ImagesContainer that contains all existing flags.
 */
public class FlagPicker extends ImagesContainer
{
	private final String[] flags = {
			"src/resources/flags/germany.png",
			"src/resources/flags/greece.png",
			"src/resources/flags/israel.png",
			"src/resources/flags/italy.png",
			"src/resources/flags/pirate.jpeg",
			"src/resources/flags/somalia.png",
			"src/resources/flags/usa.png"
	};
	private final String[] flags_tooltips = {
			"Germany",
			"Greece",
			"Israel",
			"Italy",
			"Pirate",
			"Somalia",
			"United States of America"
	};
	
	/**
	 * Constructor for FlagPicker class.
	 */
	public FlagPicker(int rows, int columns, int images_width, int images_height)
	{
		super(rows, columns, images_width, images_height, false, true);
		
		for (int i = 0; i < flags.length; ++i)
		{
			this.AddImage(flags[i], flags_tooltips[i]);
		}
	}
	
	/**
	 * Method for retrieving selected flag name.
	 * 
	 * @return string containing selected flag name.
	 */
	public String GetFlagName()
	{
		if (this.GetSelectedID() != -1)
		{
			return this.GetSelectedImageButton().getToolTipText();
		}
		return null;
	}
}

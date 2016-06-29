/*
 * 
 */
package controller_listener;

import java.io.File;

import javax.swing.filechooser.FileFilter;


// TODO: Auto-generated Javadoc
/**
 * The Class MyFileFilter.
 */
public class MyFileFilter extends FileFilter{

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File file) {
		if (file.isDirectory())
			return true;

		String fname = file.getName().toLowerCase();
		return fname.endsWith("xml");
	}

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		return "*.xml";
	}

}

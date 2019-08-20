package ia;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class RedirectOutputStream extends OutputStream{
	private JTextArea area;
	
	public RedirectOutputStream(JTextArea area) {
		this.area = area;
	}
	/*
	 * this method is copy & paste: https://stackoverflow.com/questions/5107629/how-to-redirect-console-content-to-a-textarea-in-java
	 * */ 
	@Override
	public void write(int b) throws IOException {
		// redirects data to the text area
        area.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        area.setCaretPosition(area.getDocument().getLength());
        // keeps the area up to date
        area.update(area.getGraphics());		
	}

}

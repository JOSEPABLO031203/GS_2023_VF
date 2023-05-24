package application;

import java.awt.Font;
import java.io.InputStream;

public class Fuentes {
	private Font font = null;
	public String bb = "/FONTS/CascadiaCode-Regular-VTT.ttf";
	public Font fuente(String fontName, int estilo, float tamanio) {
		try {
			InputStream is = getClass().getResourceAsStream(fontName);
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception e) {
			// TODO: handle exception
			font = new Font("Arial", Font.PLAIN, 18);
		}
		Font tfont = font.deriveFont(estilo, tamanio);
		return tfont;
	}

}

package br.com.empresa.almintegration.helper.imageutils;

import java.awt.Color;
import java.awt.Font;

import br.com.empresa.almintegration.helper.Utils;

public class ImageSpecifications{
	private final Font KEY_FONT = new Font("Console", Font.BOLD, 12);
	private final Color KEY_COLOR = Color.BLACK;
	private final Font CONTENT_FONT = KEY_FONT.deriveFont(Font.PLAIN);
	private final Color STRING_COLOR = Color.RED;
	private final Color NUMBER_COLOR = Color.BLUE;
	private final Color BOOLEAN_COLOR = Color.GREEN;

	private String value;
	private Color color;
	private Font font;
	
	public ImageSpecifications(String value, boolean isKey) {
		setValue(value);
		setColor((isKey) ? KEY_COLOR
				: (value.equalsIgnoreCase(String.valueOf(true))
						|| value.equalsIgnoreCase(String.valueOf(false))) ? BOOLEAN_COLOR
								: (Utils.isNumeric(this.value.toString())) ? NUMBER_COLOR : STRING_COLOR);
		setFont((isKey) ? KEY_FONT : CONTENT_FONT);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
}

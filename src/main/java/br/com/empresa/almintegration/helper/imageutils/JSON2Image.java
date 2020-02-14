package br.com.empresa.almintegration.helper.imageutils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

import br.com.empresa.almintegration.alm.configuration.settingsModel.Settings;
import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.helper.Utils;
import br.com.empresa.almintegration.model.ServiceResponse;

/**
 * @author glauco.ramalho
 * 
 *         O propósito dessa classe é gerar uma imagem à partir de um JSON. O
 *         procedimento adotado é o seguinte: 1-) O usuário cria o objeto; 2-)
 *         JSON parseado; 3-) JSON recursivamente explorado; 4-) Objetos JSON
 *         catalogados; 5-) Arrays JSON catalogadas; 6-) Primitives JSON
 *         catalogadas; 7-) A cada elemento JSON é dada uma formatação de fonte
 *         e cor {@link ImageSpecifications}; 8-) Cada elemento JSON é inserido
 *         em uma linha {@link Line}; 9-) Lista de linhas {@link Line} é gerada;
 *         10-) Lista de linhas é lida; 11-) Imagens são geradas à partir de sua
 *         formatação {@link ImageSpecifications}; 12-) Imagens são salvas à
 *         partir de um local padrão.
 *
 */
public class JSON2Image {
	private static final String DASH = "_";
	private static final String DOT = ".";

	private final ImageSpecifications OPEN_CURLY_BRACKET = new ImageSpecifications("{", true);
	private final ImageSpecifications CLOSE_CURLY_BRACKETS_WITH_COMMA = new ImageSpecifications("},", true);
	private final ImageSpecifications CLOSE_CURLY_BRACKETS = new ImageSpecifications("}", true);

	private final ImageSpecifications CLOSE_BRACKETS_WITH_COMMA = new ImageSpecifications("],", true);
	private final ImageSpecifications CLOSE_BRACKETS = new ImageSpecifications("]", true);

	private final ImageSpecifications COMMA_SEPARATOR = new ImageSpecifications(",", true);

	// Lista principal onde as especificações de cada linha serão armazenadas.
	private ArrayList<Line> imagesList = new ArrayList<Line>();
	private ArrayList<String> imagesPath = new ArrayList<String>();
	private ArrayList<BufferedImage> bufferedImagesList = new ArrayList<BufferedImage>();

	private static final Graphics graphicsContext = createGraphicsContext();
	private static final FontMetrics fontMetrics = createFontMetrics();

	private static int MAXIMUM_CHARACTERS_PER_LINE;
	private static int MAXIMUM_LINE_WIDTH;
	private static int MAXIMUM_IMAGE_HEIGHT;
	private static int MAXIMUM_LINES_PER_IMAGE;

	private static final int XOFFSET = 4;
	private static final int YOFFSET = 10;
	private static int currentXoffset = 0;

	private static final String SEPARATOR = "*";
	private Line SEGMENT_SEPARATOR_LINE;
	private static final String ENDPOINT = "ENDPOINT";
	private static final String REQUEST = "REQUEST";
	private static final String RESPONSE = "RESPONSE";
	private static final String MESSAGE = "MENSAGEM";

	public JSON2Image(ServiceResponse serviceResponse, String stepId, int stepOrder, int width,
			int height) throws Exception {
		MAXIMUM_LINE_WIDTH = width;
		MAXIMUM_IMAGE_HEIGHT = height;
		MAXIMUM_CHARACTERS_PER_LINE = getCharactersPerLine();
		MAXIMUM_LINES_PER_IMAGE = getLinesPerImage();
		SEGMENT_SEPARATOR_LINE = generateSegmentSeparator();
		String request = serviceResponse.getEvidenceContent();
		String response = serviceResponse.getResposeFromRequest();
		String endPoint = serviceResponse.getEndpoint();
		String message = serviceResponse.getMessage();
		String className = serviceResponse.getClazz().getSimpleName();

		translateImageFromJSON(request, response, endPoint, message, stepId, stepOrder, className);
	}

	private void translateImageFromJSON(String request, String response, String endPoint, String message, String stepId, int stepOrder, String className)
			throws Exception {

		if (endPoint != null) {
			imagesList.add(SEGMENT_SEPARATOR_LINE);
			generateSingleLine(ENDPOINT, true);
			generateSingleLine(endPoint, false);
		}

		if (request != null) {
			if (!request.equals("")) {
				imagesList.add(SEGMENT_SEPARATOR_LINE);
				generateSingleLine(REQUEST, true);
				try {
					JsonElement parse = new JsonParser().parse(request);
					if (parse.isJsonPrimitive())
						translateJsonPrimitiveToImage(parse.getAsJsonPrimitive(), false);
					else if (parse.isJsonObject())
						translateJsonObjectToImage(parse.getAsJsonObject(), false);
					else if (parse.isJsonArray())
						translateJsonArrayToImage(parse.getAsJsonArray(), false);
				} catch (JsonSyntaxException e) {
					generateSingleLine(request, false);
				}
			}
		}

		if (response != null) {
			if (!response.equals("")) {
				imagesList.add(SEGMENT_SEPARATOR_LINE);
				generateSingleLine(RESPONSE, true);
				try {
					JsonElement parse = new JsonParser().parse(response);
					if (parse.isJsonPrimitive())
						translateJsonPrimitiveToImage(parse.getAsJsonPrimitive(), false);
					if (parse.isJsonObject())
						translateJsonObjectToImage(parse.getAsJsonObject(), false);
					if (parse.isJsonArray())
						translateJsonArrayToImage(parse.getAsJsonArray(), false);
				} catch (JsonSyntaxException e) {
					generateSingleLine(response, false);
				}
			}
		}

		if (message != null){
			imagesList.add(SEGMENT_SEPARATOR_LINE);
			generateSingleLine(MESSAGE, true);
			generateSingleLine(message, false);
		}

		bufferedImagesList = new ArrayList<BufferedImage>();
		int bufferedImageListSize = imagesList.size();
		if (bufferedImageListSize > MAXIMUM_LINES_PER_IMAGE) {
			float ceil = (float) bufferedImageListSize / (float) MAXIMUM_LINES_PER_IMAGE;
			int totalCycles = (int) Math.ceil(ceil);
			int startList = 0;
			int endList = MAXIMUM_LINES_PER_IMAGE;
			for (int i = 0; i < totalCycles; i++) {
				endList = (endList <= bufferedImageListSize) ? endList : bufferedImageListSize;
				bufferedImagesList.add(joinVerticallyBufferedImages(imagesList.subList(startList, endList)));
				startList = endList;
				endList += MAXIMUM_LINES_PER_IMAGE;
			}
		} else {
			bufferedImagesList.add(joinVerticallyBufferedImages(imagesList));
		}

		Settings settings = new Utils().getSettings();
		String classPath = Utils.getPath(className);
		String filePath = settings.getConfig().getPaths().getEvidencia() + classPath;
		File file = new File(filePath);
		file.mkdirs();
		for (int i = 0; i < bufferedImagesList.size(); i++) {
			BufferedImage jsonToImage = bufferedImagesList.get(i);
			String fileName = stepId + DASH + stepOrder + DASH + i + DOT + ViewConstants.MIME.PNG;
			ImageIO.write(jsonToImage, ViewConstants.MIME.PNG, new File(filePath + fileName));
			imagesPath.add(filePath + fileName);
		}
	}
	
	private void translateJsonObjectToImage(JsonObject jsonObject, boolean addComma) throws Exception {
		int arrayLength = jsonObject.entrySet().size() - 1;
		int index = 0;

		ImageSpecifications objectSpecifications;
		Line objectSpecificationsLine = new Line();
		objectSpecificationsLine.setxOffset(currentXoffset);
		objectSpecificationsLine.getImagesToPrint().add(OPEN_CURLY_BRACKET);
		imagesList.add(objectSpecificationsLine);

		currentXoffset += XOFFSET;
		for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
			JsonElement valueElement = entry.getValue();
			if (valueElement.isJsonPrimitive()) {
				translateJsonKeyPairToImage(entry, (index++ < arrayLength));
			} else if (valueElement.isJsonArray()) {
				String value = entry.getKey() + ": [";
				objectSpecifications = new ImageSpecifications(value, true);
				objectSpecificationsLine = new Line();
				currentXoffset += XOFFSET;
				objectSpecificationsLine.setxOffset(currentXoffset);
				objectSpecificationsLine.getImagesToPrint().add(objectSpecifications);
				imagesList.add(objectSpecificationsLine);

				translateJsonArrayToImage(valueElement.getAsJsonArray(), (index++ < arrayLength));
				currentXoffset -= XOFFSET;
			}else if (valueElement.isJsonObject()){
				String value = entry.getKey() + ":";
				objectSpecifications = new ImageSpecifications(value, true);
				objectSpecificationsLine = new Line();
				objectSpecificationsLine.setxOffset(currentXoffset);
				objectSpecificationsLine.getImagesToPrint().add(objectSpecifications);
				imagesList.add(objectSpecificationsLine);

				currentXoffset += XOFFSET;
				translateJsonObjectToImage(valueElement.getAsJsonObject(), (index++ < arrayLength));
				currentXoffset -= XOFFSET;
			}
		}
		objectSpecificationsLine = new Line();
		objectSpecificationsLine.setxOffset(currentXoffset);
		if (addComma)
			objectSpecificationsLine.getImagesToPrint().add(CLOSE_CURLY_BRACKETS_WITH_COMMA);
		else
			objectSpecificationsLine.getImagesToPrint().add(CLOSE_CURLY_BRACKETS);
		imagesList.add(objectSpecificationsLine);
		currentXoffset -= XOFFSET;
	}
	
	private void translateJsonPrimitiveToImage(JsonPrimitive jsonPrimitive, boolean addComma) {
		ImageSpecifications primitiveSpecifications = new ImageSpecifications(jsonPrimitive.toString(), false);
		Line primitiveLine = new Line();
		primitiveLine.setxOffset(currentXoffset);
		primitiveLine.getImagesToPrint().add(primitiveSpecifications);
		if (addComma) {
			primitiveSpecifications = new ImageSpecifications(",", true);
			primitiveSpecifications.setColor(Color.BLACK);
			primitiveLine.getImagesToPrint().add(primitiveSpecifications);
		}
		imagesList.add(primitiveLine);
		
	}

	private void translateJsonKeyPairToImage(Entry<String, JsonElement> entry, boolean addComma) {
		String field = entry.getKey() + ": ";
		String value = entry.getValue().toString();
		ImageSpecifications primitiveSpecifications = new ImageSpecifications(field, true);
		Line primitiveLine = new Line();
		primitiveLine.setxOffset(currentXoffset);
		primitiveLine.getImagesToPrint().add(primitiveSpecifications);

		if ((currentXoffset + field.length() + value.length()) > MAXIMUM_CHARACTERS_PER_LINE) {
			String[] strings = splitAtCharacterCountForImageTranslation(value, MAXIMUM_CHARACTERS_PER_LINE);
			int length = strings.length;
			int i;
			String splittedValue;
			for (i = 0; i < length - 1; i++) {
				splittedValue = strings[i];
				primitiveSpecifications = new ImageSpecifications(splittedValue, false);
				primitiveLine.getImagesToPrint().add(primitiveSpecifications);
				imagesList.add(primitiveLine);
				primitiveLine = new Line();
				primitiveLine.setxOffset(currentXoffset);
			}
			splittedValue = strings[i];
			primitiveSpecifications = new ImageSpecifications(splittedValue, false);
			primitiveLine.getImagesToPrint().add(primitiveSpecifications);

			if (addComma) {
				primitiveSpecifications = COMMA_SEPARATOR;
				primitiveLine.getImagesToPrint().add(primitiveSpecifications);
			}

			imagesList.add(primitiveLine);
		} else {
			primitiveSpecifications = new ImageSpecifications(value, false);
			primitiveLine.getImagesToPrint().add(primitiveSpecifications);
			if (addComma) {
				primitiveSpecifications = COMMA_SEPARATOR;
				primitiveLine.getImagesToPrint().add(primitiveSpecifications);
			}
			imagesList.add(primitiveLine);
		}
	}

	private void translateJsonArrayToImage(JsonArray jsonArray, boolean addComma) throws Exception {
		int arrayLength = jsonArray.size() - 1;
		int index = 0;
		for (JsonElement jsonElement : jsonArray) {
			if (jsonElement.isJsonObject()) {
				currentXoffset += XOFFSET;
				translateJsonObjectToImage(jsonElement.getAsJsonObject(), (index++ < arrayLength));
				currentXoffset -= XOFFSET;
			}
			if (jsonElement.isJsonPrimitive()) {
				currentXoffset += XOFFSET;
				translateJsonPrimitiveToImage(jsonElement.getAsJsonPrimitive(), (index++ < arrayLength));
				currentXoffset -= XOFFSET;
			}
			if (jsonElement.isJsonArray()) {
				currentXoffset += XOFFSET;
				translateJsonArrayToImage(jsonElement.getAsJsonArray(), (index++ < arrayLength));
				currentXoffset -= XOFFSET;
			}
		}
		Line line = new Line();
		line.setxOffset(currentXoffset);
		if (addComma)
			line.getImagesToPrint().add(CLOSE_BRACKETS_WITH_COMMA);
		else
			line.getImagesToPrint().add(CLOSE_BRACKETS);
		imagesList.add(line);
	}
	
	private int getCharactersPerLine() {
		float ceil = (float) MAXIMUM_LINE_WIDTH / (float) fontMetrics.stringWidth(SEPARATOR);
		int charactersPerLine = (int) Math.ceil(ceil);
		charactersPerLine -= (int) Math.ceil(((float) charactersPerLine / (float) 100)*25);
		return charactersPerLine;
	}

	private int getLinesPerImage() {
		float ceil = (float) MAXIMUM_IMAGE_HEIGHT / (float) fontMetrics.getHeight();
		int linesPerImage = (int) Math.ceil(ceil);
		linesPerImage += (int) Math.ceil((float) linesPerImage / (float) 10);
		return linesPerImage;
	}

	private static FontMetrics createFontMetrics() {
		return graphicsContext.getFontMetrics();
	}

	private static Graphics2D createGraphicsContext() {
		Font font = new Font("Console", Font.BOLD, 12);
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2d = img.createGraphics();
		graphics2d.setFont(font);
		return graphics2d;
	}

	private void generateSingleLine(String value, boolean isBold) {
		ImageSpecifications specifications;
		Line line = new Line();
		for (String splittedValue : value.split("\n")) {
			if (splittedValue.length() > MAXIMUM_CHARACTERS_PER_LINE) {
				for (String split : splitAtCharacterCountForImageTranslation(splittedValue, MAXIMUM_CHARACTERS_PER_LINE)) {
					specifications = new ImageSpecifications(split, isBold);
					line.getImagesToPrint().add(specifications);
					imagesList.add(line);
					line = new Line();
				}
			} else {
				specifications = new ImageSpecifications(splittedValue, isBold);
				line.getImagesToPrint().add(specifications);
				imagesList.add(line);
				line = new Line();
			}
		}
	}
	
	private Line generateSegmentSeparator() {
		StringBuilder separator = new StringBuilder();
		float ceil = (float) MAXIMUM_LINE_WIDTH / (float) getFontMetrics(SEPARATOR);
		int totalCycles = (int) Math.ceil(ceil);
		for (int i = 0; i < totalCycles; i++)
			separator.append(SEPARATOR);

		Line line = new Line();
		line.getImagesToPrint().add(new ImageSpecifications(separator.toString(), true));
		return line;
	}

	private static int getFontMetrics(String content) {
		return fontMetrics.stringWidth(content);
	}

	public BufferedImage joinVerticallyBufferedImages(List<Line> lines) {
		int width = MAXIMUM_LINE_WIDTH;
		int lineMetricsHeight = (int) fontMetrics.getHeight();
		int height = lineMetricsHeight * MAXIMUM_LINES_PER_IMAGE;
		float ceil = (float) height / (float) 100;
		height += ((int) Math.ceil(ceil) * 10);
		BufferedImage joinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = joinedImage.createGraphics();
		Color oldColor = g2.getColor();
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, width, height);
		g2.setColor(oldColor);
		int y = YOFFSET;
		for (Line line : lines) {
			int x = line.getxOffset();

			for (ImageSpecifications imageSpecifications : line.getImagesToPrint()) {
				Font font = imageSpecifications.getFont();
				Color color = imageSpecifications.getColor();
				String value = imageSpecifications.getValue();
				g2.setFont(font);
				g2.setColor(color);
				g2.drawString(value, x, y);
				FontMetrics fontMetrics = g2.getFontMetrics();
				x += fontMetrics.stringWidth(value);
			}
			y += fontMetrics.getHeight();
		}

		g2.dispose();
		return joinedImage;
	}

	private static String[] splitAtCharacterCountForImageTranslation(String content, int characterCount) {
		content = content.replaceAll("(.{" + characterCount + "})", "$1|");
		String[] split = content.split("\\|");
		return split;
	}

	public ArrayList<String> getImagesPath() {
		return imagesPath;
	}

	public static int getMAXIMUM_LINES_PER_IMAGE() {
		return MAXIMUM_LINES_PER_IMAGE;
	}
}

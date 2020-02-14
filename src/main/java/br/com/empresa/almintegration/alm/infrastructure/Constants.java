package br.com.empresa.almintegration.alm.infrastructure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import br.com.empresa.almintegration.execution.PlayTestCases;

/**
 *
 * These constants are used throughout the code to set the
 * server to work with.
 * To execute this code, change these settings to fit
 * those of your server.
 */
public class Constants extends PlayTestCases {

	public String HOST;
	public String PORT;

	public String USERNAME;
	public String PASSWORD;

	public String DOMAIN;
	public String PROJECT;

	public Constants() throws FileNotFoundException, IOException, URISyntaxException {
		HOST = settings.getConfig().getALM().getProject().getHost();
		PORT = settings.getConfig().getALM().getProject().getPort();
		USERNAME = settings.getConfig().getALM().getProject().getUser();
		PASSWORD = settings.getConfig().getALM().getProject().getPass();
		DOMAIN = settings.getConfig().getALM().getProject().getDomain();
		PROJECT = settings.getConfig().getALM().getProject().getProject();
	}



	/**
	 * Supports running tests correctly on both versioned
	 * and non-versioned projects.
	 * @return true if entities of entityType support versioning
	 */
	public static boolean isVersioned(String entityType,
			final String domain, final String project)
					throws Exception {

		RestConnector con = RestConnector.getInstance();
		String descriptorUrl =
				con.buildUrl("rest/domains/"
						+ domain
						+ "/projects/"
						+ project
						+ "/customization/entities/"
						+ entityType);

		String descriptorXml =
				con.httpGet(descriptorUrl, null, null, false).toString();
		EntityDescriptor descriptor =
				EntityMarshallingUtils.marshal
				(EntityDescriptor.class, descriptorXml);

		boolean isVersioned = descriptor.getSupportsVC().getValue();

		return isVersioned;
	}

	public static String generateFieldXml(String field, String value) {

		return "<Field Name=\"" + field +
				"\"><Value>\n" + value +
				"\n</Value></Field>";

	}

	/**
	 * This string used to create new "requirement" type entities.
	 */
	public static final String entityToPostName = "req"
			+ Double.toHexString(Math.random());
	public static final String entityToPostFieldName =
			"type-id";
	public static final String entityToPostFieldValue = "1";
	public static final String entityToPostFormat =
			"<Entity Type=\"requirement\">"
					+ "<Fields>"
					+ Constants.generateFieldXml("%s", "%s")
					+ Constants.generateFieldXml("%s", "%s")
					+ "</Fields>"
					+ "</Entity>";

	public static final String entityToPostXml =
			String.format(
					entityToPostFormat,
					"name",
					entityToPostName,
					entityToPostFieldName,
					entityToPostFieldValue);

	public static final CharSequence entityToPostFieldXml =
			generateFieldXml(Constants.entityToPostFieldName,
					Constants.entityToPostFieldValue);

}
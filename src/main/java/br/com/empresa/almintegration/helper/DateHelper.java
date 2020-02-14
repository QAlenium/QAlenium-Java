package br.com.empresa.almintegration.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Fabrica<BR>
 *
 * AUT-126 - Relatorio de execucao em Excel<BR>
 *
 * @since 7 de jul de 2016 11:21:27
 * @author Gabriel Aguido Fraga<BR>
 *         Fabrica<BR>
 * 
 *         automation
 */
public class DateHelper {
		
	private static Logger LOGGER = LoggerFactory.getLogger(DateHelper.class.getName());
	
	/**
	 * Fabrica<BR>
	 *
	 * @since 22 de set de 2015 08:56:31
	 * @author Gabriel Aguido Fraga<BR>
	 */
	public static String getDataAtualFormatada(String pattern) {

    	LOGGER.debug("Entrou no metodo getDataFormatada");
		
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		dateFormat.setTimeZone(cal.getTimeZone());

		String data = dateFormat.format(cal.getTime());

		//LOGGER.debug(data);

		return data;
	}
}
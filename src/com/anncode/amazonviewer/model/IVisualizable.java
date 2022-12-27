package com.anncode.amazonviewer.model;

import java.util.Date;

/**
 * Este método captura el tiempo exacto de inicio de visualización
 *
 * @param {@code dateI} Es un objeto {@code Date} con el tiempo de inicio exacto.
 * @return Devuelve la fecha y hora capturada
 *
 */
public interface IVisualizable {
	Date startToSee(Date dateI);

	/**
	 * Este metodo captura el tiempo exacto de inicio y final de la visualización
 	 * @param dateI {@code dateI} Es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param dateF {@code dateI} Es un objeto {@code Date} con el tiempo de final exacto.
	 */
	void stopToSee(Date dateI, Date dateF);

}

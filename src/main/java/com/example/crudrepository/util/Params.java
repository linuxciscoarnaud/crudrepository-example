/**
 * 
 */
package com.example.crudrepository.util;

/**
 * @author Arnaud
 *
 */

public class Params {

	private final String IDSOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private int idsLength = 10;
	
	public int getIdsLength() {
		return idsLength;
	}
	public void setIdsLength(int idsLength) {
		this.idsLength = idsLength;
	}
	public String getIDSOURCE() {
		return IDSOURCE;
	}		
}

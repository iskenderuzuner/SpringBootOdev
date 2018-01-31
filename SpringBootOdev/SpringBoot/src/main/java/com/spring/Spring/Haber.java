package com.spring.Spring;

/**	
 * Haber Sinifi
 * Iskender Uzuner
 */

public class Haber {
	
	private static int COUNT = 0;
	private int id;
	private String haberBaslik;
	private String haberIcerik;
	
	/**
	 * 
	 * @param haberBaslik bu siniftan alinir.
	 * @param haberIcerik bu siniftan alinir.
	 */
	
	public Haber(String haberBaslik,String haberIcerik)
	{
		this.id = ++COUNT;
		this.haberBaslik=haberBaslik;
		this.haberIcerik=haberIcerik;
	}
	
	/**
	 * Varolan Haber Title return eder.
	 * @return Haber Title Dondurur
	 */
	
	public String getHaberBaslik() {
		return haberBaslik;
	}
	
	/**
	 * Varolan Haber Icerigini dondurur.
	 * @return Haberin Icerigi
	 */
	
	public String getHaberIcerik() {
		return haberIcerik;
	}
	
	/**
	 * Varolan id'yi dondurur.
	 * @return Haberin id degiskeni.
	 */
	
	public int getId() {
		return id;
	}
	
}

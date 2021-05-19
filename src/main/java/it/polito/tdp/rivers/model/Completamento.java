package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Completamento {
	
	private LocalDate dataPiccola;
	private LocalDate dataGrande;
	
	private float mediaFlusso;
	private int misurazioni;
	
	private int codiceFiume;

	public Completamento(LocalDate dataPiccola, LocalDate dataGrande, float mediaFlusso, int misurazioni,
			int codiceFiume) {
	
		this.dataPiccola = dataPiccola;
		this.dataGrande = dataGrande;
		this.mediaFlusso = mediaFlusso;
		this.misurazioni = misurazioni;
		this.codiceFiume = codiceFiume;
	}

	public LocalDate getDataPiccola() {
		return dataPiccola;
	}

	public void setDataPiccola(LocalDate dataPiccola) {
		this.dataPiccola = dataPiccola;
	}

	public LocalDate getDataGrande() {
		return dataGrande;
	}

	public void setDataGrande(LocalDate dataGrande) {
		this.dataGrande = dataGrande;
	}

	public float getMediaFlusso() {
		return mediaFlusso;
	}

	public void setMediaFlusso(float mediaFlusso) {
		this.mediaFlusso = mediaFlusso;
	}

	public int getMisurazioni() {
		return misurazioni;
	}

	public void setMisurazioni(int misurazioni) {
		this.misurazioni = misurazioni;
	}

	public int getCodiceFiume() {
		return codiceFiume;
	}

	public void setCodiceFiume(int codiceFiume) {
		this.codiceFiume = codiceFiume;
	}
	
	
	
	

}

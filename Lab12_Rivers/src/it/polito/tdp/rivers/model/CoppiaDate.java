package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class CoppiaDate {
	private LocalDate Prima;
	private LocalDate Seconda;
	private int nMisurazioni;
	private float fMed;
	private River r;
	
	
	
	public CoppiaDate(LocalDate prima, LocalDate seconda, River r, int nMisurazioni, float media) {
		super();
		Prima = prima;
		Seconda = seconda;
		this.nMisurazioni=nMisurazioni;
		this.r = r;
		this.fMed=media;
	}
	public LocalDate getPrima() {
		return Prima;
	}
	public void setPrima(LocalDate prima) {
		Prima = prima;
	}
	public LocalDate getSeconda() {
		return Seconda;
	}
	public void setSeconda(LocalDate seconda) {
		Seconda = seconda;
	}
	public River getR() {
		return r;
	}
	public void setR(River r) {
		this.r = r;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Prima == null) ? 0 : Prima.hashCode());
		result = prime * result + ((Seconda == null) ? 0 : Seconda.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoppiaDate other = (CoppiaDate) obj;
		if (Prima == null) {
			if (other.Prima != null)
				return false;
		} else if (!Prima.equals(other.Prima))
			return false;
		if (Seconda == null) {
			if (other.Seconda != null)
				return false;
		} else if (!Seconda.equals(other.Seconda))
			return false;
		if (r == null) {
			if (other.r != null)
				return false;
		} else if (!r.equals(other.r))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CoppiaDate [Prima=" + Prima + ", Seconda=" + Seconda + ", r=" + r + "]"+this.fMed;
	}
	public String getnMisurazioni() {
		return ""+nMisurazioni;
	}
	public void setnMisurazioni(int nMisurazioni) {
		this.nMisurazioni = nMisurazioni;
	}
	public String getfMed() {
		return ""+fMed;
	}
	
	public float getfMedInt() {
		return fMed;
	}
	
	public void setfMed(int fMed) {
		this.fMed = fMed;
	}
	
	



}

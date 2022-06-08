package com.webService.service;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.type.DateType;

@Entity
public class hodowla {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String numer_ID;
	private Date data_paszportu;
	private int kolczyk_ID;
	private Date data_urodzenia;
	private String plec;
	private String rasa;
	private String numer_ID_matki;
	private int kolczyk_ID_matki;
	
	public String getNumer_ID() {
		return numer_ID;
	}
	public void setNumer_ID(String numer_ID) {
		this.numer_ID = numer_ID;
	}
	public Date getData_paszportu() {
		return data_paszportu;
	}
	public void setData_paszportu(Date data_paszportu) {
		this.data_paszportu = data_paszportu;
	}
	public int getKolczyk_ID() {
		return kolczyk_ID;
	}
	public void setKolczyk_ID(int kolczyk_ID) {
		this.kolczyk_ID = kolczyk_ID;
	}
	public Date getData_urodzenia() {
		return data_urodzenia;
	}
	public void setData_urodzenia(Date data_urodzenia) {
		this.data_urodzenia = data_urodzenia;
	}
	public String getPlec() {
		return plec;
	}
	public void setPlec(String plec) {
		this.plec = plec;
	}
	public String getRasa() {
		return rasa;
	}
	public void setRasa(String rasa) {
		this.rasa = rasa;
	}
	public String getNumer_ID_matki() {
		return numer_ID_matki;
	}
	public void setNumer_ID_matki(String numer_ID_matki) {
		this.numer_ID_matki = numer_ID_matki;
	}
	public int getKolczyk_ID_matki() {
		return kolczyk_ID_matki;
	}
	public void setKolczyk_ID_matki(int kolczyk_ID_matki) {
		this.kolczyk_ID_matki = kolczyk_ID_matki;
	}
	public String toString() {
		return	"<td>"+this.numer_ID+"</td>"
				+ "</td><td>"+this.data_paszportu+""
				+ "</td><td>"+this.kolczyk_ID+""
				+ "</td><td>"+this.data_urodzenia+""
				+ "</td><td>"+this.plec+""
				+ "</td><td>"+this.rasa+""
				+ "</td><td>"+this.numer_ID_matki+""
				+"<td>"+this.kolczyk_ID_matki+"</td>"
				+"<td><button onclick=\"document.location.replace('./usunKrowe/"+this.numer_ID+"')\">Usuń</button></td>";
	}
}

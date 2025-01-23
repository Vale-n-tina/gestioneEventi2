package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Evento")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "data_evento")
	private LocalDate dataEvento;
	@Column(name = "tipo_evento")
	private String tipoEvento;
	@Column(name = "numero_massimo_partecipanti")
	private int massimoPartecipanti;
	@Column(name = "descrizione")
	private String descrizione;

	@ManyToOne
  @JoinColumn(name = "locationn")
  private Location location;

	public Evento() {

	}

	public Evento(Location location, String descrizione, int massimoPartecipanti, String tipoEvento, LocalDate dataEvento, String titolo) {
		this.location = location;
		this.descrizione = descrizione;
		this.massimoPartecipanti = massimoPartecipanti;
		this.tipoEvento = tipoEvento;
		this.dataEvento = dataEvento;
		this.titolo = titolo;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public int getMassimoPartecipanti() {
		return massimoPartecipanti;
	}

	public void setMassimoPartecipanti(int massimoPartecipanti) {
		this.massimoPartecipanti = massimoPartecipanti;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Evento{" +
				  "id=" + id +
				  ", titolo='" + titolo + '\'' +
				  ", dataEvento=" + dataEvento +
				  ", tipoEvento='" + tipoEvento + '\'' +
				  ", massimoPartecipanti=" + massimoPartecipanti +
				  ", descrizione='" + descrizione + '\'' +
				  ", location=" + location +
				  '}';
	}
}

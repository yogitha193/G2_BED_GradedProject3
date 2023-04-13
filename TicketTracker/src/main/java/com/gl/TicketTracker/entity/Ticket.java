package com.gl.TicketTracker.entity;

import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ticketTitle")
	private String ticketTitle;

	// @Lob
	@Column(name = "ticketShortDescription")
	private String ticketShortDescription;

	@Column(name = "ticketContent")
	private String ticketContent;

	// @Temporal(TemporalType.DATE)
	@Column(name = "ticketCreatedOn", updatable = false)
	private String ticketCreatedOn;

	public Ticket() {
		// Date date = new Date();
		String pattern = "dd MM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		this.ticketCreatedOn = date;
	}

	public Ticket(int id, String ticketTitle, String ticketShortDescription, String ticketCreatedOn,
			String ticketContent) {
		super();
		this.id = id;
		this.ticketTitle = ticketTitle;
		this.ticketShortDescription = ticketShortDescription;

		this.ticketContent = ticketContent;
	}

	public String getTicketContent() {
		return ticketContent;
	}

	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

	public String getTicketCreatedOn() {
		return ticketCreatedOn;
	}

	// public void setTicketCreatedOn(Date ticketCreatedOn) {
	// Date date = new Date();
	// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	// String str = formatter.format(date);
	// this.ticketCreatedOn = ticketCreatedOn ;
	// }

}

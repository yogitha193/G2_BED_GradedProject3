package com.gl.TicketTracker.service;

import java.util.List;

import com.gl.TicketTracker.entity.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public void save(Ticket theTicket);

	public void deleteById(int id);

	public Ticket findById(int id);

	List<Ticket> getByKeyword(String keyword);

}

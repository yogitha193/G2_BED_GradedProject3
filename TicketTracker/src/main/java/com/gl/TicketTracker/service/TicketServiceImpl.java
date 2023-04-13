package com.gl.TicketTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.TicketTracker.entity.Ticket;
import com.gl.TicketTracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> getByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);

	}

	@Override
	public void save(Ticket theTicket) {
		// TODO Auto-generated method stub
		ticketRepository.save(theTicket);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket findById(int id) {
		// TODO Auto-generated method stub

		Ticket ticket = ticketRepository.findById(id).get();
		// System.out.println("service delete"+ticket);
		if (ticket == null)
			throw new RuntimeException("Did not find the ticket id: " + id);
		else
			return ticket;
	}

}

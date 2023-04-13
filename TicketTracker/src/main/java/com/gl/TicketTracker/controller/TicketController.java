package com.gl.TicketTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTracker.entity.Ticket;
import com.gl.TicketTracker.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Ticket theTicket = new Ticket();
		theModel.addAttribute("ticket", theTicket);
		return "tickets/ticket-form";

	}

	@GetMapping("/list")
	public String listTickets(Model theModel, String keyword) {
		/*
		 * //List<Ticket> theTickets = ticketService.findAll();
		 * //theModel.addAttribute("tickets", theTickets); //return
		 * "tickets/list-tickets";
		 */

		if (keyword != null) {
			List<Ticket> theTickets = ticketService.getByKeyword(keyword);
			theModel.addAttribute("tickets", theTickets);
		} else {
			List<Ticket> theTickets = ticketService.findAll();
			theModel.addAttribute("tickets", theTickets);
		}
		return "tickets/list-tickets";

	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket theTicket) {

		ticketService.save(theTicket);
		return "redirect:/tickets/list";

	}

	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("ticketId") int id) {

		ticketService.deleteById(id);
		// System.out.println("ENtered into controller delete");

		return "redirect:/tickets/list";

	}

	@PostMapping("/showFormForUpdate")
	public String showForForUpdate(@RequestParam("ticketId") int id, Model theModel) {
		Ticket ticket = ticketService.findById(id);
		theModel.addAttribute("ticket", ticket);
		return "tickets/update-ticket";
	}

	@PostMapping("/view")
	public String viewTicket(@RequestParam("ticketId") int id, Model theModel) {
		Ticket viewTicket = ticketService.findById(id);
		// System.out.println(viewticket);
		theModel.addAttribute("viewticket", viewTicket);
		return "tickets/view-ticket";
	}
}

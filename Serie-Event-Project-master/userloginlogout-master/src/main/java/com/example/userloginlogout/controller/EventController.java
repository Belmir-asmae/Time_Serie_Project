package com.example.userloginlogout.controller;

import com.example.userloginlogout.models.Tag;
import com.example.userloginlogout.models.Event;
import com.example.userloginlogout.service.EventService;
import com.example.userloginlogout.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.userloginlogout.service.TagService;

import java.util.List;

@Controller
@RequestMapping("userspace/user/{id}/series")
public class EventController {
    @Autowired
    private SerieService sservice;

    @Autowired
    private EventService eservice;
    
    @Autowired 
    private TagService tgservice;

    @GetMapping("/")
    public String listofserie()
    {
        return "list_series";
    }

    @GetMapping("/{sid}")
    public String showEventsOfSpecificSerie(@PathVariable("sid") Integer id, Model model)
    {
        List<Event> listeEvent = eservice.findAllByIdEvent(id);
        model.addAttribute("list_specified_events",listeEvent);
        return "list_events";
    }

    @GetMapping("/{sid}/event/new")
    public String addNewEventToASerie(@PathVariable("sid") Integer id,Model model)
    {
    	List<Tag> listTags= tgservice.ShowTags();
    	model.addAttribute("ListTags",listTags);
    	model.addAttribute("tag",new Tag());
        model.addAttribute("event",new Event());
        return "add_Event";
    }

    @PostMapping("/{sid}/event/new/save")
    public String SaveNewEvent(@PathVariable("sid") Integer id, Event event)
    {
    	Tag tag1 = new Tag();
    	tag1.setName(event.getTag_string());
    	tgservice.SaveTag(tag1);
        event.setSerie(sservice.getSerieById(id));
        event.setTag(tag1);       
        eservice.saveEvent(event);
        return "redirect:/userspace/user/{id}/series/{sid}";
    }

    @GetMapping("/{sid}/event/edit/{eid}")
    public String EditEvent(@PathVariable("sid") Integer id, @PathVariable("eid") Integer eid,Model model)
    {
        model.addAttribute("event",eservice.getEventById(eid));
        List<Tag> listTags= tgservice.ShowTags();
     	model.addAttribute("ListTags",listTags);
        return "edit_event";
    }
    @PostMapping("/{sid}/event/edit/{eid}/save")
    public String SaveEditEvent(@PathVariable("sid") Integer id, @PathVariable("eid") Integer eid,Event event)
    {
    	Tag tag1 = new Tag();
    	tag1.setName(event.getTag_string());
    	tgservice.SaveTag(tag1);
        event.setSerie(sservice.getSerieById(id));
        event.setTag(tag1);
        event.setTag_string(tag1.getName());
        eservice.saveEvent(event);
        return "redirect:/userspace/user/{id}/series/{sid}";
    }

    @GetMapping("/{sid}/event/delete/{eid}")
    public String DeleteEvent(@PathVariable("sid") Integer id, @PathVariable("eid") Integer eid)
    {
        eservice.deleteEvent(eid);
        return "redirect:/userspace/user/{id}/series/{sid}";
    }


}

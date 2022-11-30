package com.example.userloginlogout.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.userloginlogout.service.EventService;
import com.example.userloginlogout.service.TagService;

@Controller
public class TagController {
	
	@Autowired
	private TagService tagService;
	@Autowired
	private EventService serieEvent;
	@Autowired 
	private EventService eventService;
	
	

}

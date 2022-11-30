package com.example.userloginlogout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userloginlogout.models.Tag;
import com.example.userloginlogout.repository.TagRepository;

import java.util.List;

@Service
public class TagService {
	
 @Autowired
  private TagRepository tagRepos ;
 
    public Tag SaveTag(Tag tag)
    {
		return tagRepos.save(tag);	
    }
    
    public List<Tag> ShowTags()
    {
    	return tagRepos.findAll();
    }
    
    public Tag getTagById(int id)
    { 
    	return tagRepos.findById(id).orElseGet(null);
    }
    
    public void DeleteTag(int id)
    {
    	tagRepos.deleteById(id);
 }

    public Tag findByTagName(String name)
    {
        return tagRepos.findByName(name);
    }
   

}

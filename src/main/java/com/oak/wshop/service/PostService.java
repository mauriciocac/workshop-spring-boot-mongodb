package com.oak.wshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oak.wshop.model.Post;
import com.oak.wshop.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	public Optional<Post> findPost(String id) {
		return postRepository.findById(id);
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}

}

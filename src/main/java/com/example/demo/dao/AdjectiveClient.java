package com.example.demo.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Word;

@FeignClient("LAB-8-WORD-ADJECTIVE")
public interface AdjectiveClient {
	
	@GetMapping("/")
	public Word getWord();
}

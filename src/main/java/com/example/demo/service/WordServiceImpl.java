package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdjectiveClient;
import com.example.demo.dao.ArticleClient;
import com.example.demo.dao.NounClient;
import com.example.demo.dao.SubjectClient;
import com.example.demo.dao.VerbClient;
import com.example.demo.domain.Word;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WordServiceImpl implements WordService {

	@Autowired VerbClient verbClient;
	@Autowired SubjectClient subjectClient;
	@Autowired ArticleClient articleClient;
	@Autowired AdjectiveClient adjectiveClient;
	@Autowired NounClient nounClient;
	
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Word getSubject() {
		return subjectClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackVerb")
	public Word getVerb() {
		return verbClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackArticle")
	public Word getArticle() {
		return articleClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackAdjective")
	public Word getAdjective() {
		return adjectiveClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackNoun")
	public Word getNoun() {
		return nounClient.getWord();
	}
	
	public Word getFallbackSubject() {
		return new Word("Someone");
	}
	
	public Word getFallbackArticle() {
		return new Word("a");
	}
	
	public Word getFallbackVerb() {
		return new Word("painted");
	}
	
	public Word getFallbackAdjective() {
		return new Word("beautiful");
	}
	
	public Word getFallbackNoun() {
		return new Word("scenery");
	}
}

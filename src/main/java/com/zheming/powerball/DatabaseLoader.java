package com.zheming.powerball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
	
	private final BallRepository repository;
	
	@Autowired
	public DatabaseLoader(BallRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public void run(String...strings) throws Exception{
		this.repository.save(new PowerBall("1"));
	}
}

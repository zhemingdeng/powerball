package com.zheming.powerball;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import lombok.Data;

@Data
@Entity
public class PowerBall extends Ball {
	
	//private @Id @GeneratedValue Long id;
	
	private PowerBall() {}
	
	public PowerBall(String number) {
		this.number=number;
		frequency=0;
	}
}

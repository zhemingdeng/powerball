package com.zheming.powerball;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import lombok.Data;

@Data
@Entity
public abstract class Ball {
	int frequency;
	String number;
	private @Id @GeneratedValue Long id;
}

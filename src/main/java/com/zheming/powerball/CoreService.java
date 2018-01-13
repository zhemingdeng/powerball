package com.zheming.powerball;

import java.util.Arrays;
import java.util.Comparator;

public class CoreService {
	
	public CoreService() {
		
	}
	
	public void sort(Ball[] balls) {
		Arrays.sort(balls, new Comparator<Ball>() {
			public int compare(Ball b1, Ball b2) {
				return b2.frequency-b1.frequency;
			}
		});
	}
	
	public void print(Ball[] balls) {
		System.out.println("Number  Frequency");
		for(Ball b : balls) {
			if(b.frequency==0) continue;
			System.out.println(b.number+": "+b.frequency);
		}
	}
	
}

package com.zheming.powerball;

import java.io.File;

public class Controller {
	InputService inputService;
	CoreService coreService;
	File file;
	
	public Controller(){
		this.inputService=new InputService();
		this.coreService=new CoreService();
		file=new File("powerball");
	}
	
	public void run(String url) {
		inputService.FileDownloadService(url, file);
		inputService.FileReadService("powerball");
		coreService.sort(inputService.pbs);
		coreService.sort(inputService.wbs);
		
		System.out.println("White ball");
		coreService.print(inputService.wbs);
		
		System.out.println("Power ball");
		coreService.print(inputService.pbs);
	}
	
	public static void main( String[] args )
    {
        Controller controller=new Controller();
        String url;
        if(true) {
        	url="http://www.powerball.com/powerball/winnums-text.txt";
        }else {
        	url=args[0];
        }
        controller.run(url);
    }
}

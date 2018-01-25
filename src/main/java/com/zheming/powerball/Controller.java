package com.zheming.powerball;

import java.io.File;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {
	InputService inputService;
	CoreService coreService;
	File file;
	
	
	public Controller(){
		this.inputService=new InputService();
		this.coreService=new CoreService();
		file=new File("powerball");
	}
	
	@RequestMapping("/powerball")
	public String run(String url) {
		if(url==null) url="http://www.powerball.com/powerball/winnums-text.txt";
		inputService.FileDownloadService(url, file);
		//inputService.FileReadService("powerball");
		//coreService.sort(inputService.pbs);
		//coreService.sort(inputService.wbs);
		
		//System.out.println("White ball");
		//coreService.print(inputService.wbs);
		
		//System.out.println("Power ball");
		//coreService.print(inputService.pbs);
		StringBuilder sb=new StringBuilder();
		sb.append("<html>White Ball: <br />Power Ball: </html>");
		//sb.append("Power Ball: %n");
		return sb.toString();
	}
	
	/*public static void main( String[] args )
    {
        Controller controller=new Controller();
        String url;
        if(true) {
        	url="http://www.powerball.com/powerball/winnums-text.txt";
        }else {
        	url=args[0];
        }
        controller.run(url);
    }*/
}

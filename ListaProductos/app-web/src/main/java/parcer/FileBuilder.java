package parcer;

import enums.ClaveEnum;

public class FileBuilder {
	
	public static FileBase getParseable(ClaveEnum claveEnum) {
		
		FileBase fb = null;
		
		switch (claveEnum.name()) {
			case "CSV":
				fb = new FileCSV(null); 
			
		}
		
		return fb;
	}
}

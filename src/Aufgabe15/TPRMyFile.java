package Aufgabe15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TPRMyFile {

	BufferedReader fileIn = null;
	PrintWriter fileOut = null;

	public boolean newFile(String path, String name) {
		File file = new File(path, name);
		try {
			return file.createNewFile();
		} catch(IOException e) {
			return false;
		}
	}

	public String readLine(String filePath, String fileName, int lineNr) {
		File file = new File(filePath, fileName);
        try {
            fileIn = new BufferedReader(new FileReader(file));
            for (int i = 1; i < lineNr; i++) {
                fileIn.readLine();
            }
            return fileIn.readLine();
        } catch (FileNotFoundException e) {
            return "File not found.";
        } catch (IOException e) {
            return "Line not found.";
        } finally {
        	try {
        		if(fileIn != null) {
        			fileIn.close();
        		}
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
	}

	public void writeLine(String filePath, String fileName, int lineNr, String data) {
		File file = new File(filePath, fileName);
		TPRMyFile myFile = new TPRMyFile();
		List<String> fileContent;
        try {
            fileContent = new ArrayList<>();
			String reading = "";
			for(int i = 1; reading != null && !reading.equals("File not found.") && !reading.equals("Line not found."); i++) {
				reading = myFile.readLine(filePath, fileName, i);
				if(i==lineNr){
					fileContent.add(data);
				}else if(reading != null && !reading.equals("File not found.") && !reading.equals("Line not found.")){
					fileContent.add(reading);
				}
			}

            if(reading != null && reading.equals("File not found.")) {
            	if(!this.newFile(filePath, fileName)) {
					System.out.println("Could not create file");
					return;
				}
            }

			if(lineNr > fileContent.size()){
				for(int i = fileContent.size(); i < (lineNr-1); i++){
					fileContent.add("");
				}
				fileContent.add(data);
			}

            fileOut = new PrintWriter(new FileWriter(file));
			Thread.sleep(5000);
            for (String string : fileContent) {
				fileOut.println(string);
			}
            fileOut.flush();
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	if(fileOut != null) {
        		fileOut.close();
        	}
        }
	}
}

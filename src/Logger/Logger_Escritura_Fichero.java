package Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger_Escritura_Fichero {
	
	private BufferedWriter buffered;
	private String ruta;
	
	
	public Logger_Escritura_Fichero(String ruta) throws IOException {
		this.ruta = ruta;
		this.open(true);
		
	}
	
	public Logger_Escritura_Fichero(String ruta, boolean reset) throws IOException {
		this.ruta = ruta;
		this.open(!reset);
		
	}
	 private void open(boolean append) throws IOException {
		 this.buffered = new BufferedWriter(new FileWriter(this.ruta, append));
		 
	 }
	 
	 public void addLine(String line) throws IOException{
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		 String formatoFecha = sdf.format(new Date());
		 this.open(true);
		 this.buffered.write("["+ formatoFecha+ "]" + line + "\n");
		 this.close();	 
	 }
	 
	 public String[] getLines() throws FileNotFoundException	{
		 ArrayList<String> linesFile = new ArrayList<>();
		 
		 BufferedReader br = new BufferedReader(new FileReader(this.ruta));
		 
		 String line;
		 try {
			while (( line = br.readLine()) != null) {
				 linesFile.add(line);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 String[] lines = new String[linesFile.size()];
		 
		 for (int i = 0; i<  linesFile.size(); i ++) {
			 lines[i] = linesFile.get(i);
		 }
		 return lines;
		 	 
		 }
	 public void resetLog() {
		 try {
			this.open(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.close();
	 }
	 public void close() {
		 try {
			this.buffered.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }

}

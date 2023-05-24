package application;
	

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVfile {
	
	StringBuilder sb;
	String archivo;
	PrintWriter pw;
	
	
	String datos = "TEAM_ID,MISSION_TIME,PACKET_COUNT,MODE,STATE,ALTITUDE,HS_DEPLOYED,PC_DEPLOYED,MAST_RAISED,TEMPERATURE,VOLTAGE,PRESSURE,GPS_TIME,GPS_ALTITUDE,GPS_LATITUDE,GPS_LONGITUDE,GPS_SATS,TILT_X,TILT_Y,CMD_ECHO,CAMERA_MODE,ACCELERATION,COMPASS,GPS LOCATION,";
	
	String[] Line = {"","","","","","","","","","","","","","","","","","","","","","","",""};
	
	public CSVfile() throws FileNotFoundException {
		
		archivo = "Flight_1040.csv";
		pw = new PrintWriter(new File(archivo));
		sb = new StringBuilder();
		sb.append(datos);
		
		
	}
	
	public void save(String line) throws FileNotFoundException
	{
		sb.append('\n');
		sb.append(line);
		sb.append(',');
		

	}

	public void close()
	{
			pw.write(sb.toString());
			pw.close();
	}
	
}

package application;

import javafx.concurrent.Task;
import javafx.scene.text.Text;

public class clockGS extends Thread{
	Text cronus;
	int w,y,z;
	public clockGS(Text lb) {
		this.cronus = lb;
	}
	@Override
	public void run() {
			
		try {
			int x = 0;
			while(SF_mode.startThread) {
				Thread.sleep(1000);
				
				xtnCronus(x);
				x++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private void xtnCronus(int x) {
		System.out.println(x +  Thread.currentThread().getName());
		try {
			SF_mode.seg++;
			if(SF_mode.seg>59) {
				SF_mode.seg = 0;
				SF_mode.min++;
				if(SF_mode.min>59) {
					SF_mode.min = 0;
					SF_mode.hr++;
					if(SF_mode.hr>1) {
						SF_mode.hr = 0;
					}
				}
			}
			String noSeg = "", noMin = "", noHr = "";
			if(SF_mode.seg<10) {
				noSeg = "0" + SF_mode.seg;
			}else {
				noSeg = "" + SF_mode.seg;
			}
			if(SF_mode.min<10) {
				noMin = "0" + SF_mode.min;
			}else {
				noMin = "" + SF_mode.min;
			}
			if(SF_mode.hr<10) {
				noHr = "0" + SF_mode.hr;
			}else {
				noHr = "" + SF_mode.hr;
			}
			
			String clock = noHr + ":" + noMin + ":" + noSeg;

			if(SF_mode.startThread == false) {
				clock = "00:00:00";
				SF_mode.seg = 0;
				SF_mode.min = 0;
				SF_mode.hr = 0;
			}
			cronus.setText(clock);
			
			
		} catch (Exception e) {
			System.out.println("ERROR EN EL HILO");
		}
	}
//    @Override
//    protected Object call() throws Exception {
//        // TODO Auto-generated method stub
//        try {
//            int x = 0;
//            while(GS_main.startThread) {
//                Thread.sleep(1000);
//                
//                xtnCronus(x);
//                x++;
//            }
//            
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//        return null;
//    }
}
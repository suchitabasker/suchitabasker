package com.monitor.ApplicationMonitor.services.pojo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.monitor.ApplicationMonitor.services.SystemProcess;


@Service
public class ProcessDetailService {

	public List<SystemProcess> listRunningProcesses() {
	    List<SystemProcess> processes = new ArrayList<>();
	    try {
	      String line;
	      Process p = Runtime.getRuntime().exec("TASKLIST /V /FO CSV");
	      BufferedReader input = new BufferedReader
	          (new InputStreamReader(p.getInputStream()));
	     
	      while ((line = input.readLine()) != null) {
	    	  SystemProcess detail = new SystemProcess();
	          if (!line.trim().equals("")) {
	              String data[] = line.split(",");
	              detail.setName(data[0]);
	              detail.setUsername(data[6]);
	              detail.setActiveTime(data[7]);
	              processes.add(detail);
	          }
	      }
	      input.close();
	    }
	    catch (Exception err) {
	      err.printStackTrace();
	    }
	    return processes;
	  }

}

package com.monitor.ApplicationMonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitor.ApplicationMonitor.services.SystemProcess;
import com.monitor.ApplicationMonitor.services.pojo.ProcessDetailService;

@RestController
public class SystemProcessController {

	@Autowired
	ProcessDetailService service;
	
	@GetMapping("/active-processes")
	public List<SystemProcess> getActiveSystemProcess() {
		return service.listRunningProcesses();
	}
	
	@PostMapping("/active-processes")
	public List<SystemProcess> addActiveSystemProcess() {
		return service.listRunningProcesses();
	}
	
}

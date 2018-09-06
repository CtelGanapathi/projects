package com.code.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.code.deploy.service.CodeDeployService;

@Controller
@RequestMapping("/code/deployService")
public class CodeDeployingSimultaneously {
	
	public static final String GET_DATA = "/GetCodeDeploy";
	
	@Autowired
	CodeDeployService codeDeployService;
	
	@RequestMapping(value=CodeDeployingSimultaneously.GET_DATA,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  String sayHello(@RequestParam String data) throws InterruptedException 
	{
	
		
		String result=codeDeployService.getCodeDeployStatus(data);
		
		return  result;
	}

}

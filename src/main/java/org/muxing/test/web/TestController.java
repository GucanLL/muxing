package org.muxing.test.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.muxing.base.mapper.MxTestMapper;
import org.muxing.base.model.MxTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Resource
	private MxTestMapper MxTestMapper;
	
	@RequestMapping(method = RequestMethod.GET, value = "/testList")
	@ResponseBody
	public Map<String,Object> testList(){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		MxTest mxTest = MxTestMapper.selectByPrimaryKey(1);
		
		resultMap.put("mxTest", mxTest);
		
		return resultMap ;
	}
	
}

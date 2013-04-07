package com.neolore.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller(value = "SenderPortletController")
@RequestMapping("VIEW")
public class SenderPortletController {

	private static Log log = LogFactoryUtil.getLog(SenderPortletController.class);
	/*
	 * maps the incoming portlet request to this method
	 * Since no request parameters are specified, therefore the default
	 * render method will always be this method
	 */
	@RenderMapping
	public String handleRenderRequest(RenderRequest request,RenderResponse response,Model model){
		System.out.println("SenderPortlet default render");
		return "senderPortlet";
	}

	@RenderMapping(params = "action=renderTwo") 
	public String openDeeplinkForInfoI(RenderRequest request, RenderResponse response){
		System.out.println("default render 2");
		return "render2";
	}
	
	@RenderMapping(params = "action=renderAfterAction") 
	public String testRenderMethod(RenderRequest request, RenderResponse response){
		log.info("In renderAfterAction method");		
		System.out.println("stt");
		return "senderPortlet";
	}
	
	@ActionMapping(params = "action=actionOne") 
	public void actionOneMethod(ActionRequest request, ActionResponse response) {
		String color=ParamUtil.get(request, "color", "");
		response.setRenderParameter("action", "renderAfterAction");
		javax.xml.namespace.QName qName =
				new QName("http://liferay.com", "empinfo", "x");
				response.setEvent(
				qName,
				color);
	}
	
	@ActionMapping(params = "action=actionTwo")
	public String addMyChannelAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		return "action2";
	}
	@EventMapping
	public void handleEventRequest(EventRequest request, EventResponse arg1)
			throws Exception {
		 	 javax.portlet.Event event = request.getEvent();
		 	 System.out.println("event has been fired 1");
		
	}
	
	
}

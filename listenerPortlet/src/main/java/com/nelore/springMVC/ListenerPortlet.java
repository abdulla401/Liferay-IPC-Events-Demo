package com.nelore.springMVC;

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
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.mvc.EventAwareController;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.PortletPreferences;

	@Controller
	@RequestMapping("VIEW")
	public class ListenerPortlet implements EventAwareController {

		private static Log log = LogFactoryUtil.getLog(ListenerPortlet.class);
		/*
		 * maps the incoming portlet request to this method
		 * Since no request parameters are specified, therefore the default
		 * render method will always be this method
		 */
		@RenderMapping
		public ModelAndView handleRenderRequest(RenderRequest request,RenderResponse response,Model model){
			System.out.println("default render");
			String s = request.getParameter("id1");
			System.out.println("Maven portlet2 " + s);
			String color = (String)request.getPortletSession().getAttribute("color");
			
//			return "defaultRender";
			return new ModelAndView("listener", "model", color); 
			   
		}
		
		@RenderMapping(params = "action=renderOne")
		public String openSaveSearchPopup(RenderRequest request, RenderResponse response, Model model){
			System.out.println("default render 1");
			return "render1";
		}
		
		@RenderMapping(params = "action=renderTwo") 
		public String openDeeplinkForInfoI(RenderRequest request, RenderResponse response){
			System.out.println("default render 2");
			return "render2";
		}
		
		@RenderMapping(params = "action=renderAfterAction") 
		public String testRenderMethod(RenderRequest request, RenderResponse response){
			log.info("In renderAfterAction method");
			String stt =  request.getParameter("tiger");
			System.out.println("stt");
			return "renderAfterAction";
		}
		
		@ActionMapping(params = "action=actionOne") 
		public void actionOneMethod(ActionRequest request, ActionResponse response) {
			String userName=ParamUtil.get(request, "userName", "");
			log.info("userName is==>"+userName);
			response.setRenderParameter("tiger", "tiger is coming");		
			response.setRenderParameter("action", "renderAfterAction");
		}
		
		@ActionMapping(params = "action=actionTwo")
		public String addMyChannelAction(ActionRequest actionRequest, ActionResponse actionResponse) {
			return "action2";
		}
		
//		@javax.portlet.ProcessEvent(qname = "{http://liferay.com}empinfo")
//		public void handleProcessempinfoEvent(
//		javax.portlet.EventRequest request, javax.portlet.EventResponse
//		response)
//		throws javax.portlet.PortletException, java.io.IOException { 
//		 javax.portlet.Event event = request.getEvent();
//		 String value = (String) event.getValue();
//		 System.out.print("value in process event>>>>>>>>>" + value);
//		 response.setRenderParameter("empInfo", value);
//		}
		@EventMapping
		public void handleEventRequest(EventRequest request, EventResponse response)
				throws Exception {
			 	 javax.portlet.Event event = request.getEvent();
			 	String value  = (String)event.getValue();
			 	request.getPortletSession().setAttribute("color", value);
			 	response.setRenderParameter("color", value);
			 	 QName qName = event.getQName();
			 	 String s = qName.getPrefix();
			 	String localPart = qName.getLocalPart();	
			 	response.setRenderParameter("sent", localPart);
			 	 System.out.println("event has been fired 2");
			 	 
			
			        
			
		}
		
	}

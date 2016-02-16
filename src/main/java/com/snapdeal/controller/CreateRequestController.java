package com.snapdeal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.snapdeal.dao.Dao;
import com.snapdeal.dto.Labels;
import com.snapdeal.dto.SellerDetails;
import com.snapdeal.entity.RequestHistory;
import com.snapdeal.entity.SellerInformation;
import com.snapdeal.entity.SellerRequest;
import com.snapdeal.service.CreateRequestService;

@Controller
//@RequestMapping("/CreateRequest")
public class CreateRequestController {
	@Inject
	@Named("CreateRequestService")
	CreateRequestService createRequestService;

	@Autowired
	Dao camsDwhDao;


	@RequestMapping(value="/SellerCode",method=RequestMethod.GET)
	public String createRequest(){
		return	"redirect:http://54.169.202.117/pickup/";
//		return "SellerCode";
	}

	@RequestMapping (value ="/checkSeller",method = RequestMethod.POST)///post
	public String checkSellerCode(@RequestParam("sellercode") String code,
			@RequestParam("sellerName") String sellerName,//uncomment
			@RequestParam("sellerAddress1") String sellerAddress1,
			@RequestParam("sellerAddress2") String sellerAddress2,
			@RequestParam("sellerState") String sellerAddress3,
			@RequestParam("sellerPincode") String sellerPincode,
			@RequestParam("sellerEmail") String sellerEmail,
			@RequestParam("sellerMobile") String sellerMobile,
			@RequestParam("sellerCity") String sellerCity,
			@RequestParam(value="requestid",required=false) String requestid,ModelMap map,HttpServletRequest request)
	{
		String page = "";
//		SellerDetails sellerDetails = camsDwhDao.getSellerDetails(code);
		if(code != null && !code.isEmpty())
		{
			if (requestid != null && !requestid.isEmpty()){
				map.put("message", "Request saved successfully with ID : "+ requestid );
			}
			List<Labels> labelList = camsDwhDao.getLabels();
			int i =1;
			for (Labels labels : labelList) {
				map.put("label"+i,labels.getParameterName());
				map.put("price"+i,labels.getPrice());
				i++;
			}
			
			map.put("sellerCode", code);
			map.put("seller_name", sellerName);
			map.put("seller_email", sellerEmail);
			map.put("seller_mobile", sellerMobile);
			map.put("seller_address", sellerAddress1 +" " + sellerAddress2 );
			map.put("seller_city", sellerCity);
			map.put("seller_state", sellerAddress3);
			map.put("seller_pincode", sellerPincode);

			List<SellerRequest> sellerRequest = createRequestService.getRequestByStatus(code, "Request Created");
			map.put("requestList", sellerRequest);
			Boolean flag =  createRequestService.getRequestCreatedFlag(code);
			if (flag.equals(true)){
				map.put("flag", "Note:- Please edit previous request.Not allowed to create new request");
			} 
			SellerInformation sellerInfo = new SellerInformation();
			sellerInfo.setSellerCode(code);
			sellerInfo.setSellerName(sellerName);
			sellerInfo.setSellerEmail(sellerEmail);
			sellerInfo.setSellerMobile(sellerMobile);
			sellerInfo.setSellerAddress( sellerAddress1 +" " + sellerAddress2);
			sellerInfo.setSellerCity(sellerCity);
//			map.put("seller_city", sellerCity);
			sellerInfo.	setSellerState(sellerAddress3);
			sellerInfo.	setSellerPincode(sellerPincode);
			request.getSession().setAttribute("sellerInfo",sellerInfo);
			
//						SellerInformation sellerInfo = (SellerInformation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//						User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			
			page="home"; 
		}
		else {
			map.put("message","Invalid Seller Code");
			page="SellerCode";
		}
		return page;
	}
	
	
	
	
	@RequestMapping (value ="/saveRequest",method = RequestMethod.GET)
	public String saveRequest(@RequestParam("sellercode") String code,
			@RequestParam("sellerName") String sellerName,
			@RequestParam("sellerMobile") String sellerMobile,
			@RequestParam("sellerAddress") String sellerAddress,
			@RequestParam("sellerPincode") String sellerPincode,
			@RequestParam("sellerEmail") String sellerEmail,
			@RequestParam("sellerState") String sellerState,
			@RequestParam("sellerCity") String sellerCity,
			@RequestParam(value="requestid",required=false) String requestid,ModelMap map,HttpServletRequest request)
	{
		String page = "";
//		SellerDetails sellerDetails = camsDwhDao.getSellerDetails(code);
		if(code != null)
		{
			if (requestid != null && !requestid.isEmpty()){
				map.put("message", "Request saved successfully with ID : "+ requestid );
			}
			map.put("sellerCode", code);
			map.put("seller_name", sellerName);
			map.put("seller_email", sellerEmail);
			map.put("seller_mobile", sellerMobile);
			map.put("seller_address", sellerAddress);
			map.put("seller_city", sellerCity);
			map.put("seller_state", sellerState);
			map.put("seller_pincode", sellerPincode);
			List<SellerRequest> sellerRequest = createRequestService.getRequestByStatus(code, "Request Created");
			map.put("requestList", sellerRequest);
			Boolean flag =  createRequestService.getRequestCreatedFlag(code);
			if (flag.equals(true)){
				map.put("flag", "Note:- Please edit previous request.Not allowed to create new request");
			} 
			SellerInformation sellerInfo = new SellerInformation();
			sellerInfo.setSellerCode(code);
			sellerInfo.setSellerName(sellerName);
			sellerInfo.setSellerEmail(sellerEmail);
			sellerInfo.setSellerMobile(sellerMobile);
			sellerInfo.	setSellerAddress(sellerAddress);
			sellerInfo.	setSellerCity(sellerCity);
			sellerInfo.	setSellerState(sellerState);
			sellerInfo.	setSellerPincode(sellerPincode);
			request.getSession().setAttribute("sellerInfo",sellerInfo);
			List<Labels> labelList = camsDwhDao.getLabels();
			int i =1;
			for (Labels labels : labelList) {
				map.put("label"+i,labels.getParameterName());
				map.put("price"+i,labels.getPrice());
				i++;
			}
			//			SellerInformation sellerInfo = (SellerInformation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//			User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			page="home"; 
		}
		else {
			map.put("message","Invalid Seller Code");
			page="SellerCode";
		}
		return page;
	}
	
	
	@RequestMapping("/save")	
	public String saveRequest(@ModelAttribute("SellerRequest") SellerRequest CreateRequest, ModelMap map){
		String requestId = null;
		CreateRequest.setCreated(new Date());
		CreateRequest.setRequeststatus("Request Created");
		Long id;
		Boolean flag =  createRequestService.getRequestCreatedFlag(CreateRequest.getSellerCode());
	
		System.out.println("id"+CreateRequest.getId());
			if (CreateRequest.getId() != null){
				RequestHistory RequestHis = createRequestService.getRequestHistoryByRequestId(CreateRequest.getId()); 
				RequestHis.setCreated(new Date());
				RequestHis.setRequeststatus("Request Created");
				createRequestService.saveRequestHistory(RequestHis);
				id = createRequestService.saveRequest(CreateRequest);
			}
			else{
				if (flag.equals(false)){
					id = createRequestService.saveRequest(CreateRequest);
					System.out.println("entered");
					RequestHistory RequestHis = new RequestHistory(); 
					RequestHis.setRequestid(id);
					RequestHis.setCreated(new Date());
					RequestHis.setRequeststatus("Request Created");
					createRequestService.saveRequestHistory(RequestHis);
					}
				else{
					map.put("sellerCode", CreateRequest.getSellerCode());
					map.put("seller_name", CreateRequest.getSeller_name());
					map.put("seller_mobile", CreateRequest.getSeller_mobile());
					map.put("seller_email", CreateRequest.getSeller_email());
					map.put("seller_address", CreateRequest.getSeller_address());
					map.put("seller_city", CreateRequest.getSeller_city());
					map.put("seller_state", CreateRequest.getSeller_state());
					map.put("seller_pincode", CreateRequest.getSeller_pincode());
					map.put("flag", "Note:- Please edit previous request.Not allowed to create new request");
					List<Labels> labelList = camsDwhDao.getLabels();
					int i =1;
					for (Labels labels : labelList) {
						map.put("label"+i,labels.getParameterName());
						map.put("price"+i,labels.getPrice());
						i++;
					}
					
					List<SellerRequest> sellerRequest = createRequestService.getRequestByStatus(CreateRequest.getSellerCode(), "Request Created");
					map.put("requestList", sellerRequest);
					map.put("message", "Request already created.Please edit previous request.");
					return "home";
				}
					
			}
				map.put("sellerCode", CreateRequest.getSellerCode());
				map.put("seller_name", CreateRequest.getSeller_name());
				map.put("seller_mobile", CreateRequest.getSeller_mobile());
				map.put("seller_email", CreateRequest.getSeller_email());
				map.put("seller_address", CreateRequest.getSeller_address());
				map.put("seller_city", CreateRequest.getSeller_city());
				map.put("seller_state", CreateRequest.getSeller_state());
				map.put("seller_pincode", CreateRequest.getSeller_pincode());
				List<Labels> labelList = camsDwhDao.getLabels();
				int i =1;
				for (Labels labels : labelList) {
					map.put("label"+i,labels.getParameterName());
					map.put("price"+i,labels.getPrice());
					i++;
				}
				requestId = CreateRequest.getSellerCode()+"/"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"/"+id;
				return "redirect:saveRequest?sellercode="+CreateRequest.getSellerCode()+"&requestid="+requestId+"&sellerName="+CreateRequest.getSeller_name()+"&sellerAddress="+CreateRequest.getSeller_address()+"&sellerMobile="+CreateRequest.getSeller_mobile()+"&sellerEmail="+CreateRequest.getSeller_email()+"&sellerPincode="+CreateRequest.getSeller_pincode()+"&sellerState="+CreateRequest.getSeller_state()+"&sellerCity="+CreateRequest.getSeller_city();
		
			
		}
		
		//		map.put("message", "Request saved successfully with ID : "+ requestId );
		//		return "home";
	

	@RequestMapping("/Retrieve")
	public String getRequests(@RequestParam("Reservation") String Reservation ,@RequestParam("status") String status,  
			@RequestParam("SellerCode") String SellerCode,@RequestParam("seller_email") String seller_email,@RequestParam("seller_mobile") String seller_mobile,@RequestParam("seller_name") String seller_name,@RequestParam("seller_address") String seller_address,@RequestParam("seller_city") String seller_city,@RequestParam("seller_state") String seller_state,@RequestParam("seller_pincode") String seller_pincode , ModelMap map,HttpServletRequest request) throws java.text.ParseException{
		map.put("Retrieve",Reservation);
		map.put("status", status);
		map.put("SellerCode",SellerCode);
		map.put("seller_email", seller_email);
		map.put("seller_name", seller_name);
		map.put("seller_mobile", seller_mobile);
		map.put("seller_address", seller_address);
		map.put("seller_city", seller_city);
		map.put("seller_state", seller_state);
		map.put("seller_pincode", seller_pincode);


//				SellerInformation.this.setDateRange(Reservation);
		SellerInformation sellerInfo = (SellerInformation)request.getSession().getAttribute("sellerInfo");
		sellerInfo.setDateRange(Reservation);
		sellerInfo.setStatus(status);
		request.getSession().setAttribute("sellerInfo",sellerInfo);
		//		SellerInformation sellerInfo1 = (SellerInformation)request.getSession().setAttribute("sellerInfo",sellerInfo);
		String[] parts = Reservation.split("-");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date Date1 = simpleDateFormat.parse(parts[0]+" 00:00:00");
		Date Date2 = simpleDateFormat.parse(parts[1]+" 23:59:59");
		//		System.out.println(Date1);
		//		System.out.println(Date2);
		List<SellerRequest> sellerRequest = createRequestService.getRequestBySellerCode(Date1,Date2,SellerCode,status);
		map.put("requestList", sellerRequest);
		map.put("sellerCode", SellerCode);
		map.put("seller_name", seller_name);
		map.put("seller_mobile", seller_mobile);
		map.put("seller_email", seller_email);
		map.put("seller_address", seller_address);
		map.put("seller_city", seller_city);
		map.put("seller_state", seller_state);
		map.put("seller_pincode", seller_pincode);
		List<Labels> labelList = camsDwhDao.getLabels();
		int i =1;
		for (Labels labels : labelList) {
			map.put("label"+i,labels.getParameterName());
			map.put("price"+i,labels.getPrice());
			i++;
		}
		Boolean flag =  createRequestService.getRequestCreatedFlag(SellerCode);

		if (flag.equals(true)){
			map.put("flag", "Note:- Please edit previous request.Not allowed to create new request");
		} 
		
//		map.put("flag", createRequestService.getRequestCreatedFlag(SellerCode));

		//		System.out.println(Reservation);


		//Date Date2 = new Date(parts[1],"DD/MM/YYYY");

		//Date Date2 =  DateField.stringToDate(parts[1],"DD/MM/YYYY");


		return "home";
	}

	@RequestMapping("/RetrieveAgain")
	public String RetrieveAgain(ModelMap map,HttpServletRequest request) throws java.text.ParseException{
		SellerInformation sellerInfo = (SellerInformation)request.getSession().getAttribute("sellerInfo");
		map.put("Retrieve",sellerInfo.getDateRange());
		map.put("sellerCode",sellerInfo.getSellerCode());
		map.put("seller_email",sellerInfo.getSellerEmail());
		map.put("seller_name", sellerInfo.getSellerName());
		map.put("seller_mobile", sellerInfo.getSellerMobile());
		map.put("seller_address", sellerInfo.getSellerAddress());
		map.put("seller_city", sellerInfo.getSellerCity());
		map.put("seller_state", sellerInfo.getSellerState());
		map.put("seller_pincode", sellerInfo.getSellerPincode());
		List<Labels> labelList = camsDwhDao.getLabels();
		int i =1;
		for (Labels labels : labelList) {
			map.put("label"+i,labels.getParameterName());
			map.put("price"+i,labels.getPrice());
			i++;
		}
//		map.put("flag", createRequestService.getRequestCreatedFlag(sellerInfo.getSellerCode()));
		//		List<SellerRequest> sellerRequest = createRequestService.getRequestByStatus(sellerInfo.getSellerCode(),"Request Created");
		//		map.put("requestList", sellerRequest);
		//		SellerInformation.this.setDateRange(Reservation);
		//		SellerInformation sellerInfo1 = (SellerInformation)request.getSession().setAttribute("sellerInfo",sellerInfo);
		List<SellerRequest> sellerRequest ;
		if (sellerInfo.getDateRange() != null){ 
			String[] parts = sellerInfo.getDateRange().split("-");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			Date Date1 = simpleDateFormat.parse(parts[0]+" 00:00:00");
			Date Date2 = simpleDateFormat.parse(parts[1]+" 23:59:59");
			sellerRequest = createRequestService.getRequestBySellerCode(Date1,Date2,sellerInfo.getSellerCode(),sellerInfo.getStatus());
		}
		else {
			sellerRequest = createRequestService.getRequestByStatus(sellerInfo.getSellerCode(), "Request Created");
		}
		Boolean flag =  createRequestService.getRequestCreatedFlag(sellerInfo.getSellerCode());

		if (flag.equals(true)){
			map.put("flag", "Note:- Please edit previous request.Not allowed to create new request");
		} 
		map.put("requestList", sellerRequest);

		return "home";
	}




	//Delete
	@RequestMapping("/Delete")
	public String deleteRequests(@RequestParam("id") Long id ,
			ModelMap map) throws java.text.ParseException{
		createRequestService.deleteRequest(id);
		RequestHistory RequestHis = new RequestHistory(); 
		RequestHis.setRequestid(id);
		RequestHis.setCreated(new Date());
		RequestHis.setRequeststatus("Deleted");
		createRequestService.saveRequestHistory(RequestHis);
		return "redirect:/RetrieveAgain";
	}

	@RequestMapping("/Edit")
	public String editRequests(@RequestParam("id") Long id ,
			ModelMap map) throws java.text.ParseException{
		
		
		SellerRequest sr = createRequestService.getRequestDetailsById(id);
		map.put("id",sr.getId());
		map.put("sellerCode",sr.getSellerCode());
		map.put("seller_email",sr.getSeller_email());
		map.put("seller_name", sr.getSeller_name());
		map.put("seller_mobile", sr.getSeller_mobile());
		map.put("seller_address", sr.getSeller_address());
		map.put("seller_city", sr.getSeller_city());
		map.put("seller_state", sr.getSeller_state());
		map.put("seller_pincode", sr.getSeller_pincode());
		map.put("para1", sr.getPara1());
		map.put("para2", sr.getPara2());
		map.put("para3", sr.getPara3());
		map.put("para4", sr.getPara4());
		map.put("para5", sr.getPara5());
		map.put("para6", sr.getPara6());
		map.put("para7", sr.getPara7());
		map.put("para8", sr.getPara8());
		map.put("para9", sr.getPara9());
		map.put("para10", sr.getPara10());
		map.put("para11", sr.getPara11());
		List<Labels> labelList = camsDwhDao.getLabels();
		int i =1;
		for (Labels labels : labelList) {
			map.put("label"+i,labels.getParameterName());
			map.put("price"+i,labels.getPrice());
			i++;
		}
//		map.put("SellerCode", sr);
		return "home";
	}
	

	//showParameter
	@RequestMapping("/showParameter")
	public String showParameter(@RequestParam("id") Long id ,
			ModelMap map) {	
		SellerRequest sr =createRequestService.getRequestDetailsById(id);
		map.put("requestID",sr.getSellerCode()+"/"+sr.getCreated()+"/"+sr.getId());
		
		
		if (sr.getPara1()!= null){
			map.put("para1", sr.getPara1() +" * " +sr.getPrice1()+" = "+sr.getPara1() * sr.getPrice1());
		}
		else{
			map.put("para1", sr.getPara1());
		}
		
		if (sr.getPara2()!= null ){
			map.put("para2", sr.getPara2() +" * " +sr.getPrice2()+" = "+sr.getPara2() * sr.getPrice2());
		}
		else{
			map.put("para2", sr.getPara2());
		}
		
		if (sr.getPara3()!= null ){
			map.put("para3", sr.getPara3() +" * " +sr.getPrice3()+" = "+sr.getPara3() * sr.getPrice3());
		}
		else{
			map.put("para3", sr.getPara3());
		}
		
		if (sr.getPara4()!= null ){
			map.put("para4", sr.getPara4() +" * " +sr.getPrice4()+" = "+sr.getPara4() * sr.getPrice4());
		}
		else{
			map.put("para4", sr.getPara4());
		}
		
		if (sr.getPara5()!= null ){
			map.put("para5", sr.getPara5() +" * " +sr.getPrice5()+" = "+sr.getPara5() * sr.getPrice5());
		}
		else{
			map.put("para5", sr.getPara5());
		}
		
		if (sr.getPara6()!= null){
			map.put("para6", sr.getPara6() +" * " +sr.getPrice6()+" = "+sr.getPara6() * sr.getPrice6());
		}
		else{
			map.put("para6", sr.getPara6());
		}
		
		if (sr.getPara7()!= null ){
			map.put("para7", sr.getPara7() +" * " +sr.getPrice7()+" = "+sr.getPara7() * sr.getPrice7());
		}
		else{
			map.put("para7", sr.getPara7());
		}
		
		if (sr.getPara8()!= null ){
			map.put("para8", sr.getPara8() +" * " +sr.getPrice8()+" = "+sr.getPara8() * sr.getPrice8());
		}
		else{
			map.put("para8", sr.getPara8());
		}
		
		if (sr.getPara9()!= null ){
			map.put("para9", sr.getPara9() +" * " +sr.getPrice9()+" = "+sr.getPara9() * sr.getPrice9());
		}
		else{
			map.put("para9", sr.getPara9());
		}
		
		if (sr.getPara10()!= null ){
			map.put("para10", sr.getPara10() +" * " +sr.getPrice10()+" = "+sr.getPara10() * sr.getPrice10());
		}
		else{
			map.put("para10", sr.getPara10());
		}
		
		if (sr.getPara11()!= null ){
			map.put("para11", sr.getPara11() +" * " +sr.getPrice11()+" = "+sr.getPara11() * sr.getPrice11());
		}
		else{
			map.put("para11", sr.getPara11());
		}

		
		
		
		//		map.put("para1", sr.getPara1().intValue() +"*" +sr.getPrice1().doubleValue()+" = "+sr.getPara1().intValue() * sr.getPrice1().doubleValue());
//		map.put("para2", sr.getPara2().intValue() +"*" +sr.getPrice2().doubleValue()+" = "+sr.getPara2().intValue() * sr.getPrice2().doubleValue());
//		map.put("para3", sr.getPara3().intValue() +"*" +sr.getPrice3().doubleValue()+" = "+sr.getPara3().intValue() * sr.getPrice3().doubleValue());
//		map.put("para4", sr.getPara4().intValue() +"*" +sr.getPrice4().doubleValue()+" = "+sr.getPara4().intValue() * sr.getPrice4().doubleValue());
//		map.put("para5", sr.getPara5().intValue() +"*" +sr.getPrice5().doubleValue()+" = "+sr.getPara5().intValue() * sr.getPrice5().doubleValue());
//		map.put("para6", sr.getPara6().intValue() +"*" +sr.getPrice6().doubleValue()+" = "+sr.getPara6().intValue() * sr.getPrice6().doubleValue());
//		map.put("para7", sr.getPara7().intValue() +"*" +sr.getPrice7().doubleValue()+" = "+sr.getPara7().intValue() * sr.getPrice7().doubleValue());
//		map.put("para8", sr.getPara8().intValue() +"*" +sr.getPrice8().doubleValue()+" = "+sr.getPara8().intValue() * sr.getPrice8().doubleValue());
//		map.put("para9", sr.getPara9().intValue() +"*" +sr.getPrice9().doubleValue()+" = "+sr.getPara9().intValue() * sr.getPrice9().doubleValue());
		return "showParameter" ;
	}



	//	@RequestMapping("/info")
	//	public String showStudentDetailByName(@ModelAttribute("name") String name,ModelMap map){
	//		Student student = studentService.searchStudentByName(name);
	//		map.put("student",student);
	//		return "Student/search";
	//	}

	//	@RequestMapping("/checkseller")
	//	public @ResponseBody String checkRule(@ModelAttribute("Sellercode") String sellerCode)
	//	{
	//		boolean result = CreateRequestService.checkSeller( sellerCode);
	//		if(result)
	//		{
	//			return "success";
	//		}
	//		else{
	//			return "failure";
	//		}
	//	}

	@RequestMapping(value="/CreateRequest/{id}",method=RequestMethod.GET)
	public String getSellerCode(@PathVariable("id") String id,ModelMap map)
	{
		map.put("sellerCode", id);
		return "home"; 



	}
}


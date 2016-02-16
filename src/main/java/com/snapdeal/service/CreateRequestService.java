package com.snapdeal.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.snapdeal.entity.RequestHistory;
import com.snapdeal.entity.SellerRequest;

@Service
public interface CreateRequestService {
	
	public Long saveRequest(SellerRequest CreateRequest);
	public void saveRequestHistory(RequestHistory RequestHis);
	public void deleteRequest(long id) ;
	public List<SellerRequest> getRequestBySellerCode(Date Date1,Date Date2,String SellerCode,String status);
	public List<SellerRequest> getRequestByStatus(String SellerCode,String Status);
	public SellerRequest getRequestDetailsById(Long id);
	public RequestHistory getRequestHistoryByRequestId(Long requestId);
	public Boolean getRequestCreatedFlag(String SellerCode);
//	public Student searchStudentByName(String name);
//	public void updateStudent(Student student);
}

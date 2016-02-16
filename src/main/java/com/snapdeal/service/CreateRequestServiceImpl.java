package com.snapdeal.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.snapdeal.dao.EntityDao;
import com.snapdeal.entity.RequestHistory;
import com.snapdeal.entity.SellerRequest;


@Named("CreateRequestService")
@Transactional
public class CreateRequestServiceImpl implements CreateRequestService{

	@Inject
	@Named("entityDao")
	EntityDao entityDao;

	@Override
	public Long saveRequest(SellerRequest CreateRequest){
		System.out.println("id="+CreateRequest.getId());
		if (CreateRequest.getId() != null){
			entityDao.update(CreateRequest);
		}
		else{
			entityDao.save(CreateRequest);
		}
		return CreateRequest.getId();
	}
	
	@Override
	public void deleteRequest(long id){
		SellerRequest sellerRequest=entityDao.findById(SellerRequest.class, id)	;
		sellerRequest.setRequeststatus("Deleted");
		entityDao.update(sellerRequest);
	}

	@Override
	public void saveRequestHistory(RequestHistory RequestHis){
		EntityManager entityManager = entityDao.getEntityManager();
		//		Query query = entityManager.createQuery("Insert into RequestHistory(id,created,requeststatus) values(:id ,:created,:requeststaus");
		//		query.setParameter("id", RequestHis.getId());
		//		query.setParameter("created", RequestHis.getCreated());
		//		query.setParameter("requeststatus", RequestHis.getRequeststatus());
		//		query.getSingleResult();
			System.out.println(RequestHis.getId());
			if (RequestHis.getId() != 0L)
				entityManager.merge(RequestHis);
			else
				entityManager.persist(RequestHis);
		
			
	}

	@Override
	public List<SellerRequest> getRequestBySellerCode(Date Date1,Date Date2,String SellerCode,String status){
		Query query;
		EntityManager entityManager = entityDao.getEntityManager();
		if (status.equals("ALL")){
			query = entityManager.createQuery("Select sellerRequest from SellerRequest sellerRequest Where sellerRequest.SellerCode = :SellerCode  and sellerRequest.requeststatus <> 'Deleted' and sellerRequest.created between :Date1 and :Date2  ORDER BY sellerRequest.id  ");
		
		}
		else{
			query = entityManager.createQuery("Select sellerRequest from SellerRequest sellerRequest Where sellerRequest.SellerCode = :SellerCode and sellerRequest.requeststatus = :status and sellerRequest.requeststatus <> 'Deleted' and sellerRequest.created between :Date1 and :Date2  ORDER BY sellerRequest.id  ");
			query.setParameter("status", status);
		}
		
		query.setParameter("Date1", Date1);
		query.setParameter("Date2", Date2);
		
		query.setParameter("SellerCode", SellerCode);
		@SuppressWarnings("unchecked")
		List<SellerRequest> sellerRequest = (List<SellerRequest>)query.getResultList();
		return sellerRequest;
	}
	
	public SellerRequest getRequestDetailsById(Long id){

		EntityManager entityManager = entityDao.getEntityManager();
		Query query = entityManager.createQuery("Select sellerRequest from SellerRequest sellerRequest Where sellerRequest.id = :id");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<SellerRequest> sellerRequestList = (List<SellerRequest>)query.getResultList();
		if(sellerRequestList != null && sellerRequestList.size() > 0)
		{
			return sellerRequestList.get(0);	
		}
		else {
			return null;
		}
	}

	@Override
	public List<SellerRequest> getRequestByStatus(String SellerCode,
			String status) {
		EntityManager entityManager = entityDao.getEntityManager();
		Query query = entityManager.createQuery("Select sellerRequest from SellerRequest sellerRequest Where sellerRequest.SellerCode = :SellerCode and sellerRequest.requeststatus = :status  ORDER BY sellerRequest.id ");
		query.setParameter("SellerCode", SellerCode);
		query.setParameter("status", status);
		@SuppressWarnings("unchecked")
		List<SellerRequest> sellerRequest = (List<SellerRequest>)query.getResultList();
		return sellerRequest;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean getRequestCreatedFlag(String SellerCode) {
		EntityManager entityManager = entityDao.getEntityManager();
		Query query = entityManager.createQuery("Select sellerRequest from SellerRequest sellerRequest Where sellerRequest.SellerCode = :SellerCode and sellerRequest.requeststatus = 'Request Created'  ORDER BY sellerRequest.id ");
		query.setParameter("SellerCode", SellerCode);
		List<SellerRequest> sellerRequest = (List<SellerRequest>)query.getResultList();
		if(sellerRequest != null && sellerRequest.size() > 0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public RequestHistory getRequestHistoryByRequestId(Long requestId) {
		EntityManager entityManager = entityDao.getEntityManager();
		Query query = entityManager.createQuery("Select requestHistory from RequestHistory requestHistory Where requestHistory.requestid = :id");
		query.setParameter("id",requestId);
		@SuppressWarnings("unchecked")
		List<RequestHistory> requestHis = (List<RequestHistory>)query.getResultList();
		if(requestHis != null && requestHis.size() > 0)
		{
			return requestHis.get(0);	
		}
		else {
			return null;
		}
	}
	
//	@Override
	
//	public SellerDetails checkSellerCode(String name){
//		EntityManager entityManager = entityDao.getEntityManager();
//		Query query = entityManager.createQuery("select SellerDetails from  vendor_details where code =:name");
//		query.setParameter("name", name);
//		sellerDetails = query.getSingleResult();
//		return sellerDetails;
//	}



	//	@Override
	//	public Student searchStudentByName(String name){
	//		EntityManager entityManager = entityDao.getEntityManager();
	//		Query query = entityManager.createQuery("Select student from Student student Where student.name = :name");
	//		query.setParameter("name", name);
	//		Student student = (Student)query.getSingleResult();
	//		return student;
	//	}

	//	@Override
	//	public Student searchStudentByName(String name){
	//		EntityManager entityManager = entityDao.getEntityManager();
	//		Query query = entityManager.createQuery("Select student from Student student Where student.name = :name");
	//		query.setParameter("name", name);
	//		Student student = (Student)query.getSingleResult();
	//		return student;
	//	}
	//	
	//	@Override
	//	public void updateStudent(Student student){
	//		entityDao.update(student);
	//	}
}

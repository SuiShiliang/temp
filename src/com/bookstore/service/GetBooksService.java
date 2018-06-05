package com.bookstore.service;

import java.util.List;
import java.util.Map;

import com.bookstore.dao.GetBooksDao;

public class GetBooksService {

	private GetBooksDao dao = new GetBooksDao();
	
	public List<Map<String , Object>> getBooksList(int pageNum, int pageCount) {
		return dao.getBooksList(pageNum, pageCount);
	}
	
	public int getBookCount(int pagecount) {
		return dao.getBookCount(pagecount);
	}
	
	public List<Map<String , Object>> getBooksListForSerch(String name) {
		return dao.getBooksListForSerch(name);
	}
	
	public Map<String , Object> getBookInfoById(int id){
		return dao.getBookInfoById(id);
	}
	
	public List<Map<String , Object>> getBookChaptersById(int id){
		return dao.getBookChaptersById(id);
	}
}

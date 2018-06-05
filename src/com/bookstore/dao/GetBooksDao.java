package com.bookstore.dao;

import java.util.List;
import java.util.Map;

import com.bookstore.util.JDBCUtil;

public class GetBooksDao {

	private JDBCUtil jdbc = new JDBCUtil();

	/**
	 * 根据条件获取书籍
	 * @param pageNum 第几页
	 * @param pageCount 每页几条数据
	 */
	public List<Map<String , Object>> getBooksList(int pageNum, int pageCount) {
		String sql = "select *" + 
				"  from (select rownum as rn, bb.* from BOOKS bb where rownum <= (?) * ?) bo," + 
				"       book_images bi," + 
				"       images im" + 
				" where bo.id = bi.book_id" + 
				"   and bi.image_id = im.id" + 
				"   and rn > (? - 1) * ?";
		List<Map<String , Object>> list = jdbc.findByCondition(sql,pageNum,pageCount,pageNum,pageCount);
		return list;
	}
	
	/**
	 * 返回总共有多少页
	 * @param pagecount 每页多少条数据
	 * @return
	 */
	public int getBookCount(int pagecount) {
		String sql = "select count(*) count from BOOKS";
		Map<String , Object> map = jdbc.findByConditionOne(sql);
		int count = Integer.parseInt(map.get("COUNT").toString()) ;
		if(count % pagecount != 0) {
			return count/pagecount + 1;
		}
		return count/pagecount;
	}
	
	/**
	 * 根据搜索字模糊查询匹配的书籍
	 * @param name
	 * @return
	 */
	public List<Map<String , Object>> getBooksListForSerch(String name) {
		
		String bookname = "";
		int i = 0;
		//将搜索字进行模糊字改写 ，如“求魔” 改为 “%求%魔%”
		while(i < name.length()) {
			bookname += "%" + name.charAt(i);
			i++;
		}
		bookname += "%";
		String sql = "select * " + 
				"from BOOKS bo,  book_images bi,images im" + 
				" where bo.id = bi.book_id" + 
				"   and bi.image_id = im.id" + 
				"   and bo.books_name like ? ";
		List<Map<String , Object>> list = jdbc.findByCondition(sql,bookname);
		return list;
	}

	
	/**
	 * 根据书籍的id查询书籍的大部分信息
	 * @param id
	 * @return
	 */
	public Map<String , Object> getBookInfoById(int id){
		String sql = "select *" + 
				"  from books          bo," + 
				"       book_images    bi," + 
				"       images         im," + 
				"       books_authors  ba," + 
				"       book_discounts bd," + 
				"       book_batchs    bb," + 
				"       authors        au" + 
				" where bo.id = ?" + 
				"   and bo.id = bi.book_id" + 
				"   and bi.image_id = im.id" + 
				"   and bo.id = ba.book_id" + 
				"   and ba.author_id = au.id" + 
				"   and bo.id = bd.book_id" + 
				"   and bo.id = bb.book_id";
		Map<String , Object> map = jdbc.findByConditionOne(sql, id);
		return map;
	}
	
	/**
	 * 根据数据id查询书籍对应的章节目录
	 * @param id
	 * @return
	 */
	public List<Map<String , Object>> getBookChaptersById(int id){
		String sql = "select *" + 
				"  from books bo, book_chapters bc" + 
				" where bo.id = bc.book_id" + 
				"   and bo.id = ?";
		List<Map<String , Object>> list = jdbc.findByCondition(sql, id);
		return list;
	}
}

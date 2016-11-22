package com.hainan.cs.dao;

import java.util.List;

import com.hainan.cs.bean.PaperBean;

public interface PaperDao {

	PaperBean getPaper(String id);

	void insert(PaperBean paper);

	void delete(String id);

	List<PaperBean> queryCreatorId(String id);

	List<PaperBean> queryType(String type);

	List<PaperBean> queryName(String papername);

}

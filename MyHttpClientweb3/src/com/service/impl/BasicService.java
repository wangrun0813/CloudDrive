package com.service.impl;

import javax.annotation.Resource;

import com.dao.FiletableDao;
import com.dao.FoldertableDao;
import com.dao.SharefiletableDao;
import com.dao.UserDao;
import com.entity.Filetable;

public class BasicService {
	@Resource
	protected UserDao userDao;
	@Resource
	protected FiletableDao filetableDao;
	@Resource
	protected FoldertableDao foldertableDao;
	@Resource
	protected SharefiletableDao sharefiletableDao;

}

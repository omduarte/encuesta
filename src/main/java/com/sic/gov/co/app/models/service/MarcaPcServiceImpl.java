package com.sic.gov.co.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sic.gov.co.app.models.dao.IMarcaPcDao;
import com.sic.gov.co.app.models.entity.MarcaPc;

@Service
public class MarcaPcServiceImpl implements IMarcaPcService {

	@Autowired
	private IMarcaPcDao MarcaPcDao;

	@Transactional(readOnly = true)
	@Override
	public List<MarcaPc> findAll() {
		return  (List<MarcaPc>) MarcaPcDao.findAll();
	}

	@Transactional
	@Override
	public void save(MarcaPc MarcaPc) {
		MarcaPcDao.save(MarcaPc);

	}

	@Transactional(readOnly = true)
	@Override
	public MarcaPc findOne(Long id) {
		return MarcaPcDao.findById(id).orElse(null);		
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		MarcaPcDao.deleteById(id);

	}

}

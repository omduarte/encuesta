package com.sic.gov.co.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sic.gov.co.app.models.dao.IEncuestaDao;
import com.sic.gov.co.app.models.entity.Encuesta;

@Service
public class EncuestaServiceImpl implements IEncuestaService {

	@Autowired
	private IEncuestaDao encuestaDao;

	@Transactional(readOnly = true)
	@Override
	public List<Encuesta> findAll() {
		return  (List<Encuesta>) encuestaDao.findAll();
	}

	@Transactional
	@Override
	public void save(Encuesta Encuesta) {
		encuestaDao.save(Encuesta);

	}

	@Transactional(readOnly = true)
	@Override
	public Encuesta findOne(Long id) {
		return encuestaDao.findById(id).orElse(null);		
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		encuestaDao.deleteById(id);

	}

}

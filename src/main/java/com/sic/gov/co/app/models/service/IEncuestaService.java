package com.sic.gov.co.app.models.service;

import java.util.List;

import com.sic.gov.co.app.models.entity.Encuesta;

public interface IEncuestaService {

	public List<Encuesta> findAll();

	public void save(Encuesta Encuesta);

	public Encuesta findOne(Long id);

	public void delete(Long id);

}

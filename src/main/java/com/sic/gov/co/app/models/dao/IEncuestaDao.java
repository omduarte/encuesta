package com.sic.gov.co.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sic.gov.co.app.models.entity.Encuesta;

public interface IEncuestaDao extends CrudRepository<Encuesta, Long> {

}

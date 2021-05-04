package com.sic.gov.co.app.models.service;

import java.util.List;

import com.sic.gov.co.app.models.entity.MarcaPc;

public interface IMarcaPcService {

	public List<MarcaPc> findAll();

	public void save(MarcaPc marcaPc);

	public MarcaPc findOne(Long id);

	public void delete(Long id);

}

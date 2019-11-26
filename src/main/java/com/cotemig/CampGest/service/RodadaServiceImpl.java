package com.cotemig.CampGest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.CampGest.dao.RodadaDAO;
import com.cotemig.CampGest.model.Rodada;
import com.cotemig.CampGest.model.Time;

@Service("rodadaService")
public class RodadaServiceImpl implements RodadaService{
	@Autowired
	RodadaDAO rodadaDAO;

	@Override
	public Optional<Rodada> getRodadaById(Integer id) {
		return rodadaDAO.findById(id);
	}

	@Override
	public List<Rodada> getAllRodada() {
		return rodadaDAO.findAll();
	}

	@Override
	public void deleteAllRodadas() {
		rodadaDAO.deleteAll();
	}

	@Override
	public void deleteRodadaById(Integer id) {
		rodadaDAO.deleteById(id);
	}

	@Override
	public void updateRodadaById(Integer id, Rodada Rodada) {
		Optional<Rodada> getRodada = getRodadaById(id);
		getRodada.get().setCod_tabela(Rodada.getCod_tabela());
		getRodada.get().setPartidas(Rodada.getPartidas());
	}

	@Override
	public void updateRodada(Rodada rodada) {
		rodadaDAO.save(rodada);
	}

	@Override
	public void insertRodada(Rodada rodada) {
		rodadaDAO.save(rodada);
		
	}

	
	
}

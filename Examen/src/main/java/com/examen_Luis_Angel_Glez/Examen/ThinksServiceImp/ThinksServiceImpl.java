package com.examen_Luis_Angel_Glez.Examen.ThinksServiceImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen_Luis_Angel_Glez.Examen.Model.Thinks;
//import com.example.springboot.app.exception.ResourceNotFoundException;
import com.examen_Luis_Angel_Glez.Examen.repository.ThinksRepository;
import com.examen_Luis_Angel_Glez.Examen.ThinksServiceImp.ThinksService;
import com.examen_Luis_Angel_Glez.Examen.Exception.ResourceNotFoundException;

@Service 
@Transactional 
public class ThinksServiceImpl implements ThinksService {

	@Autowired
	private ThinksRepository thinksRepository;

	@Override
	public Thinks neww(Thinks thinks) {
		return thinksRepository.save(thinks);
	}

	@Override
	public Thinks update(Thinks thinks) {
		Optional<Thinks> thinksdb = this.thinksRepository.findById(thinks.getId());

		if (thinksdb.isPresent()) {
			Thinks thinksUpdate = thinksdb.get();
			thinksUpdate.setId(thinks.getId());
			thinksUpdate.setName(thinks.getName());
			thinksRepository.save(thinksUpdate);
			return thinksUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + thinks.getId());
		}
	}

	@Override
	public List<Thinks> getAll() {
		return this.thinksRepository.findAll();
	}

	@Override
	public Thinks getById(long thinksId) {

		Optional<Thinks> thinksdb = this.thinksRepository.findById(thinksId);

		if (thinksdb.isPresent()) {
			return thinksdb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + thinksId);
		}
	}

	@Override
	public void deleteThinks(long thinksId) {
		Optional<Thinks> thinksdb = this.thinksRepository.findById(thinksId);

		if (thinksdb.isPresent()) {
			this.thinksRepository.delete(thinksdb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + thinksId);
		}

	}
}

package com.examen_Luis_Angel_Glez.Examen.ThinksServiceImp;
import java.util.List;

import com.examen_Luis_Angel_Glez.Examen.Model.Thinks;
public interface ThinksService {


	Thinks neww(Thinks thinks);

	
	Thinks update(Thinks thinks);
	
	
	List<Thinks> getAll();


	Thinks getById(long thinksId);

	
	void deleteThinks(long id);
}

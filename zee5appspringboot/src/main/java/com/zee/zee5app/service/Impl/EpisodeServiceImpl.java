package com.zee.zee5app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	private EpisodeRepository episodeRepository;

	@Override
	public String addEpisode(Episodes episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Episodes episode1=this.episodeRepository.save(episode);
		return episode1!=null?"added episodes successfully":"failed to add episode";
	}

	@Override
	public String updateEpisodeById(String id, Episodes episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		try {
			Optional<Episodes> optional=getEpisodeById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else
			{
				this.episodeRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<Episodes> getEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return this.episodeRepository.findById(id);
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodeList() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.episodeRepository.findAll());
	}

	

}

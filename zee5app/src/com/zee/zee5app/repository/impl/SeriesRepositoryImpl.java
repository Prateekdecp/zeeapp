package com.zee.zee5app.repository.impl;

import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.seriesRepo2;

import exception.SeriesNotFoundException;

public class SeriesRepositoryImpl implements seriesRepo2 {

	
	private TreeSet<Series> series=new TreeSet<>();
	private SeriesRepositoryImpl()
	{
		
	}
	private static seriesRepo2 repository;
	
	public static seriesRepo2 getInstance()
	{
		if(repository==null)
			repository=new SeriesRepositoryImpl();
		return repository;
	}
	@Override
	public Series[] getSeries() {
		// TODO Auto-generated method stub
		Series[] result=new Series[series.size()];
		return series.toArray(result);
	}

	@Override
	public String addSeries(Series serie) {
		// TODO Auto-generated method stub
		boolean res=series.add(serie);
		return res?"success":"failure";
	}

	@Override
	public Optional<Series> getSeriesById(String serieId) throws SeriesNotFoundException {
		// TODO Auto-generated method stub
		Series series2=null;
		for (Series serie : series) {
			if(serie!=null && serie.getSeriesId().equals(serieId))
			{
				series2=serie;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(series2)).
				orElseThrow(()->new SeriesNotFoundException("series not found"));
	}

	@Override
	public String modifySeries(String serieId, Series serie) {
		// TODO Auto-generated method stub
		for(Series serie1:series)
		{
			if(serie1!=null && serie1.getSeriesId().equals(serieId))
			{
				serie1=serie;
				return "success";
			}
		}
		return "id does not exist";
	}
	@Override
	public String deleteSeriesById(String id) throws SeriesNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional=getSeriesById(id);
		if(optional.isPresent())
		{
			boolean res=series.remove(optional.get());
			if(res)
				return "success";
			return "failure";
		}
		throw new SeriesNotFoundException("series not found exception");
		
	}
}

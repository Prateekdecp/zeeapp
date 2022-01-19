package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.seriesRepo2;

public class SeriesRepositoryImpl implements seriesRepo2 {

	
	private Series  [] series=new Series[1000];
	private static int count=0;
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
		return series;
	}

	@Override
	public String addSeries(Series serie) {
		// TODO Auto-generated method stub
		if(count==series.length)
		{
			Series temp[]=new Series[series.length*2];
			System.arraycopy(series, 0, temp, 0, series.length);
			series=temp;
		}
		series[count++]=serie;
		return "success";
	}

	@Override
	public Series getSeriesById(String serieId) {
		// TODO Auto-generated method stub
		for (Series serie : series) {
			if(serie!=null && serie.getSeriesId().equals(serieId))
				return serie;
		}
		return null;
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

}

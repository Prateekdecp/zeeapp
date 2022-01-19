package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Movies;
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
	@Override
	public String deleteSeriesById(String id) {
		// TODO Auto-generated method stub
		Series[] temp=new Series[series.length];
		boolean flag=false;
		for(int i=0,k=0;i<series.length;i++)
		{
			if(series[i]!=null && series[i].getSeriesId().equals(id))
			{
				flag=true;
				continue;
			}
			else
			{
				temp[k++]=series[i];
			}
		}
		series=temp;
		return flag?"success":"id was not available";
	}
}

package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.seriesRepo2;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.seriesService2;

public class SeriesServiceImpl implements seriesService2 {
	
	private SeriesServiceImpl()
	{
		
	}
	
	private static seriesService2 series;
	public static seriesService2 getInstance()
	{
		if(series==null)
			series=new SeriesServiceImpl();
		return series;
	}
	seriesRepo2 seriesservice=SeriesRepositoryImpl.getInstance();
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesservice.addSeries(series);
	}

	@Override
	public String updateSeries(String id, Series series) {
		// TODO Auto-generated method stub
		return seriesservice.modifySeries(id, series);
	}

	@Override
	public Series getSeriesById(String id) {
		// TODO Auto-generated method stub
		return seriesservice.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriesservice.getSeries();
	}

	@Override
	public String deleteSeriesById(String id) {
		// TODO Auto-generated method stub
		return seriesservice.deleteSeriesById(id);
	}

}

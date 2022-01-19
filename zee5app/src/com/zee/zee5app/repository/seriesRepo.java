package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;

public class seriesRepo {
	private Series  [] series=new Series[1000];
	private static int count=0;
	
	public Series[] getSeries()
	{
		return series;
	}
	
	public String deleteSeriesById(String id)
	{
		{
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
	
	public String addSeries(Series serie)
	{
		if(count==series.length)
		{
			Series temp[]=new Series[series.length*2];
			System.arraycopy(series, 0, temp, 0, series.length);
			series=temp;
		}
		series[count++]=serie;
		return "success";
	}
	
	public Series getSeriesById(String serieId)
	{
		for (Series serie : series) {
			if(serie!=null && serie.getSeriesId().equals(serieId))
				return serie;
		}
		return null;
	}
	
	public String modifySeries(String serieId,Series serie)
	{
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
	private static seriesRepo repo;
	public static seriesRepo getInstance()
	{
		if(repo==null)
			repo=new seriesRepo();
		return repo;
	}
}

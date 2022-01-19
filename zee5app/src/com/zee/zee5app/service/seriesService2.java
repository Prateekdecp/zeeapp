package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;

public interface seriesService2 {
	public String addSeries(Series series);
	public String updateSeries(String id, Series series);
	public Series getSeriesById(String id);
	public Series[] getAllSeries();
	public String deleteSeriesById(String id);
}

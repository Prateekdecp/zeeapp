package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;

public interface seriesRepo2 {
	public Series[] getSeries();
	public String addSeries(Series serie);
	public Series getSeriesById(String serieId);
	public String modifySeries(String serieId,Series serie);
	public String deleteSeriesById(String id);
}

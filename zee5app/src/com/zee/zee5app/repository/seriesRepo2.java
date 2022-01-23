package com.zee.zee5app.repository;

import java.util.Optional;

import com.zee.zee5app.dto.Series;

import exception.SeriesNotFoundException;

public interface seriesRepo2 {
	public Series[] getSeries();
	public String addSeries(Series serie);
	public Optional<Series> getSeriesById(String serieId) throws SeriesNotFoundException;
	public String modifySeries(String serieId,Series serie);
	public String deleteSeriesById(String id) throws SeriesNotFoundException;
}

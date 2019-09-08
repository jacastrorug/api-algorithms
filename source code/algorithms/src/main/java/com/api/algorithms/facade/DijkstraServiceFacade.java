package com.api.algorithms.facade;

import com.api.algorithms.dto.response.DijkstraResponse;
import com.api.algorithms.utils.graph.Dijkstra;

public interface DijkstraServiceFacade {

    DijkstraResponse minPath(Dijkstra dijkstra);

    DijkstraResponse minPathWithPath(Dijkstra dijkstra);

}

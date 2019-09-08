package com.api.algorithms.facade.impl;

import com.api.algorithms.dto.response.DijkstraResponse;
import com.api.algorithms.facade.DijkstraServiceFacade;
import com.api.algorithms.utils.graph.Dijkstra;
import com.api.algorithms.utils.models.Path;
import org.springframework.stereotype.Service;

@Service
public class DijkstraServiceFacadeImpl implements DijkstraServiceFacade {

    @Override
    public DijkstraResponse minPath(Dijkstra dijkstra) {
        double min = dijkstra.calculateMinPath();
        return new DijkstraResponse(min);
    }

    @Override
    public DijkstraResponse minPathWithPath(Dijkstra dijkstra) {

        double min = dijkstra.calculateMinPath();
        Path path = new Path(dijkstra);
        System.out.println(path.getPath());
        return new DijkstraResponse(min, path.getPath());
    }
}

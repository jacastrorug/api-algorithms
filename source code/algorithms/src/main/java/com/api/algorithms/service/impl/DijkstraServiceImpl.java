package com.api.algorithms.service.impl;

import com.api.algorithms.dto.request.DijkstraRequestDTO;
import com.api.algorithms.dto.response.BaseResponse;
import com.api.algorithms.dto.response.DijkstraResponse;
import com.api.algorithms.facade.DijkstraServiceFacade;
import com.api.algorithms.service.DijkstraService;
import com.api.algorithms.utils.graph.Dijkstra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DijkstraServiceImpl extends BaseService implements DijkstraService {

    @Autowired
    private DijkstraServiceFacade dijkstraServiceFacade;

    public BaseResponse getDistanceDijkstra(DijkstraRequestDTO request) {

        try {
            Dijkstra dijkstra = new Dijkstra(request.getNodes(), request.getEdges(), request.getSource(), request.getTarget());
            if (request.isWithPath()) {
                return dijkstraServiceFacade.minPathWithPath(dijkstra);
            } else {
                return dijkstraServiceFacade.minPath(dijkstra);
            }
        } catch (Exception e) {
            return new BaseResponse("Algo ha salido mal", 409);
        }

    }
}

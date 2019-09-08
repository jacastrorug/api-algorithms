package com.api.algorithms.service;

import com.api.algorithms.dto.request.DijkstraRequestDTO;
import com.api.algorithms.dto.response.BaseResponse;

public interface DijkstraService {
    BaseResponse getDistanceDijkstra(DijkstraRequestDTO request);
}

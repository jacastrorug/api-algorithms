package com.api.algorithms.controller;

import com.api.algorithms.dto.request.DijkstraRequestDTO;
import com.api.algorithms.dto.response.BaseResponse;
import com.api.algorithms.service.DijkstraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.api.algorithms.utils.constants.UrlApi.URL_DIJKSTRA;

@RestController
public class GraphController {

    @Autowired
    private DijkstraService dijkstraService;

    @PostMapping(value = URL_DIJKSTRA, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse dijkstra(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody DijkstraRequestDTO body) {
        return dijkstraService.getDistanceDijkstra(body);
    }

}

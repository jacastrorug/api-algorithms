package com.api.algorithms.controller;

import com.api.algorithms.utils.graph.Dijkstra;
import com.api.algorithms.utils.responses.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.api.algorithms.utils.constants.UrlApi.URL_DIJKSTRA;

@RestController
public class GraphController {

    @PostMapping(value = URL_DIJKSTRA, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage dijkstra(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody Dijkstra body) {

        try {

            Dijkstra dijkstra = new Dijkstra(body.getNodes(), body.getEdges(), body.getSource(), body.getTarget());

            double minPath = dijkstra.calculateMinPath();

            return new ResponseMessage("Resultado éxitoso", httpServletResponse.getStatus(), true);
        } catch (Exception e) {
            return new ResponseMessage(e.getMessage(), httpServletResponse.getStatus(), false);
        }
    }

}

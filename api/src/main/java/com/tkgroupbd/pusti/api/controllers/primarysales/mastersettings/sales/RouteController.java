package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.RouteRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.RouteService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Route")
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> routeSave(@RequestBody RouteRequest routeRequest) {
        MessageResponse newRoute = routeService.saveRoute(routeRequest);
        return new ResponseEntity<>(newRoute, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Route>> getRoute() {
        List<Route> routes = routeService.getAllRoute();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{routeId}")
    public ResponseEntity<?> deleteRoute(@PathVariable("routeId") Integer routeId) {
        routeService.deleteRouteById(routeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{routeId}")
    public ResponseEntity<Route> getRegionById(@PathVariable("routeId") Integer routeId) {
        Route route = routeService.findRouteById(routeId);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @PutMapping("/update/{routeId}")
    public ResponseEntity<Optional<Route>> updateRoute(@PathVariable Integer routeId,
            @RequestBody RouteRequest routeRequest) {
        Optional<Route> route = routeService.updateRoute(routeId, routeRequest);
        return new ResponseEntity<Optional<Route>>(route, HttpStatus.OK);
    }

    @PutMapping("/statusChange/{route_id}")
    public ResponseEntity<Optional<Route>> updateRouteStatus(@PathVariable Integer route_id,
            @RequestBody RouteRequest routeRequest) {
        Optional<Route> route = routeService.updateRouteStatus(route_id, routeRequest);
        return new ResponseEntity<Optional<Route>>(route, HttpStatus.OK);
    }

    @GetMapping("/getSortedByKey/{field}")
    private ApiResponse<List<Route>> getSortedRouteByKey(@PathVariable String field) {
        List<Route> routes = routeService.findSortedRouteByKey(field);
        return new ApiResponse(routes.size(), routes);
    }
}

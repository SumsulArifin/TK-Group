package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.RouteRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.RouteRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Override
    public MessageResponse saveRoute(RouteRequest routeRequest) {
        Route route = new Route();
        route.setName(routeRequest.getName());
        route.setStatus(routeRequest.isStatus());
        route.setCreatedAt(routeRequest.getCreatedAt());
        route.setUpdatedAt(routeRequest.getUpdatedAt());
        route.setDeletedAt(routeRequest.getDeletedAt());
        route.setBrowser(routeRequest.getBrowser());
        route.setIp(routeRequest.getIp());
        route.setZone(routeRequest.getZone());

        routeRepository.save(route);
        return new MessageResponse(Message.SUCCESS_CREATION);

    }

    @Override
    public Optional<Route> updateRoute(int routeId, RouteRequest routeRequest) {
        Optional<Route> route = routeRepository.findById(routeId);
        if (route.isEmpty()) {
            throw new ResourceNotFoundException("Route", "routeId", routeId);
        } else
            route.get().setName(routeRequest.getName());
        route.get().setStatus(routeRequest.isStatus());
        route.get().setCreatedAt(routeRequest.getCreatedAt());
        route.get().setUpdatedAt(routeRequest.getUpdatedAt());
        route.get().setDeletedAt(routeRequest.getDeletedAt());
        route.get().setBrowser(routeRequest.getBrowser());
        route.get().setIp(routeRequest.getIp());
        route.get().setZone(routeRequest.getZone());

        routeRepository.save(route.get());
        return route;
    }

    @Override
    public void deleteRouteById(int routeId) {
        routeRepository.deleteById(routeId);
    }

    @Override
    public Optional<Route> updateRouteStatus(int routeId, RouteRequest routeRequest) {
        Optional<Route> route = routeRepository.findById(routeId);
        if (route.isEmpty()) {
            throw new ResourceNotFoundException("Route", "routeId", routeId);
        } else
            route.get().setStatus(routeRequest.isStatus());
        ;
        routeRepository.save(route.get());
        return route;
    }

    @Override
    public List<Route> findSortedRouteByKey(String field) {
        return routeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public List<Route> getAllRoute() {
        return routeRepository.findAll();
    }

    @Override
    public Route findRouteById(int route_id) {
        return routeRepository.findById(route_id).get();
    }
}

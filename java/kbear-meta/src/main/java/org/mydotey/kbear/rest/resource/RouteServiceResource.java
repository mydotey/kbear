package org.mydotey.kbear.rest.resource;

import javax.inject.Inject;

import org.mydotey.kbear.rest.RestConfig;
import org.mydotey.kbear.route.FetchConsumerRouteRequest;
import org.mydotey.kbear.route.FetchConsumerRouteResponse;
import org.mydotey.kbear.route.FetchProducerRouteRequest;
import org.mydotey.kbear.route.FetchProducerRouteResponse;
import org.mydotey.kbear.route.FetchRouteRulesRequest;
import org.mydotey.kbear.route.FetchRouteRulesResponse;
import org.mydotey.kbear.route.RouteService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author koqizhao
 *
 * Sep 21, 2018
 */
@RequestMapping(path = "/route", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
        RestConfig.APPLICATION_PROTOBUF_VALUE })
@RestController
public class RouteServiceResource {

    @Inject
    private RouteService _service;

    @RequestMapping(path = "/rules/all", method = RequestMethod.GET, consumes = "*/*", produces = "*/*")
    public FetchRouteRulesResponse fetchRouteRule() {
        return _service.fetchRouteRules(null);
    }

    @RequestMapping("/rules")
    public FetchRouteRulesResponse fetchRouteRule(@RequestBody FetchRouteRulesRequest request) {
        return _service.fetchRouteRules(request);
    }

    @RequestMapping("/producer")
    public FetchProducerRouteResponse fetchProducerRoute(@RequestBody FetchProducerRouteRequest request) {
        return _service.fetchProducerRoute(request);
    }

    @RequestMapping("/consumer")
    public FetchConsumerRouteResponse fetchConsumerRoute(@RequestBody FetchConsumerRouteRequest request) {
        return _service.fetchConsumerRoute(request);
    }

}

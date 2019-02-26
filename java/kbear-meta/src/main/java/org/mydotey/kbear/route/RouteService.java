package org.mydotey.kbear.route;

import org.mydotey.kbear.route.FetchConsumerRouteRequest;
import org.mydotey.kbear.route.FetchConsumerRouteResponse;
import org.mydotey.kbear.route.FetchProducerRouteRequest;
import org.mydotey.kbear.route.FetchProducerRouteResponse;
import org.mydotey.kbear.route.FetchRouteRulesRequest;
import org.mydotey.kbear.route.FetchRouteRulesResponse;

public interface RouteService {

    FetchRouteRulesResponse fetchRouteRules(FetchRouteRulesRequest request);

    FetchProducerRouteResponse fetchProducerRoute(FetchProducerRouteRequest request);

    FetchConsumerRouteResponse fetchConsumerRoute(FetchConsumerRouteRequest request);

}

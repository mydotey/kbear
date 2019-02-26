package org.mydotey.kbear.route;

import java.util.Map;

import org.mydotey.kbear.route.Route;

/**
 * @author koqizhao
 *
 * Nov 14, 2018
 */
public interface RouteRule {

    String getId();

    int getPriority();

    Map<String, String> getMeta();

    Route apply(Map<String, String> routeFactors);

}

package org.mydotey.kbear.route.crrl;

import org.mydotey.kbear.route.Route;

/**
 * @author koqizhao
 *
 * Nov 14, 2018
 */
public interface CrrlStatement {

    Route getRoute();

    CrrlCriteria getCriteria();

}

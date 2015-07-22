/* Copyright (c) 2015 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhims.oauth2.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableAsync;



@Configuration
@EnableAsync
public class PropertiesConfiguration 
{
	private final Logger log = Logger.getLogger(this.getClass());
	private final boolean IGNORE_UNRESOLVABLE_PLACEHOLDERS = true;
	public PropertySourcesPlaceholderConfigurer getProperties()
	{
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new Resource[]
				{
					new ClassPathResource("properties/application.properties"),
					new ClassPathResource("properties/server.properties")
				};
		pspc.setLocations(resources);
		pspc.setIgnoreUnresolvablePlaceholders(IGNORE_UNRESOLVABLE_PLACEHOLDERS);
		pspc.setIgnoreResourceNotFound(true);
		return pspc;
	}
}

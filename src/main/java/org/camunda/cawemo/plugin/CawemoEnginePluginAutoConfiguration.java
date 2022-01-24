/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.cawemo.plugin;

import java.util.Optional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(CawemoEnginePlugin.class)
@ConditionalOnMissingBean(CawemoEnginePlugin.class)
@EnableConfigurationProperties(CawemoEnginePluginProperties.class)
public class CawemoEnginePluginAutoConfiguration {

  @Bean
  public CawemoEnginePlugin cawemoEnginePlugin(CawemoEnginePluginProperties properties) {
    CawemoEnginePlugin plugin = new CawemoEnginePlugin();

    plugin.setCawemoUrl(properties.getCawemoUrl());
    plugin.setUserId(properties.getUserId());
    plugin.setApiKey(properties.getApiKey());
    plugin.setProjectName(properties.getProjectName());
    plugin.setAuthMode(properties.getAuthMode().name());

    Optional.ofNullable(properties.getCustomBasicAuth())
      .ifPresent(customBasicAuth -> {
        plugin.setCustomBasicAuth(true);
        plugin.setCustomBasicAuthUser(customBasicAuth.getUser());
        plugin.setCustomBasicAuthUser(customBasicAuth.getPassword());
      });

    return plugin;
  }
}

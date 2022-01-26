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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.camunda.cawemo.plugin.util.AuthMode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

@Getter
@RequiredArgsConstructor
@Validated
@ConstructorBinding
@ConfigurationProperties("camunda.cawemo")
public class CawemoEnginePluginProperties {

  @NotBlank
  private final String cawemoUrl;

  @NotBlank
  private final String userId;

  @NotBlank
  private final String apiKey;

  @NotBlank
  private final String projectName;

  @NotNull
  private final AuthMode authMode;

  /**
   * Can be used with {@link CawemoEnginePluginProperties#authMode}={@link AuthMode#QUERY_PARAM} only.
   */
  @Valid
  @NestedConfigurationProperty
  private final CustomBasicAuth customBasicAuth;

  @Getter
  @RequiredArgsConstructor
  @ConstructorBinding
  public static class CustomBasicAuth {

    @NotBlank
    private final String user;

    @NotBlank
    private final String password;
  }
}

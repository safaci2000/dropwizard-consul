/**
 * Copyright 2016 Smoke Turner, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smoketurner.dropwizard.consul;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;

public class ConsulFactory {
    @NotNull
    @JsonProperty
    private HostAndPort endpoint;

    public HostAndPort getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(HostAndPort endpoint) {
        this.endpoint = endpoint;
    }

    public String getHost() {
        return endpoint.getHostText();
    }

    public int getPort() {
        return endpoint.getPortOrDefault(Consul.DEFAULT_HTTP_PORT);
    }

    public Consul build() {
        final Consul consul = Consul.builder().withHostAndPort(endpoint)
                .build();
        return consul;
    }
}
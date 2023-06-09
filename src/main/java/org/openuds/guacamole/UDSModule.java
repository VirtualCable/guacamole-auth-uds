/*
 * Copyright (c) 2015 Virtual Cable S.L.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    * Redistributions of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *    * Neither the name of Virtual Cable S.L. nor the names of its contributors
 *      may be used to endorse or promote products derived from this software
 *      without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.openuds.guacamole;

import com.google.inject.AbstractModule;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.environment.Environment;
import org.apache.guacamole.environment.LocalEnvironment;
import org.openuds.guacamole.config.ConfigurationService;
import org.openuds.guacamole.connection.ConnectionService;

/**
 * Guice module which binds classes required by the OpenUDS integration of
 * Apache Guacamole.
 */
public class UDSModule extends AbstractModule {

    /**
     * The Guacamole server environment.
     */
    private final Environment environment;

    /**
     * Creates a new UDSModule which binds classes required by the OpenUDS
     * integration of Apache Guacamole, including an implementation of the
     * Guacamole server {@link Environment}.
     *
     * @throws GuacamoleException
     *     If the guacamole.properties file cannot be read.
     */
    public UDSModule() throws GuacamoleException {
        this.environment = LocalEnvironment.getInstance();
    }

    @Override
    protected void configure() {

        // Bind instance of Guacamole server environment
        bind(Environment.class).toInstance(environment);

        // Bind UDS-specific services
        bind(ConfigurationService.class);
        bind(ConnectionService.class);

    }
    
}

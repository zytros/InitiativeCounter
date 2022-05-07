/*
 * (C) Copyright 2019 Boni Garcia (https://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.wdm.managers;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

/**
 * Void manager.
 *
 * @author Boni Garcia
 * @since 3.2.0
 */
public class VoidDriverManager extends WebDriverManager {

    @Override
    protected List<URL> getDriverUrls(String driverVersion) throws IOException {
        return emptyList();
    }

    @Override
    protected Optional<String> getBrowserVersionFromTheShell() {
        return empty();
    }

    @Override
    protected String getDriverVersion() {
        return "";
    }

    @Override
    protected URL getDriverUrl() {
        return null;
    }

    @Override
    protected Optional<URL> getMirrorUrl() {
        return empty();
    }

    @Override
    protected Optional<String> getExportParameter() {
        return empty();
    }

    @Override
    public DriverManagerType getDriverManagerType() {
        return null;
    }

    @Override
    protected String getDriverName() {
        return "";
    }

    @Override
    protected void setDriverVersion(String driverVersion) {
        // Nothing required
    }

    @Override
    protected void setDriverUrl(URL url) {
        // Nothing required
    }

    @Override
    protected Optional<String> getDriverVersionFromRepository(
            Optional<String> driverVersion) {
        return empty();
    }

    @Override
    protected String getBrowserVersion() {
        return "";
    }

    @Override
    protected void setBrowserVersion(String browserVersion) {
        // Nothing required
    }

    @Override
    public WebDriverManager exportParameter(String exportParameter) {
        return this;
    }

}

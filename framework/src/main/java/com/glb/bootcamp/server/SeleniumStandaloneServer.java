package com.glb.bootcamp.server;

import org.openqa.grid.internal.utils.configuration.StandaloneConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;

import static java.lang.Runtime.getRuntime;

/**
 * SeleniumStandaloneServer makes possible to start and stop a selenium standalone server instance.
 */
public enum SeleniumStandaloneServer {

    SERVER;

    private SeleniumServer seleniumServer;

    private boolean notStarted = true;

    /**
     * Starts the {@link SeleniumServer} using the standalone configuration.
     */
    public void start() {
        if (notStarted) {
            seleniumServer = new SeleniumServer(new StandaloneConfiguration());
            getRuntime().addShutdownHook(new Thread(this::stop));
            seleniumServer.boot();
            notStarted = false;
        }
        // TODO: Logging that the server is already started.
    }

    /**
     * Stops the {@link SeleniumServer}.
     */
    public void stop() {
        seleniumServer.stop();
        notStarted = true;
    }

}

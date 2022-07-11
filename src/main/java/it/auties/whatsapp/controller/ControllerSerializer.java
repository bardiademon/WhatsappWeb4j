package it.auties.whatsapp.controller;

/**
 * This interface provides a standardized way to serialize a session.
 * Implement this interface and <a href="https://www.baeldung.com/java-spi#3-service-provider">register it in your manifest</a>
 */
public interface ControllerSerializer {
    /**
     * Serializes a controller
     *
     * @param controller the non-null controller to serialize
     */
    void serialize(Controller<?> controller);
}

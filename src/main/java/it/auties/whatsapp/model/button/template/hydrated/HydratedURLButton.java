package it.auties.whatsapp.model.button.template.hydrated;

import it.auties.protobuf.base.ProtobufProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import static it.auties.protobuf.base.ProtobufType.STRING;

/**
 * A model class that represents a hydrated url button
 */
@AllArgsConstructor(staticName = "of")
@Data
@Builder
@Jacksonized
@Accessors(fluent = true)
public final class HydratedURLButton implements HydratedButton {
    /**
     * The text of this button
     */
    @ProtobufProperty(index = 1, type = STRING)
    private String text;

    /**
     * The url of this button
     */
    @ProtobufProperty(index = 2, type = STRING)
    private String url;

    @Override
    public HydratedButtonType buttonType() {
        return HydratedButtonType.URL;
    }
}

package it.auties.whatsapp.model.button.misc;

import it.auties.protobuf.base.ProtobufMessage;
import it.auties.protobuf.base.ProtobufName;
import it.auties.protobuf.base.ProtobufProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import static it.auties.protobuf.base.ProtobufType.STRING;

/**
 * A model class that represents the selection of a row
 */
@AllArgsConstructor(staticName = "of")
@Data
@Builder
@Jacksonized
@Accessors(fluent = true)
@ProtobufName("SingleSelectReply")
public class SingleSelectReplyButton implements ProtobufMessage {
    /**
     * The id of the selected row
     */
    @ProtobufProperty(index = 1, type = STRING)
    private String rowId;
}
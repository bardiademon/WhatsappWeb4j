package it.auties.whatsapp.model.action;

import it.auties.protobuf.base.ProtobufName;
import it.auties.protobuf.base.ProtobufProperty;
import it.auties.whatsapp.binary.BinaryPatchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import static it.auties.protobuf.base.ProtobufType.STRING;

/**
 * A model clas that represents the assignment of a chat
 */
@AllArgsConstructor
@Data
@Accessors(fluent = true)
@Jacksonized
@Builder
@ProtobufName("ChatAssignmentAction")
public final class ChatAssignmentAction implements Action {
    /**
     * The device agent id
     */
    @ProtobufProperty(index = 1, name = "deviceAgentID", type = STRING)
    private String deviceAgentId;

    /**
     * The name of this action
     *
     * @return a non-null string
     */
    @Override
    public String indexName() {
        return "agentChatAssignment";
    }

    /**
     * The version of this action
     *
     * @return a non-null string
     */
    @Override
    public int actionVersion() {
        return 7;
    }

    /**
     * The type of this action
     *
     * @return a non-null string
     */
    @Override
    public BinaryPatchType actionType() {
        return null;
    }
}

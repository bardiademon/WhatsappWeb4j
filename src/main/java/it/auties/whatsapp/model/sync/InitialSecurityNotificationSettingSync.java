package it.auties.whatsapp.model.sync;

import it.auties.protobuf.base.ProtobufMessage;
import it.auties.protobuf.base.ProtobufProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import static it.auties.protobuf.base.ProtobufType.BOOL;

@AllArgsConstructor
@Data
@Builder
@Jacksonized
@Accessors(fluent = true)
public class InitialSecurityNotificationSettingSync implements ProtobufMessage {
    @ProtobufProperty(index = 1, type = BOOL)
    private boolean securityNotificationEnabled;
}

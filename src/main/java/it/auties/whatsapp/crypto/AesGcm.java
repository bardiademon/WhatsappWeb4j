package it.auties.whatsapp.crypto;

import it.auties.whatsapp.util.BytesHelper;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;

@UtilityClass
public class AesGcm {
    private final int NONCE = 128;

    public byte[] encrypt(long iv, byte @NonNull [] input, byte @NonNull [] key) {
        return encrypt(iv, input, key, null);
    }

    public byte[] encrypt(long iv, byte @NonNull [] input, byte @NonNull [] key, byte[] additionalData) {
        return cipher(toIv(iv), input, key, additionalData, true);
    }

    private byte[] cipher(byte @NonNull [] iv, byte @NonNull [] input, byte @NonNull [] key, byte[] additionalData, boolean encrypt) {
        try {
            var cipher = new GCMBlockCipher(new AESEngine());
            var parameters = new AEADParameters(new KeyParameter(key), NONCE, iv, additionalData);
            cipher.init(encrypt, parameters);
            var outputLength = cipher.getOutputSize(input.length);
            var output = new byte[outputLength];
            var outputOffset = cipher.processBytes(input, 0, input.length, output, 0);
            cipher.doFinal(output, outputOffset);
            return output;
        } catch (InvalidCipherTextException exception) {
            throw new RuntimeException("Cannot %s data".formatted(encrypt ? "encrypt" : "decrypt"), exception);
        }
    }

    private byte[] toIv(long iv) {
        var buffer = BytesHelper.newBuffer();
        buffer.writeBytes(new byte[4]);
        buffer.writeLong(iv);
        return BytesHelper.readBuffer(buffer);
    }

    public byte[] decrypt(long iv, byte @NonNull [] input, byte @NonNull [] key) {
        return decrypt(iv, input, key, null);
    }

    public byte[] decrypt(long iv, byte @NonNull [] input, byte @NonNull [] key, byte[] additionalData) {
        return cipher(toIv(iv), input, key, additionalData, false);
    }

    public byte[] encrypt(byte @NonNull [] iv, byte @NonNull [] input, byte @NonNull [] key, byte[] additionalData) {
        return cipher(iv, input, key, additionalData, true);
    }

    public byte[] encrypt(byte @NonNull [] iv, byte @NonNull [] input, byte @NonNull [] key) {
        return cipher(iv, input, key, null, true);
    }

    public byte[] decrypt(byte @NonNull [] iv, byte @NonNull [] input, byte @NonNull [] key, byte[] additionalData) {
        return cipher(iv, input, key, additionalData, false);
    }
}

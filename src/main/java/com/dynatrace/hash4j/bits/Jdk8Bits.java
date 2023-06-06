package com.dynatrace.hash4j.bits;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * JDK8 implementation of {@link Bits} using ByteBuffer
 */
public class Jdk8Bits implements Bits {
    @Override
    public long getLong(byte[] bytes, int offset) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        return buf.getLong(offset);
    }

    @Override
    public void setLong(byte[] bytes, int offset, long value) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        buf.putLong(offset, value);
    }

    @Override
    public int getInt(byte[] bytes, int offset) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        return buf.getInt(offset);
    }

    @Override
    public void setInt(byte[] bytes, int offset, int value) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        buf.putInt(offset, value);
    }

    @Override
    public char getChar(byte[] bytes, int offset) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        return buf.getChar(offset);
    }

    @Override
    public void setChar(byte[] bytes, int offset, char value) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        buf.putChar(offset, value);
    }

    @Override
    public short getShort(byte[] bytes, int offset) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        return buf.getShort(offset);
    }

    @Override
    public void setShort(byte[] bytes, int offset, short value) {
        var buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        buf.putShort(offset, value);
    }
}

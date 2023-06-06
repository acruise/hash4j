package com.dynatrace.hash4j.bits;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

/**
 * JDK11 implementation of {@link Bits} using MethodHandles
 */
public class Jdk11Bits implements Bits {
    private static final VarHandle LONG_HANDLE =
            MethodHandles.byteArrayViewVarHandle(long[].class, ByteOrder.LITTLE_ENDIAN);
    private static final VarHandle INT_HANDLE =
            MethodHandles.byteArrayViewVarHandle(int[].class, ByteOrder.LITTLE_ENDIAN);
    private static final VarHandle SHORT_HANDLE =
            MethodHandles.byteArrayViewVarHandle(short[].class, ByteOrder.LITTLE_ENDIAN);
    private static final VarHandle CHAR_HANDLE =
            MethodHandles.byteArrayViewVarHandle(char[].class, ByteOrder.LITTLE_ENDIAN);

    @Override
    public long getLong(byte[] bytes, int offset) {
        return (long)LONG_HANDLE.get(bytes, offset);
    }

    @Override
    public int getInt(byte[] bytes, int offset) {
        return (int)INT_HANDLE.get(bytes, offset);
    }

    @Override
    public char getChar(byte[] bytes, int offset) {
        return (char)CHAR_HANDLE.get(bytes, offset);
    }

    @Override
    public short getShort(byte[] bytes, int offset) {
        return (short)SHORT_HANDLE.get(bytes, offset);
    }

    @Override
    public void setLong(byte[] bytes, int offset, long value) {
        LONG_HANDLE.set(bytes, offset, value);
    }

    @Override
    public void setInt(byte[] bytes, int offset, int value) {
        INT_HANDLE.set(bytes, offset, value);
    }

    @Override
    public void setChar(byte[] bytes, int offset, char value) {
        CHAR_HANDLE.set(bytes, offset, value);
    }

    @Override
    public void setShort(byte[] bytes, int offset, short value) {
        SHORT_HANDLE.set(bytes, offset, value);
    }
}

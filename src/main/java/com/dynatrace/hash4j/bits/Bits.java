package com.dynatrace.hash4j.bits;

/**
 * Machinery for reading and writing JVM primitives to/from byte arrays
 */
public interface Bits {
    long getLong(byte[] bytes, int offset);
    void setLong(byte[] bytes, int offset, long value);
    int getInt(byte[] bytes, int offset);
    void setInt(byte[] bytes, int offset, int value);
    char getChar(byte[] bytes, int offset);
    void setChar(byte[] bytes, int offset, char value);
    short getShort(byte[] bytes, int offset);
    void setShort(byte[] bytes, int offset, short value);
}

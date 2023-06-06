/*
 * Copyright 2022-2023 Dynatrace LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dynatrace.hash4j.hashing;

import com.dynatrace.hash4j.bits.Bits;
import com.dynatrace.hash4j.bits.Jdk8Bits;

abstract class AbstractHasher implements Hasher {
  private static final Bits bits = new Jdk8Bits(); // TODO branch this for JDK8 too
  protected AbstractHasher() {}

  /**
   * Returns as a long the most significant 64 bits of the unsigned 128-bit product of two unsigned
   * 64-bit factors.
   *
   * <p>This function was added in <a
   * href="https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#unsignedMultiplyHigh(long,long)">Java
   * 18</a> and potentially can be removed in future.
   *
   * @param x the first value
   * @param y the second value
   * @return the result
   */
  protected static long unsignedMultiplyHigh(long x, long y) {
    long result;
    // TODO this is inlined from JDK code; licensing?
    if (x < 0 || y < 0) {
        // Use technique from section 8-2 of Henry S. Warren, Jr.,
        // Hacker's Delight (2nd ed.) (Addison Wesley, 2013), 173-174.
        long x1 = x >> 32;
        long x2 = x & 0xFFFFFFFFL;
        long y1 = y >> 32;
        long y2 = y & 0xFFFFFFFFL;
        long z2 = x2 * y2;
        long t = x1 * y2 + (z2 >>> 32);
        long z1 = t & 0xFFFFFFFFL;
        long z0 = t >> 32;
        z1 += x2 * y1;
      result = x1 * y1 + z0 + (z1 >> 32);
    } else {
        // Use Karatsuba technique with two base 2^32 digits.
        long x1 = x >>> 32;
        long y1 = y >>> 32;
        long x2 = x & 0xFFFFFFFFL;
        long y2 = y & 0xFFFFFFFFL;
        long A = x1 * y1;
        long B = x2 * y2;
        long C = (x1 + x2) * (y1 + y2);
        long K = C - A - B;
      result = (((B >>> 32) + K) >>> 32) + A;
    }
    return result + ((x >> 63) & y) + ((y >> 63) & x);
  }

  protected static char getChar(byte[] b, int off) {
    return bits.getChar(b, off);
  }

  protected static short getShort(byte[] b, int off) {
    return bits.getShort(b, off);
  }

  protected static int getInt(byte[] b, int off) {
    return bits.getInt(b, off);
  }

  protected static long getLong(byte[] b, int off) {
    return bits.getLong(b, off);
  }

  protected static void setLong(byte[] b, int off, long v) {
    bits.setLong(b, off, v);
  }

  protected static void setInt(byte[] b, int off, int v) {
    bits.setInt(b, off, v);
  }

  protected static void setShort(byte[] b, int off, short v) {
    bits.setShort(b, off, v);
  }

  protected static long getLong(CharSequence s, int off) {
    return (long) s.charAt(off)
        | ((long) s.charAt(off + 1) << 16)
        | ((long) s.charAt(off + 2) << 32)
        | ((long) s.charAt(off + 3) << 48);
  }

  protected static int getInt(CharSequence s, int off) {
    return (int) s.charAt(off) | ((int) s.charAt(off + 1) << 16);
  }

  protected static void setChar(byte[] b, int off, char v) {
    bits.setChar(b, off, v);
  }
}

/*
 * Copyright 2022 Dynatrace LLC
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

class Murmur3_128Test extends AbstractHashCalculatorTest {

  private static final AbstractHasher128 HASHER = Murmur3_128.create(0xfc64a346);

  @Override
  protected HashCalculator createHashCalculator() {
    return HASHER.newHashCalculator();
  }

  @Override
  protected Hasher64 createHasher() {
    return Hashing.murmur3_128(0xfc64a346);
  }
}
